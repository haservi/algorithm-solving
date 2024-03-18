-- https://school.programmers.co.kr/learn/courses/30/lessons/293260

SELECT
  COUNT(fi.ID) AS 'FISH_COUNT',
  MONTH(fi.TIME) AS 'MONTH'
FROM FISH_INFO AS fi
GROUP BY MONTH
ORDER BY MONTH ASC
