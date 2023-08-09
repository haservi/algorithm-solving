-- https://school.programmers.co.kr/learn/courses/30/lessons/164672

SELECT
  ugb.BOARD_ID,
  ugb.WRITER_ID,
  ugb.TITLE,
  ugb.PRICE,
  CASE ugb.STATUS
    WHEN 'SALE' THEN '판매중'
    WHEN 'RESERVED' THEN '예약중'
    WHEN 'DONE' THEN '거래완료'
  END AS STATUS
FROM USED_GOODS_BOARD AS ugb
WHERE ugb.CREATED_DATE = '2022-10-05'
ORDER BY ugb.BOARD_ID DESC;