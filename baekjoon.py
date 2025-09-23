import argparse
import re
from pathlib import Path

# 현재 스크립트 위치 기준으로 상대 경로 설정
BASE_DIR = Path(__file__).parent

ALG_TABLE_START = '| 번호 | 체크 | 문제 | 풀이 |'
ALG_TABLE_END = '## 단계별로 풀어보기'

def get_problem_number(line):
    m = re.match(r'\|\s*(\d+)\s*\|', line)
    return int(m.group(1)) if m else 0

def get_last_problem_number(lines):
    return max(get_problem_number(line) for line in lines)

def make_solution_path(number, name, lang):
    # 언어별 확장자
    ext = {
        'Python': 'py',
        'Java': 'java',
        'Kotlin': 'kt',
        # 필요시 추가
    }[lang]
    # 파일명 규칙: _번호_문제이름/Main.확장자 (번호는 3자리로 포맷팅)
    safe_name = name.replace(' ', '_')
    formatted_number = f"{number:03d}"  # 3자리 숫자로 포맷팅
    return f'./problem/_{formatted_number}_{safe_name}/Main.{ext}', ext

def create_solution_file(solution_path, lang, problem_url, readme_path, ext):
    # README.md 위치 기준으로 상대 경로 설정
    solution_dir = Path(readme_path).parent / solution_path.lstrip('./')
    solution_dir = solution_dir.parent  # Solution 파일의 부모 디렉토리
    solution_dir.mkdir(parents=True, exist_ok=True)
    
    # Python 템플릿
    if lang == 'Python':
        template = f'''"""
{problem_url}
"""

def solution():
    pass

if __name__ == "__main__":
    solution()
'''
    # Java 템플릿
    elif lang == 'Java':
        template = f'''/**
 * {problem_url}
 */
public class Main {{
    public static void main(String[] args) {{
        // TODO: 문제 풀이
    }}
}}
'''
    # Kotlin 템플릿
    elif lang == 'Kotlin':
        template = f'''/**
 * {problem_url}
 */
class Solution {{
    fun main() {{
        // TODO: 문제 풀이
    }}
}}
'''
    
    # 파일 생성
    solution_file = solution_dir / f'Main.{ext}'
    with open(solution_file, 'w', encoding='utf-8') as f:
        f.write(template)

def format_check_mark(check):
    # 체크 표시가 있으면 :white_check_mark:, 없으면 18칸 공백
    return ':white_check_mark:' if check else ' ' * 18

def format_problem_number(number):
    # 문제 번호를 3자리로 포맷팅
    return f"{number:03d}"

def get_readme_path():
    return BASE_DIR / "baekjoon" / "README.md"

def main():
    parser = argparse.ArgumentParser(description='백준 README.md에 문제 자동 추가')
    parser.add_argument('--name', required=True, help='문제 이름')
    parser.add_argument('--url', required=True, help='문제 URL')
    parser.add_argument('--lang', default='Python', choices=['Python', 'Java', 'Kotlin'], help='풀이 언어')
    parser.add_argument('--check', default='', help='체크 표시(기본 공백)')
    args = parser.parse_args()

    README_PATH = get_readme_path()

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

    last_num = get_last_problem_number(table_lines)
    new_num = last_num + 1

    solution_path, ext = make_solution_path(new_num, args.name, args.lang)
    check_mark = format_check_mark(args.check)
    formatted_num = format_problem_number(new_num)
    new_row = f'| {formatted_num} | {check_mark} | [{args.name}]({args.url}) | [{args.lang}]({solution_path}) |\n'

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
