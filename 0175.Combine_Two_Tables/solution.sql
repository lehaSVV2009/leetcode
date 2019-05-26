# Write your MySQL query statement below
select p.FirstName, p.LastName, a.City, a.State from person p left join address a on p.PersonId = a.PersonId