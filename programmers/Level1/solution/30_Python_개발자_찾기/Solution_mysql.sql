-- https://school.programmers.co.kr/learn/courses/30/lessons/276013

-- OR 절 사용

SELECT
  di.ID,
  di.EMAIL,
  di.FIRST_NAME,
  di.LAST_NAME
FROM DEVELOPER_INFOS AS di
WHERE
(
  di.SKILL_1 = 'Python'
  OR di.SKILL_2 = 'Python'
  OR di.SKILL_3 = 'Python'
)
ORDER BY di.ID ASC;

-- IN 절 사용

SELECT
  di.ID,
  di.EMAIL,
  di.FIRST_NAME,
  di.LAST_NAME
FROM DEVELOPER_INFOS AS di
WHERE 'Python' IN (di.SKILL_1, di.SKILL_2, di.SKILL_3)
ORDER BY di.ID ASC;
