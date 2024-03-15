-- https://school.programmers.co.kr/learn/courses/30/lessons/293258

SELECT
  COUNT(fi.ID) AS FISH_COUNT
FROM FISH_INFO AS fi
WHERE (fi.LENGTH IS NULL OR fi.LENGTH < 10)
