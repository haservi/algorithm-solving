-- https://school.programmers.co.kr/learn/courses/30/lessons/284530

SELECT 
  YEAR(ap.YM) AS 'YEAR',
  ROUND(AVG(ap.PM_VAL1), 2) AS 'PM10',
  ROUND(AVG(ap.PM_VAL2), 2) AS 'PM2.5'
FROM AIR_POLLUTION AS ap
WHERE ap.LOCATION2 = '수원'
GROUP BY YEAR(ap.YM)
ORDER BY YEAR(ap.YM) ASC;
