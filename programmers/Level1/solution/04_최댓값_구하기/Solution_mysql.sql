-- https://programmers.co.kr/learn/courses/30/lessons/59415

SELECT
  ai1.DATETIME AS 시간
FROM ANIMAL_INS AS ai1
ORDER BY ai1.DATETIME DESC
LIMIT 1