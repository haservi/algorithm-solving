-- https://school.programmers.co.kr/learn/courses/30/lessons/299307

SELECT
  ed.ID,
  CASE
    WHEN ed.SIZE_OF_COLONY <= 100 THEN 'LOW'
    WHEN ed.SIZE_OF_COLONY BETWEEN 100 AND 1000 THEN 'MEDIUM' 
    ELSE 'HIGH' 
  END AS SIZE
FROM ECOLI_DATA AS ed
ORDER BY ed.ID
