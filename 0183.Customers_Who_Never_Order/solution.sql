# Write your MySQL query statement below
SELECT Name as Customers FROM customers LEFT JOIN orders ON customers.Id = orders.CustomerId WHERE orders.Id IS NULL
