-- https://school.programmers.co.kr/learn/courses/30/lessons/59045

SELECT
  ao.ANIMAL_ID,
  ao.ANIMAL_TYPE,
  ao.NAME
FROM ANIMAL_OUTS AS ao
INNER JOIN ANIMAL_INS AS ai ON ao.ANIMAL_ID = ai.ANIMAL_ID
WHERE 1 = 1
  AND ao.SEX_UPON_OUTCOME != ai.SEX_UPON_INTAKE
