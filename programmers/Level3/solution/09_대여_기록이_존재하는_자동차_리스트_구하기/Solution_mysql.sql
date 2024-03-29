SELECT
  cc.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR AS cc
INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS crh ON cc.CAR_ID = crh.CAR_ID
WHERE cc.CAR_TYPE = '세단'
  AND MONTH(crh.START_DATE) = 10
GROUP BY cc.CAR_ID
ORDER BY cc.CAR_ID DESC