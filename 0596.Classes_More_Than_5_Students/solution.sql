# Write your MySQL query statement below
select c.class from courses c group by c.class having count(distinct c.student) >= 5