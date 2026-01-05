-- 코드를 입력하세요
SELECT (PRICE - (PRICE % 10000)) AS PRICE, COUNT(*)
FROM PRODUCT
GROUP by((PRICE - (PRICE % 10000)))
order by price;