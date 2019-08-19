-- create table if not exists employee (id int, salary int)
-- truncate table employee
-- insert into employee (id, salary) values ('1', '100')
-- insert into employee (id, salary) values ('2', '200')
-- insert into employee (id, salary) values ('3', '300')


-- Solution 1
select
    (select distinct
            salary
        from
            employee
        order by salary desc
        limit 1 offset 1) as secondhighestsalary
;


-- Solution 2
select
    ifnull(
      (select distinct salary
       from employee
       order by salary desc
        limit 1 offset 1),
    null) as secondhighestsalary