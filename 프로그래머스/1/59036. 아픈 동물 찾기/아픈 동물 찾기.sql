# ANIMAL_ID : 동물의 아이디
# ANIMAL_TYPE : 생물 종
# DATETIME : 보호 시작일
# INTAKE_CONDITION : 보호 시작 시 상태
# NAME : 이름
# SEX_UPON_INTAKE : 성별 및 중성화 여부

# 아픈 동물의 아이디, 이름 조회
# 이때, 아이디 순으로 조회

SELECT ANIMAL_ID, NAME FROM ANIMAL_INS 
WHERE INTAKE_CONDITION = "Sick"
ORDER BY ANIMAL_ID;