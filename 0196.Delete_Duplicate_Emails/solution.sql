# Write your MySQL query statement below
delete p1 from person p1 join person p2 on p1.Id > p2.Id and p1.Email = p2.Email;