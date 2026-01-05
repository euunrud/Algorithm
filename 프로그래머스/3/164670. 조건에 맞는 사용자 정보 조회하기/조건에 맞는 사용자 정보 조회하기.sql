-- 코드를 입력하세요
SELECT a.USER_ID, NICKNAME, CONCAT(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) AS '전체주소', CONCAT(substring(TLNO, 1, 3), '-', substring(TLNO, 4, 4), '-', substring(TLNO, 8, 4)) AS '전화번호'
From USED_GOODS_BOARD b
JOIN USED_GOODS_USER a on b.WRITER_ID = a.USER_ID
group by a.USER_ID HAVING COUNT(b.BOARD_ID) >= 3
order by a.USER_ID DESC;