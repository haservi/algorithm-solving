-- https://school.programmers.co.kr/learn/courses/30/lessons/276036?language=mysql

SELECT
    CASE
      WHEN
        MAX(CASE WHEN s.CATEGORY = 'Front End' THEN 1 ELSE 0 END) = 1
        AND MAX(CASE WHEN s.NAME = 'Python' THEN 1 ELSE 0 END) = 1 THEN 'A'
      WHEN MAX(CASE WHEN s.NAME = 'C#' THEN 1 ELSE 0 END) = 1 THEN 'B'
      WHEN MAX(CASE WHEN s.CATEGORY = 'Front End' THEN 1 ELSE 0 END) = 1 THEN 'C'
      ELSE NULL
    END AS GRADE,
    d.ID,
    d.EMAIL
FROM DEVELOPERS AS d
INNER JOIN SKILLCODES AS s ON (d.SKILL_CODE & s.CODE) = s.CODE
GROUP BY d.ID , d.EMAIL
HAVING GRADE IS NOT NULL
ORDER BY GRADE ASC, d.ID ASC;
