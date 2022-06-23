-- https://programmers.co.kr/learn/courses/30/lessons/59404

SELECT
  ai.ANIMAL_ID,
  ai.NAME,
  ai.DATETIME
FROM ANIMAL_INS AS ai
WHERE 1 = 1
ORDER BY ai.NAME ASC, ai.DATETIME DESC