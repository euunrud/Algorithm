-- 코드를 입력하세요
SELECT CATEGORY, SUM(s.SALES) as TOTAL_SALES
FROM Book b
JOIN BOOK_SALES s on b.book_id = s.book_id
where s.sales_date Like '2022-01%'
Group by b.category
Order by CATEGORY ASC;