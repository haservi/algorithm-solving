-- https://school.programmers.co.kr/learn/courses/30/lessons/298517

SELECT
  fi.ID,
  fi.LENGTH
FROM FISH_INFO AS fi
ORDER BY fi.LENGTH DESC, fi.ID ASC
LIMIT 10
