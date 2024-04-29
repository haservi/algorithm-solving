-- https://school.programmers.co.kr/learn/courses/30/lessons/276035

SELECT
  d.ID,
  d.EMAIL,
  d.FIRST_NAME,
  d.LAST_NAME
FROM DEVELOPERS AS d
WHERE
  d.SKILL_CODE & (
    SELECT
      SUM(CODE)
    FROM SKILLCODES
    WHERE CATEGORY = 'Front End'
  )
ORDER BY d.ID ASC;
