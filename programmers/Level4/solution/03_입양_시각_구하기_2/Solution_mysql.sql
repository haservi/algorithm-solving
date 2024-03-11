-- https://programmers.co.kr/learn/courses/30/lessons/59413
/*
일반적으로 쿼리로 카운트만 계산 후 Java나 다른 언어를 이용하여 시간별 매칭을 시키면 될 거라 생각했는데 쿼리로도 해결 할 수 있다.
*/

SET @hour := -1;

SELECT
  (@hour := @hour + 1) AS HOUR,
  (
    SELECT COUNT(in_ao.DATETIME)
    FROM ANIMAL_OUTS AS in_ao
    WHERE 1 = 1
      AND HOUR(in_ao.DATETIME) = @hour
  ) AS COUNT
FROM ANIMAL_OUTS
WHERE 1 = 1
  AND @hour < 23
