-- https://school.programmers.co.kr/learn/courses/30/lessons/59038?language=mysql

SELECT
  ai.DATETIME AS '시간'
FROM ANIMAL_INS AS ai
ORDER BY ai.DATETIME ASC
LIMIT 1;