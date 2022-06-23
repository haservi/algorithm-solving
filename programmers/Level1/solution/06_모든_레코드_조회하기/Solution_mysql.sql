-- https://programmers.co.kr/learn/courses/30/lessons/59034

SELECT
  a.ANIMAL_ID,
  a.ANIMAL_TYPE,
  a.DATETIME,
  a.INTAKE_CONDITION,
  a.NAME,
  a.SEX_UPON_INTAKE
FROM ANIMAL_INS AS a
WHERE 1 = 1
ORDER BY a.ANIMAL_ID ASC;