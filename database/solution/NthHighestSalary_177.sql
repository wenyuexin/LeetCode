-- CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
-- BEGIN
--   RETURN (
--       # Write your MySQL query statement below.
--
--   );
-- END


-- Solution 1
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


-- Solution 2
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT Salary FROM Employee
      ORDER BY Salary DESC LIMIT 1 OFFSET N
  );
END


-- Solution 3
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    IF (
        SELECT COUNT(DISTINCT Salary)
        FROM Employee
        ) < N
    THEN RETURN NULL;
    ELSE
        SET N = N-1;
        RETURN (
            SELECT DISTINCT Salary
            FROM Employee
            ORDER BY Salary DESC
            LIMIT N,1
        );
    END IF;
END