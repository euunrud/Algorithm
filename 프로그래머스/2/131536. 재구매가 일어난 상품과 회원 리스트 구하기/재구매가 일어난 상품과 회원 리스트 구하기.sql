-- 코드를 입력하세요
SELECT user_id, product_id
FROM ONLINE_SALE
GROUP BY user_id, product_id
having COUNT(*) > 1
order by user_id asc, product_id desc;