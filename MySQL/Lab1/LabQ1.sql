
-- WHERE rating IN("R","NC-17"); OR
-- WHERE rating NOT IN("R","NC-17"); AND

USE hr;
SHOW TABLES;
DESCRIBE employees;
SELECT * FROM employees
WHERE first_name ="Nancy" ;

SELECT * FROM employees
WHERE first_name LIKE "N%" ;

SELECT * FROM employees
WHERE department_id ="90";

SELECT * FROM employees
WHERE department_id ="60"
ORDER BY first_name DESC;



