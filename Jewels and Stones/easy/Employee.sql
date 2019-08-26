# Write your MySQL query statement below
select
    a.Name AS 'Employee'
from
    Employee AS a,
    Employee AS b
where
    a.ManagerId = b.Id
        AND a.Salary > b.Salary