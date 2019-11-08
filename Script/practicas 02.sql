
use employees;

select s.salary, t.title, e.first_name, e.last_name
from employees as e
inner join titles as t
inner join salaries as s
on e.emp_no = t.emp_no and e.emp_no = s.emp_no
where t.title = 'Senior Engineer';

select avg(s.salary), t.title
from salaries as s
inner join titles as t
on s.emp_no = t.emp_no
where t.title = 'Senior Engineer'

select avg(salaries.salary)
from titles
inner join salaries
on salaries.emp_no = titles.emp_no
where titles.title = 'Senior Engineer'

set global time_zone = '-3:00'

10056 1990-02-01 '48857'
select e.emp_no, s.salary, e.first_name, e.last_name 
from employees as e
inner join salaries as s
on e.emp_no = s.emp_no
where salary > (	select salary
					from salaries
					where salaries.emp_no = '10056' 
						and salaries.from_date = '1990-02-01' 
							and  salaries.to_date = '1991-02-01'
				);