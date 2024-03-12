-- https://school.programmers.co.kr/learn/courses/30/lessons/284528

SELECT
  he.EMP_NO,
  he.EMP_NAME,
  CASE 
    WHEN 96 <= (SUM(hg.SCORE) / 2) THEN 'S'
    WHEN 90 <= (SUM(hg.SCORE) / 2) THEN 'A'
    WHEN 80 <= (SUM(hg.SCORE) / 2) THEN 'B'
    ELSE 'C'
  END AS GRADE,
  CASE 
    WHEN 96 <= (SUM(hg.SCORE) / 2) THEN he.SAL * 0.2
    WHEN 90 <= (SUM(hg.SCORE) / 2) THEN he.SAL * 0.15
    WHEN 80 <= (SUM(hg.SCORE) / 2) THEN he.SAL * 0.1
    ELSE 0
  END AS BONUS
FROM HR_EMPLOYEES AS he
INNER JOIN HR_GRADE AS hg ON he.EMP_NO = hg.EMP_NO
GROUP BY hg.EMP_NO
ORDER BY he.EMP_NO ASC;

-- 위의 방법말고도 WITH문을 사용해 가상테이블을 만들어서 해결할 수 있다.

WITH SUB_EMPLOYEES_GRADE AS 
(
  SELECT
    out_sub.EMP_NO,
    CASE 
      WHEN out_sub.TOTAL_SCORE >= 96 THEN 'S'
      WHEN out_sub.TOTAL_SCORE >= 90 THEN 'A'
      WHEN out_sub.TOTAL_SCORE >= 80 THEN 'B'
      ELSE 'C'
    END AS GRADE
  FROM
  (
    SELECT
      in_sub.EMP_NO,
      SUM(in_sub.SCORE) / 2 AS TOTAL_SCORE
    FROM HR_GRADE AS in_sub
    GROUP BY in_sub.EMP_NO
  ) AS out_sub
)

SELECT
  he.EMP_NO,
  he.EMP_NAME,
  seg.GRADE,
  CASE 
    WHEN seg.GRADE = 'S' THEN he.SAL * 0.2
    WHEN seg.GRADE = 'A' THEN he.SAL * 0.15
    WHEN seg.GRADE = 'B' THEN he.SAL * 0.1
    ELSE 0
  END AS BONUS
FROM HR_EMPLOYEES AS he
INNER JOIN SUB_EMPLOYEES_GRADE AS seg ON he.EMP_NO = seg.EMP_NO
ORDER BY he.EMP_NO ASC;
