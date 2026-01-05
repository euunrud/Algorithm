-- 코드를 입력하세요
SELECT b.writer_id, u.nickname, sum(price) as TOTAL_SALES 
from USED_GOODS_BOARD b
join USED_GOODS_USER u on u.USER_ID = b.WRITER_ID
where b.status = 'DONE'
group by writer_id having sum(price) >= 700000
order by TOTAL_SALES ASC;
