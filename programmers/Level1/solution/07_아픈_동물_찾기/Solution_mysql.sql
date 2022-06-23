-- https://programmers.co.kr/learn/courses/30/lessons/59036

SELECT
  ANIMAL_ID,
  NAME
FROM ANIMAL_INS
WHERE 1 = 1
  AND INTAKE_CONDITION = 'Sick'
ORDER BY ANIMAL_ID ASC