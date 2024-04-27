# 동물의 종, 이름, 성별을 아이디 순으로 조회
# 이때, 이름이 없을 경우 no name
# coalesce(nullif(컬럼, ' '), '바꾸고자 하는 값') as 컬럼

SELECT ANIMAL_TYPE, COALESCE(NAME, 'No name') AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS 
ORDER BY ANIMAL_ID;