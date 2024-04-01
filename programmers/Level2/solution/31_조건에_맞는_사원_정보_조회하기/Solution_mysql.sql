-- https://school.programmers.co.kr/learn/courses/30/lessons/284527

SELECT
  SUM(hg.SCORE) AS SCORE,
  he.EMP_NO,
  he.EMP_NAME,
  he.POSITION,
  he.EMAIL
FROM HR_EMPLOYEES AS he
INNER JOIN HR_GRADE AS hg ON he.EMP_NO = hg.EMP_NO
GROUP BY hg.EMP_NO
ORDER BY SCORE DESC
LIMIT 1;
