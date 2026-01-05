-- 코드를 입력하세요
SELECT CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
where OPTIONS Like '%통풍시트%'
OR OPTIONS Like '%열선시트%'
OR OPTIONS Like '%가죽시트%'
Group by CAR_TYPE
order by CAR_TYPE;