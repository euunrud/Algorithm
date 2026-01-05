-- 코드를 입력하세요
SELECT factory_id, factory_name, address
from FOOD_FACTORY
where Substring(address, 1, 3) = '강원도'
order by factory_id;