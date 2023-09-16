
SELECT
  crh.CAR_ID,
  IF
  (
    -- 여러 이력 중에 해당 날짜가 있다면 대여중으로 return
    MAX('2022-10-16' BETWEEN crh.START_DATE AND crh.END_DATE),
    '대여중',
    '대여 가능'  
  ) AS 'AVAILABILITY'
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS crh
GROUP BY crh.CAR_ID
ORDER BY crh.CAR_ID DESC