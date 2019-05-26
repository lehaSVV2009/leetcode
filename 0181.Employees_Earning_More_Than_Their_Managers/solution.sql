# Write your MySQL query statement below
select e1.Name as Employee from employee e1 join employee e2 on e1.ManagerId = e2.Id and e1.Salary > e2.Salary;