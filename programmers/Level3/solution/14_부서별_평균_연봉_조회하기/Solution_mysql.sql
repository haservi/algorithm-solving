-- https://school.programmers.co.kr/learn/courses/30/lessons/284529

SELECT
  hd.DEPT_ID,
  hd.DEPT_NAME_EN,
  ROUND(AVG(he.SAL), 0) AS AVG_SAL
FROM HR_DEPARTMENT AS hd
INNER JOIN HR_EMPLOYEES AS he ON hd.DEPT_ID = he.DEPT_ID
GROUP BY he.DEPT_ID
ORDER BY AVG_SAL DESC
