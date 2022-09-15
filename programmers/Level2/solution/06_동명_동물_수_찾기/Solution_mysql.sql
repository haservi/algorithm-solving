-- https://school.programmers.co.kr/learn/courses/30/lessons/59041

SELECT
  ai.NAME,
  COUNT(ai.NAME) AS COUNT
FROM ANIMAL_INS AS ai
WHERE 1 = 1
GROUP BY ai.NAME
  HAVING COUNT(ai.NAME) > 1
ORDER BY ai.NAME;