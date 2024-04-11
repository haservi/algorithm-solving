-- https://school.programmers.co.kr/learn/courses/30/lessons/301646

SELECT
  COUNT(ed.ID) AS 'COUNT'
FROM ECOLI_DATA AS ed
WHERE
  NOT ed.GENOTYPE & 2
  AND ed.GENOTYPE & 5
