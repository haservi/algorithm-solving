-- https://school.programmers.co.kr/learn/courses/30/lessons/59047
SELECT
  ai.ANIMAL_ID,
  ai.NAME
FROM ANIMAL_INS AS ai
WHERE 1 = 1
  AND ai.NAME LIKE '%el%'
  AND ai.ANIMAL_TYPE = 'Dog'
ORDER BY ai.NAME ASC;