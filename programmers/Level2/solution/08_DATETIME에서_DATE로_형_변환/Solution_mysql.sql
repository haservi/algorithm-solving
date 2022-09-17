-- https://school.programmers.co.kr/learn/courses/30/lessons/59414
SELECT
  ai.ANIMAL_ID,
  ai.NAME,
  DATE_FORMAT(ai.DATETIME, '%Y-%m-%d') AS '날짜'
FROM ANIMAL_INS AS ai