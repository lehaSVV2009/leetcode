# Write your MySQL query statement below
select dep.name as Department, e1.name as Employee, e1.salary as Salary
from employee e1
join department dep
on e1.departmentId = dep.id
where (
    select count(distinct e2.salary)
    from employee e2
    where e2.salary > e1.salary and e2.departmentId = e1.departmentId
) < 3
order by dep.id, e1.salary desc;