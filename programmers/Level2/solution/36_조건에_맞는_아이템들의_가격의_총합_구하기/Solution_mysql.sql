-- https://school.programmers.co.kr/learn/courses/30/lessons/273709

SELECT
  SUM(ii.PRICE) AS 'TOTAL_PRICE'
FROM ITEM_INFO AS ii
WHERE ii.RARITY = 'LEGEND'
GROUP BY ii.RARITY;
