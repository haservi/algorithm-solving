-- https://school.programmers.co.kr/learn/courses/30/lessons/59046

SELECT
  ai.ANIMAL_ID,
  ai.NAME,
  ai.SEX_UPON_INTAKE
FROM ANIMAL_INS AS ai
WHERE 1 = 1
  AND ai.SEX_UPON_INTAKE = 'Spayed Female'
  AND ai.DATETIME IS NOT NULL
  AND ai.NAME IN('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY ai.ANIMAL_ID ASC;