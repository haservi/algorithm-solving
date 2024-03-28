-- https://school.programmers.co.kr/learn/courses/30/lessons/298515

SELECT
  CONCAT(MAX(fi.LENGTH), 'cm') AS MAX_LENGTH
FROM FISH_INFO AS fi
