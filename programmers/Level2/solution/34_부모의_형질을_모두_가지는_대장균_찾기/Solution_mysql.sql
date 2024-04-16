-- https://school.programmers.co.kr/learn/courses/30/lessons/301647

SELECT
  c_ed.ID,
  c_ed.GENOTYPE,
  p_ed.GENOTYPE AS 'PARENT_GENOTYPE'
FROM ECOLI_DATA AS c_ed
INNER JOIN ECOLI_DATA AS p_ed ON c_ed.PARENT_ID = p_ed.ID
WHERE c_ed.GENOTYPE & p_ed.GENOTYPE = p_ed.GENOTYPE
ORDER BY c_ed.ID ASC
