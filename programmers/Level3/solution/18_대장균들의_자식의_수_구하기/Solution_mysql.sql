-- https://school.programmers.co.kr/learn/courses/30/lessons/299305

SELECT
  ed.ID,
  COUNT(c_ed.PARENT_ID) AS 'CHILD_COUNT'
FROM ECOLI_DATA AS ed
LEFT JOIN ECOLI_DATA AS c_ed ON ed.ID = c_ed.PARENT_ID
GROUP BY ed.ID
ORDER BY ed.ID
