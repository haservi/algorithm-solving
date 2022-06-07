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