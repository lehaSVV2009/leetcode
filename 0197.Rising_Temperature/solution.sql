# Write your MySQL query statement below
select w1.Id from weather w1 inner join weather w2 on DATEDIFF(w1.RecordDate, w2.RecordDate) = 1 and w1.Temperature > w2.Temperature;