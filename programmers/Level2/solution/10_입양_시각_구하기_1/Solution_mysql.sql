-- https://school.programmers.co.kr/learn/courses/30/lessons/59412

SET @hour := 8;

SELECT
  (@hour := @hour + 1) AS HOUR,
  (
    SELECT COUNT(in_ao.DATETIME)
    FROM ANIMAL_OUTS AS in_ao
    WHERE 1 = 1
      AND HOUR(in_ao.DATETIME) = @hour
  ) AS COUNT
FROM ANIMAL_OUTS AS ao
WHERE 1 = 1
  AND @hour < 19