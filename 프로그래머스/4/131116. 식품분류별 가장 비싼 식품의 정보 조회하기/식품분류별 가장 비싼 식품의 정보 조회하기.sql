-- 코드를 입력하세요
SELECT CATEGORY, price as MAX_PRICE, product_name
FROM (
    select category, product_name, price,
    RANK() OVER (PARTITION BY category ORDER BY price DESC) as rk
    from FOOD_PRODUCT
    where category IN ('과자', '국', '김치', '식용유')
) f
where f.rk = 1
order by MAX_PRICE DESC;