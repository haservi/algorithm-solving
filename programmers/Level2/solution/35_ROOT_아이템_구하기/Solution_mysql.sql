-- https://school.programmers.co.kr/learn/courses/30/lessons/273710

SELECT
  ii.ITEM_ID,
  ii.ITEM_NAME
FROM ITEM_INFO AS ii
INNER JOIN ITEM_TREE AS it ON ii.ITEM_ID = it.ITEM_ID
WHERE it.PARENT_ITEM_ID IS NULL
ORDER BY ii.ITEM_ID ASC;
