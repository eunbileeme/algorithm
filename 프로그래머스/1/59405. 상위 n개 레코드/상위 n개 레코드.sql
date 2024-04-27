# 동물 보호소에 가장 먼저 들어온 동물의 이름을 조회
# 즉, 단 하나의 row -> limit 1;

SELECT name from animal_ins
order by datetime
limit 1;