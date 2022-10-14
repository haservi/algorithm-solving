-- https://school.programmers.co.kr/learn/courses/30/lessons/131697

SELECT
  p.PRICE AS MAX_PRICE
FROM PRODUCT AS p
WHERE 1 = 1
  AND p.PRICE = (SELECT MAX(PRICE) FROM PRODUCT)