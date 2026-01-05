-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, substring(DATE_OF_BIRTH, 1, 10) AS DATE_OF_BIRTH
From member_profile
where substring(DATE_OF_BIRTH, 6, 2) = '03'
and gender = 'W'
and TLNO Is not null
order by MEMBER_ID;