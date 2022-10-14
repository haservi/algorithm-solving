-- https://school.programmers.co.kr/learn/courses/30/lessons/131528

SELECT
  COUNT(*) AS USERS
FROM USER_INFO AS ui
WHERE 1 = 1
  AND ui.AGE IS NULL;