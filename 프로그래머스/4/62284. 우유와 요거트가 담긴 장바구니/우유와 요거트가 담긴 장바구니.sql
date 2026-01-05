-- 코드를 입력하세요
SELECT CART_ID
FROM CART_PRODUCTS 
Where name = 'Milk'
or name = 'Yogurt'
Group by CART_ID 
HAVING COUNT(Distinct name) > 1
order by CART_ID;