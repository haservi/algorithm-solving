-- https://programmers.co.kr/learn/courses/30/lessons/59035

SELECT
  ai.NAME,
  ai.DATETIME
FROM ANIMAL_INS AS ai
WHERE 1 = 1
ORDER BY ai.ANIMAL_ID DESC