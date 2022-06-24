use hr;

-- cross join no condition
select e.first_name, d.department_name
from employees e, departments d;

select e.first_name, d.department_name
from employees e
inner join departments d
on e.department_id = d.department_id;

select e.first_name, d.department_name
from employees e
left outer join departments d
on e.department_id = d.department_id;

select e.first_name, d.department_name
from employees e
right outer join departments d
on e.department_id = d.department_id;

select e.first_name as employees_name, m.first_name as manager_name
from employees e
join employees m
on e.manager_id = m.employee_id;

select e.first_name as employees_name, m.first_name as manager_name
from employees e
left outer join employees m
on e.manager_id = m.employee_id;

select concat(e.first_name, " " , e.last_name) as employees_name, concat(m.first_name, " ", m.last_name) as manager_name
from employees e
left outer join employees m
on e.manager_id = m.employee_id;

-- inner join 1
-- left outer join 3
-- right outer join 3
-- cross join 5