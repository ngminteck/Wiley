
-- SHOW TABLES;
-- DESCRIBE employees;
-- WHERE rating IN("R","NC-17"); OR
-- WHERE rating NOT IN("R","NC-17"); AND

-- select department_id,count(*) as Counting
-- from employees 
-- where department_id in (50,80,100,20)
-- group by department_id
-- having Counting >5
-- order by Counting;


USE hr;

SELECT * FROM employees
WHERE first_name ="Nancy" ;

SELECT * FROM employees
WHERE first_name LIKE "N%" ;

SELECT * FROM employees
WHERE department_id ="90";

SELECT * FROM employees
WHERE department_id ="60"
ORDER BY first_name DESC;

select * 
from employees e
join departments d on e.department_id = d.department_id
join locations l on d.location_id = l.location_id
group by e.employee_id;

select * 
from employees
where hire_date  >= "2004-01-01";

select *
from employees
where salary = (select max(salary)  from employees );


select *
from employees
where hire_date  >=  (select hire_date from employees where first_name ="Bruce" );

select * 
from employees
where  (hire_date between '2004-06-01' and '2004-06-01')


