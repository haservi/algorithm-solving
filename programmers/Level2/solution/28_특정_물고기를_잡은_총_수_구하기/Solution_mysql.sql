-- https://school.programmers.co.kr/learn/courses/30/lessons/298518

SELECT
  COUNT(fi.ID) AS FISH_COUNT
FROM FISH_INFO AS fi
INNER JOIN FISH_NAME_INFO AS fni ON fi.FISH_TYPE = fni.FISH_TYPE
WHERE fni.FISH_NAME IN('BASS', 'SNAPPER');
