-- https://school.programmers.co.kr/learn/courses/30/lessons/59409

SELECT
  ai.ANIMAL_ID,
  ai.NAME,
  IF
  (
      ai.SEX_UPON_INTAKE LIKE '%NEUTERED%' 
      OR ai.SEX_UPON_INTAKE LIKE '%SPAYED%'
      , 'O'
      , 'X'
  ) AS '중성화'
FROM ANIMAL_INS AS ai
ORDER BY ai.ANIMAL_ID ASC;