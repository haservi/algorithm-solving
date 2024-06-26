-- https://school.programmers.co.kr/learn/courses/30/lessons/301650

-- 모든 데이터의 세대 확인
WITH RECURSIVE GENERATION AS
(
  SELECT
    ID,
    PARENT_ID,
    1 AS GENERATION
  FROM ECOLI_DATA
  WHERE PARENT_ID IS NULL

  UNION ALL

  SELECT
    ed.ID,
    ed.PARENT_ID,
    g.GENERATION + 1 AS GENERATION
  FROM
    ECOLI_DATA AS ed
  INNER JOIN GENERATION AS g ON ed.PARENT_ID = g.ID
)

SELECT
  g.ID
FROM GENERATION AS g
WHERE g.GENERATION = 3
ORDER BY g.ID ASC;
