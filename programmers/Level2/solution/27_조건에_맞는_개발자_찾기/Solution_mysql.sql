-- https://school.programmers.co.kr/learn/courses/30/lessons/276034

-- EXIST는 Sub쿼리에 데이터가 존재하는지 확인함

SELECT
  d.ID,
  d.EMAIL,
  d.FIRST_NAME,
  d.LAST_NAME
FROM DEVELOPERS AS d
WHERE EXISTS
(
  SELECT s.CODE
  FROM SKILLCODES s
  WHERE (d.SKILL_CODE & s.CODE) != 0
    AND (s.NAME = 'Python' OR S.NAME = 'C#')
)
ORDER BY d.ID ASC;
