# 나이 정보가 없는 회원이 몇 명인지 출력

SELECT SUM(CASE WHEN age IS NULL THEN 1 ELSE 0 END)
FROM user_info;