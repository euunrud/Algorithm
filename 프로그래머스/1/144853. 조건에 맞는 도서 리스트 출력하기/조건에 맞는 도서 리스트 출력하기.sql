-- 코드를 입력하세요
SELECT BOOK_ID, substring(PUBLISHED_DATE, 1, 10) as PUBLISHED_DATE
from BOOK
where CATEGORY='인문'
AND substring(PUBLISHED_DATE, 1, 4) = '2021'
order by PUBLISHED_DATE;