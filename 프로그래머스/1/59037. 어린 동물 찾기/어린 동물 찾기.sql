# 젊은 동물의 아이디, 이름 조히
# 이때, 아이디 순으로 조회

select animal_id, name from animal_ins
where intake_condition != "Aged"
order by animal_id;