use hr;

select date_format(hire_date, '%Y') as year,count(date_format(hire_date, '%Y')) as no
from employees
group by year;

select date_format(hire_date, '%M') as month, Count(date_format(hire_date, '%M')) as no
from employees
group by month
order by no desc
limit 1;

select department_id as Dept_No, date_format(hire_date, '%M') as month, Count(date_format(hire_date, '%M')) as no
from employees
where department_id = 60
group by month
order by no desc
limit 1;

