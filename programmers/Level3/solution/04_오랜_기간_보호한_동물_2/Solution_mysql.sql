-- https://school.programmers.co.kr/learn/courses/30/lessons/59411

-- 입양간 날짜에서 보호한 날짜를 뺀 뒤 가장 큰 순서대로 정렬
SELECT
  ai.ANIMAL_ID,
  ai.NAME
FROM ANIMAL_INS AS ai
INNER JOIN ANIMAL_OUTS AS ao ON ai.ANIMAL_ID = ao.ANIMAL_ID
ORDER BY (ao.DATETIME - ai.DATETIME) ASC
LIMIT 2;