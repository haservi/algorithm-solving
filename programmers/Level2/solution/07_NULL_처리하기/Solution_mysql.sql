-- https://school.programmers.co.kr/learn/courses/30/lessons/59410

SELECT
  ai.ANIMAL_TYPE,
  IFNULL(ai.NAME, 'No name') AS NAME,
  ai.SEX_UPON_INTAKE
FROM ANIMAL_INS AS ai;