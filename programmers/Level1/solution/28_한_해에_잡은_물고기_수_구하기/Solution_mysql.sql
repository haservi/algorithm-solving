-- https://school.programmers.co.kr/learn/courses/30/lessons/298516

SELECT
  COUNT(fi.ID) AS 'FISH_COUNT'
FROM FISH_INFO AS fi
WHERE YEAR(fi.TIME) = '2021'
