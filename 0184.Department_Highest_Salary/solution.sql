select salaries.department as Department, employee.name as Employee, salaries.salary as Salary 
from employee
join
  (select d.id as DepartmentId, d.name as Department, max(e.salary) as Salary 
   from employee e
   left join department d on e.departmentid = d.id
   group by d.id) as salaries
on employee.salary = salaries.salary and employee.departmentId = salaries.departmentId