-- https://programmers.co.kr/learn/courses/30/lessons/62284
/*
INNER JOIN을 이용하여 해당 조건을 나눈 다음 CART_ID와 일치하는 값을 매칭 시켰다.
*/

SELECT
  cp_a.CART_ID
FROM CART_PRODUCTS AS cp_a
INNER JOIN CART_PRODUCTS AS cp_b ON cp_a.CART_ID = cp_b.CART_ID
WHERE 1 = 1
  AND cp_a.NAME = 'Milk'
  AND cp_b.NAME = 'Yogurt'
ORDER BY cp_a.CART_ID ASC