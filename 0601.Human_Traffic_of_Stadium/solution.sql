# Write your MySQL query statement below
select distinct s.id, s.visit_date, s.people from stadium s
join
(
    select distinct s1.id from stadium s1
    join stadium s2 on s2.id = s1.id + 1
    join stadium s3 on s3.id = s2.id + 1
    where 
        s1.people >= 100 and 
        s2.people >= 100 and 
        s3.people >= 100
) as firstIds
on 
    s.id = firstIds.id or
    s.id - 1 = firstIds.id or
    s.id - 2 = firstIds.id;