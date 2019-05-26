# Write your MySQL query statement below
select distinct l1.num as ConsecutiveNums from logs l1
left join logs l2 on l1.id = l2.id + 1
left join logs l3 on l2.id = l3.id + 1
where l1.Num = l2.Num and l2.Num = l3.Num
