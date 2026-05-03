-- 코드를 입력하세요
SELECT u.USER_ID, u.NICKNAME, SUM(b.price) AS TOTAL_SALES
FROM USED_GOODS_USER u
JOIN USED_GOODS_BOARD b ON u.USER_ID = b.WRITER_ID
where b.status = 'DONE'
Group by u.user_id Having SUM(b.price) >= 700000
order by TOTAL_SALES ASC;