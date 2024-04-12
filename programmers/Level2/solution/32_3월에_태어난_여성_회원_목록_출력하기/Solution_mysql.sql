-- https://school.programmers.co.kr/learn/courses/30/lessons/131120

SELECT
  mp.MEMBER_ID,
  mp.MEMBER_NAME,
  mp.GENDER,
  DATE_FORMAT(mp.DATE_OF_BIRTH, '%Y-%m-%d') AS 'DATE_OF_BIRTH'
FROM MEMBER_PROFILE AS mp
WHERE mp.TLNO IS NOT NULL
  AND mp.GENDER = 'W'
  AND MONTH(mp.DATE_OF_BIRTH) = 3
ORDER BY mp.MEMBER_ID ASC
