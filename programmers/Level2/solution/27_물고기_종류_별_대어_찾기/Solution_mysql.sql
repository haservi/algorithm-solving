-- https://school.programmers.co.kr/learn/courses/30/lessons/293261

SELECT
  fi.ID,
  fni.FISH_NAME,
  fi.LENGTH
FROM FISH_INFO AS fi
INNER JOIN FISH_NAME_INFO AS fni ON  fi.FISH_TYPE = fni.FISH_TYPE
WHERE (fi.FISH_TYPE, fi.LENGTH) IN
(
    SELECT 
      FISH_TYPE AS in_max_type,
      MAX(LENGTH) AS in_max_length
    FROM FISH_INFO
    GROUP BY FISH_TYPE
)
ORDER BY fi.ID ASC;
