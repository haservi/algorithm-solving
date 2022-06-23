-- https://programmers.co.kr/learn/courses/30/lessons/59039

SELECT
  ai.ANIMAL_ID
FROM ANIMAL_INS AS ai
WHERE 1 = 1
  AND ai.NAME IS NULL
ORDER BY ai.ANIMAL_ID ASC;