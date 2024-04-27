# 모든 동물의 아이디 / 이름 / 보호 시작일을 이름 순으로 조회
# 단, 이름이 같은 동물 중에서는 보호를 나중에 시작한 동물을 먼저 보여줘야 함
# (1) 이름 정렬, (2) 날짜 내림차순 정렬 -> order by 이름, 날짜 desc;
# desc 조건은 날짜에만 걸림

SELECT animal_id, name, datetime from animal_ins
order by name, datetime desc;