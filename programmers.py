import argparse
import re
from pathlib import Path

# 현재 스크립트 위치 기준으로 상대 경로 설정
BASE_DIR = Path(__file__).parent

ALG_TABLE_START = '| 번호 | 체크 | 문제 | 풀이 |'
ALG_TABLE_END = '## SQL'

def get_problem_number(line):
    m = re.match(r'\|\s*(\d+)\s*\|', line)
    return int(m.group(1)) if m else 0

def get_last_problem_number(lines):
    return max(get_problem_number(line) for line in lines)

def make_solution_path(number, name, lang, level):
    # 언어별 확장자
    ext = {
        'Java': 'java',
        'Kotlin': 'kt',
        # 필요시 추가
    }[lang]
    # 파일명 규칙: _번호_문제이름/Solution.확장자
    safe_name = name.replace(' ', '_')
    return f'./solution/_{number}_{safe_name}/Solution.{ext}', ext

def create_solution_file(solution_path, lang, problem_url, readme_path, ext):
    # README.md 위치 기준으로 상대 경로 설정
    solution_dir = Path(readme_path).parent / solution_path.lstrip('./')
    solution_dir = solution_dir.parent  # Solution.java 파일의 부모 디렉토리
    solution_dir.mkdir(parents=True, exist_ok=True)
    
    # Java 템플릿
    if lang == 'Java':
        # README.md의 상위 디렉토리 이름을 가져옴 (programmers)
        platform_dir = readme_path.parent.parent.name  # programmers
        level_dir = readme_path.parent.name  # Level0
        # solution 디렉토리 이름을 가져옴 (_160_x_사이의_개수)
        solution_dir_name = solution_dir.name
        # package 경로 생성
        package_name = f"{platform_dir}.{level_dir}.solution.{solution_dir_name}"
        
        template = f'''package {package_name};

/**
 * {problem_url}?language=java
 */
class Solution {{
    
    public static void main(String[] args) {{
       
    }}
}}
'''
    # Kotlin 템플릿
    elif lang == 'Kotlin':
        template = f'''/**
 * {problem_url}?language=kotlin
 */
class Solution {{
    fun solution(input: String): String {{
        var answer = ""
        // TODO: 문제 풀이
        return answer
    }}
}}
'''
    
    # 파일 생성
    solution_file = solution_dir / f'Solution.{ext}'
    with open(solution_file, 'w', encoding='utf-8') as f:
        f.write(template)

def format_check_mark(check):
    # 체크 표시가 있으면 :white_check_mark:, 없으면 20칸 공백
    return ':white_check_mark:' if check else ' ' * 18

def get_readme_path(level):
    return BASE_DIR / "programmers" / f"Level{level}" / "README.md"

def main():
    parser = argparse.ArgumentParser(description='프로그래머스 README.md에 문제 자동 추가')
    parser.add_argument('--name', required=True, help='문제 이름')
    parser.add_argument('--url', required=True, help='문제 URL')
    parser.add_argument('--lang', default='Java', choices=['Java', 'Kotlin'], help='풀이 언어')
    parser.add_argument('--check', default='', help='체크 표시(기본 공백)')
    parser.add_argument('--level', type=int, required=True, choices=range(6), help='프로그래머스 레벨 (0-5)')
    args = parser.parse_args()

    README_PATH = get_readme_path(args.level)

    if not README_PATH.exists():
        print(f"Error: README.md not found at {README_PATH}")
        return

    with open(README_PATH, encoding='utf-8') as f:
        lines = f.readlines()

    # 알고리즘 표 범위 찾기
    try:
        start_idx = next(i for i, l in enumerate(lines) if ALG_TABLE_START in l)
        end_idx = next(i for i, l in enumerate(lines) if ALG_TABLE_END in l)
    except StopIteration:
        print("Error: Could not find algorithm table in README.md")
        return

    # 표의 헤더와 내용 분리
    header = lines[start_idx:start_idx+2]  # 헤더 2줄
    table_lines = lines[start_idx+2:end_idx]  # 내용

    # 표 내용에서 빈 줄(공백 행) 제거
    table_lines = [line for line in table_lines if line.strip()]

    last_num = get_last_problem_number(table_lines)
    new_num = last_num + 1

    solution_path, ext = make_solution_path(new_num, args.name, args.lang, args.level)
    check_mark = format_check_mark(args.check)
    new_row = f'| {new_num} | {check_mark} | [{args.name}]({args.url}) | [{args.lang}]({solution_path}) |\n'

    # 새 행 추가하고 번호 순으로 정렬
    table_lines.append(new_row)
    table_lines.sort(key=get_problem_number)

    # 정렬된 내용으로 파일 업데이트
    lines[start_idx:end_idx] = header + table_lines + ['\n']  # SQL 섹션 위에 엔터 추가

    with open(README_PATH, 'w', encoding='utf-8') as f:
        f.writelines(lines)

    # Solution 파일 생성
    create_solution_file(solution_path, args.lang, args.url, README_PATH, ext)

    print(f'문제 추가 완료: {new_row.strip()}')
    print(f'Solution 파일 생성 완료: {solution_path}')

if __name__ == '__main__':
    main() 
