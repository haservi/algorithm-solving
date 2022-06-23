-- https://programmers.co.kr/learn/courses/30/lessons/59037

SELECT
  ai.ANIMAL_ID,
  ai.NAME
FROM ANIMAL_INS AS ai
WHERE 1 = 1
  AND ai.INTAKE_CONDITION != 'Aged'
ORDER BY ai.ANIMAL_ID ASC