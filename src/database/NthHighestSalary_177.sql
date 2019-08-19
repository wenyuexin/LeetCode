-- CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
-- BEGIN
--   RETURN (
--       # Write your MySQL query statement below.
--
--   );
-- END


CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    set N = N - 1;
    RETURN (
        # Write your MySQL query statement below.
        select
        ifnull(
            (select distinct salary
             from employee
             where salary is not null
             order by salary desc
             limit 1 offset N), null
        ) as nthHighestSalary
    );
END