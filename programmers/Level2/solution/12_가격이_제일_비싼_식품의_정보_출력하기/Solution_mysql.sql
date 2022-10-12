-- https://school.programmers.co.kr/learn/courses/30/lessons/131115

SELECT
  fp.PRODUCT_ID,
  fp.PRODUCT_NAME,
  fp.PRODUCT_CD,
  fp.CATEGORY,
  fp.PRICE
FROM FOOD_PRODUCT AS fp
WHERE 1 = 1
  AND fp.PRICE = (SELECT MAX(PRICE) FROM FOOD_PRODUCT)