-- https://programmers.co.kr/learn/courses/30/lessons/59415

SELECT *
FROM
(
  SELECT
    DATETIME AS 시간
  FROM ANIMAL_INS
  ORDER BY DATETIME DESC
)
WHERE ROWNUM = 1;