-- 코드를 입력하세요
SELECT (price - (price % 10000)) as PRICE_GROUP, COUNT(*)
FROM PRODUCT p
GROUP BY (price - (price % 10000))
ORDER BY PRICE_GROUP ASC;