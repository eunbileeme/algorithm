# 이름이 있는 동물의 id를 조회
# 이때, id는 오름차순

SELECT animal_id from animal_ins
where name is not null
order by animal_id;