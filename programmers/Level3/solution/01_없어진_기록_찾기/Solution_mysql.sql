-- https://programmers.co.kr/learn/courses/30/lessons/59042

SELECT
  ao.ANIMAL_ID,
  ao.NAME
FROM ANIMAL_OUTS AS ao
LEFT JOIN ANIMAL_INS AS ai ON ao.ANIMAL_ID = ai.ANIMAL_ID
WHERE 1 = 1
  AND ai.ANIMAL_ID IS NULL
ORDER BY ao.ANIMAL_ID ASC;