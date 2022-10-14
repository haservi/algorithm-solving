-- https://school.programmers.co.kr/learn/courses/30/lessons/131535

SELECT
  COUNT(*) AS USERS
FROM USER_INFO AS ui
WHERE 1 = 1
  AND DATE(ui.JOINED) BETWEEN '2021-01-01' AND '2021-12-31'
  AND (20 <= ui.AGE AND ui.AGE <= 29)