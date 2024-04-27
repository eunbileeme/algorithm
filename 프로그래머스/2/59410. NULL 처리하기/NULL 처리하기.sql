# 동물의 종, 이름, 성별을 아이디 순으로 조회
# 이때, 이름이 없을 경우 no name
# coalesce(nullif(컬럼, ' '), '바꾸고자 하는 값') as 컬럼

SELECT animal_type, coalesce(nullif(name, ' '), 'No name') as name, sex_upon_intake from animal_ins
order by animal_id;