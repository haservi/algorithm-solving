-- https://school.programmers.co.kr/learn/courses/30/lessons/131112

SELECT
  ff.FACTORY_ID,
  ff.FACTORY_NAME,
  ff.ADDRESS
FROM FOOD_FACTORY AS ff
WHERE ff.ADDRESS LIKE '강원도%'
ORDER BY ff.FACTORY_ID ASC;