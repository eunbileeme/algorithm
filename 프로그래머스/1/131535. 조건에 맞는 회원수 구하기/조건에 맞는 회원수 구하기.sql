# user_info 테이블에서 2021년에 가입한 회원 중, 나이가 20세 이상 29세 이하인 회원이 몇 명인지 출력
# selct count(..)
# where year(joined) = 2021;

SELECT count(*) from user_info
where age >= 20 && age <= 29 && year(joined) = "2021";