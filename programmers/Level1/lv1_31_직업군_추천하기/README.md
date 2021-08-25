# [직업군 추천하기](https://programmers.co.kr/learn/courses/30/lessons/84325)

## 문제 설명
개발자가 사용하는 언어와 언어 선호도를 입력하면 그에 맞는 직업군을 추천해주는 알고리즘을 개발하려고 합니다.

아래 표는 5개 직업군 별로 많이 사용하는 5개 언어에 직업군 언어 점수를 부여한 표입니다.

|점수|SI|CONTENTS|HARDWARE|PORTAL|GAME|
|---|---|---|---|---|---|
|5|JAVA|JAVASCRIPT|C|JAVA|C++|
|4|JAVASCRIPT|JAVA|C++|JAVASCRIPT|C#|
|3|SQL|PYTHON|PYTHON|PYTHON|JAVASCRIPT|
|2|PYTHON|SQL|JAVA|KOTLIN|C|
|1|C#|C++|JAVASCRIPT|PHP|JAVA|

예를 들면, SQL의 SI 직업군 언어 점수는 3점이지만 CONTENTS 직업군 언어 점수는 2점입니다.  
SQL의 HARDWARE, PORTAL, GAME 직업군 언어 점수는 0점입니다.

직업군 언어 점수를 정리한 문자열 배열 `table`, 개발자가 사용하는 언어를 담은 문자열 배열 `languages`, 언어 선호도를 담은 정수 배열 `preference`가 매개변수로 주어집니다.  
개발자가 사용하는 언어의 언어 선호도 x 직업군 언어 점수의 총합이 가장 높은 직업군을 return 하도록 solution 함수를 완성해주세요.  
총합이 같은 직업군이 여러 개일 경우, 이름이 사전 순으로 가장 빠른 직업군을 return 해주세요.

### 제한사항
- table의 길이 = 5
  - table의 원소는 "직업군 5점언어 4점언어 3점언어 2점언어 1점언어"형식의 문자열입니다. 직업군, 5점언어, 4언어, 3점언어, 2점언어, 1점언어는 하나의 공백으로 구분되어 있습니다.
  - table은 모든 테스트케이스에서 동일합니다.
- 1 ≤ languages의 길이 ≤ 9
  - languages의 원소는 "JAVA", "JAVASCRIPT", "C", "C++" ,"C#" , "SQL", "PYTHON", "KOTLIN", "PHP" 중 한 개 이상으로 이루어져 있습니다.
  - languages의 원소는 중복되지 않습니다.
- preference의 길이 = languages의 길이
  - 1 ≤ preference의 원소 ≤ 10
- preference의 i번째 원소는 languages의 i번째 원소의 언어 선호도입니다.
- return 할 문자열은 "SI", "CONTENTS", "HARDWARE", "PORTAL", "GAME" 중 하나입니다.

### 입출력 예
|table|languages|preference|result|
|---|---|---|---|
|["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"]|["PYTHON", "C++", "SQL"]|[7, 5, 5]|"HARDWARE"|
|["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"]|["JAVA", "JAVASCRIPT"]|[7, 5]|"PORTAL"|

### 입출력 예 설명
입출력 예 #1

각 직업군 별로 점수를 계산해보면 아래와 같습니다.

아래 사진은 `개발자 언어 선호도` 나타낸 표입니다.  
||Python|C++|SQL|
|---|---|---|---|
|선호도|7|5|5|


아래 사진은 개발자가 선호하는 언어의 직업군 언어 점수를 나타낸 표입니다.  
||SI|CONTENTS|HARDWARE|PORTAL|GAME|
|---|---|---|---|---|---|
|PYTHON|2|3|3|3|0|
|c++|0|1|4|0|5|
|SQL|3|2|0|0|0|
|직업군별 점수 식|$7*2 + 5*0 + 5*3$|$7*3 + 5*1 + 5*2$|$7*3 + 5*4 + 5*0$|$7*3 + 5*0 + 5*0$|$7*0 + 5*5 + 5*0$|
|점수 총합|29|36|41|21|25|

따라서 점수 총합이 41로 가장 높은 `"HARDWARE"`를 return 해야 합니다.

### 입출력 예 #2

각 직업군 별로 점수를 계산해보면 아래와 같습니다.

아래 사진은 `개발자 언어 선호도` 나타낸 표입니다.  
||JAVA|JAVASCRIPT|
|---|---|---|
|선호도|7|5|

아래 사진은 개발자가 선호하는 `언어의 직업군 언어 점수`를 나타낸 표입니다.  
||SI|CONTENTS|HARDWARE|PORTAL|GAME|
|---|---|---|---|---|---|
|JAVA|5|4|2|5|1|
|JAVASCRIPT|4|5|1|4|3|
|직업군별 점수 식|$7*5 + 5*4$|$7*4 + 5*5$|$7*2 + 5*1$|$7*5 + 5*4$|$7*1 + 5*3$|
|점수 총합|55|53|19|55|22|


점수 총합이 55로 가장 높은 직업군은 "SI" 와 "PORTAL"입니다.
따라서 사전 순으로 먼저 오는 `"PORTAL"`을 return 해야 합니다.

## 문제 풀이 리뷰
- [Java](./Solution.java)
1. TreeMap에 `language` 값에 맞는 table의 배열을 맞춘 후 `preference` 값을 더하였다.
2. 이렇게 하면 자동적으로 언어 별 점수의 합이 정렬된다.
3. 이 후 점수 가 큰 순서로 내림차순 한 뒤 첫번째 값을 리턴하였다. 