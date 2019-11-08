select * 
from country 
where name='Argentina'
update city
set name = 'Vicente López'
where ID=92
select * from city where countrycode='ARG'
departments
select * from country

select count(id) as Cantidad, CountryCode 
from city 
where CountryCode='CHN'

select Population, name, region 
from country 
order by Population asc

select Population, name, region 
from country 
where Population != 0 
order by Population asc 
limit 1

select city.name, city.population, country.name, countrylanguage.language, countrylanguage.Percentage
from city
inner join country
inner join countrylanguage
on city.countrycode = country.code and country.code = countrylanguage.countrycode
where country.code='ARG'
order by city.name asc