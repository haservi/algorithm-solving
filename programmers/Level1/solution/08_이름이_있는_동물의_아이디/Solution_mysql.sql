-- https://programmers.co.kr/learn/courses/30/lessons/59407

SELECT
  ANIMAL_ID
FROM ANIMAL_INS AS ai
WHERE 1 = 1
  AND NAME IS NOT NULL
ORDER BY ANIMAL_ID ASC