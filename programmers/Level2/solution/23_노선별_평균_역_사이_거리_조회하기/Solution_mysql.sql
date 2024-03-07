-- https://school.programmers.co.kr/learn/courses/30/lessons/284531

SELECT
    sd.ROUTE,
    CONCAT
    (
        ROUND(SUM(sd.D_BETWEEN_DIST), 2),
        'km'
    ) AS TOTAL_DISTANCE,
    CONCAT
    (
        ROUND(AVG(sd.D_BETWEEN_DIST), 3),
        'km'
    ) AS AVERAGE_DISTANCE
FROM SUBWAY_DISTANCE AS sd
GROUP BY sd.ROUTE
ORDER BY TOTAL_DISTANCE DESC
