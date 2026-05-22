create table Employee1
(
    Id integer primary key ,
    name varchar(50) not null,
    Salary Numeric not null
);
select * from public.employee1;

insert into employee1
(id,name,salary)
values
    (18,'jackie',10000),
    (25,'ariana',12000),
    (21,'araina',12000);

update  employee1
set "name"='ariana'
where id =21;


truncate table employee1;

drop table employee;

select * from employee1;

select name from employee1 where salary =10000;

select name from employee1;

select distinct name from employee1;

select * from employee1 where salary >10000 AND name='vinay';

select * from employee1 where salary in(10000,12000);

select * from employee1 where id between 12 and 20

select * from employee1 where name like '%an%';

select * from employee1 where name like '%sh';

select * from employee1 where name like 'vi%';

select * from employee1 where not name ='ariana';

select * from employee1 where name <> 'ariana'

select * from employee1 where name!='ariana';

select * from employee1 where name  = ANY (ARRAY['tanush','ariana']);

select * from employee1 where id < ANY(ARRAY[12,15,20]);

select * from employee1 where id < ALL(ARRAY[18,19,20]);


select * from employee1 order by name DESC LIMIT 3;


create table "research"
(
    "Number" integer primary key,
    "Footnote" varchar not null
);


\copy research("Number","Footnote")

    From 'C:\Users\nbhag\Downloads\research.csv'

    DELIMITER ','

    CSV HEADER;

select * from research ;

Alter table research

    alter column "Footnote" drop not null;

-- functions

select UPPER(name) from employee1;

select length(name),UPPER(name) from employee1;


select substring (name,2,4) ,name from employee1;

select 		CONCAT(name,id), name,id  from employee1;

select replace(name,'ariana','sevion'),name from employee1 where id=21;

select * from employee1;

-- aggregate function 

select count(*) from employee1;

insert into research("Number","Footnote")
values(16,'hello how are you'),
      (18,'hi great');

select sum("Number") from research;

select max("Number") from research ;

select min("Number") from research;

select AVG("Number") from research;

select round(AVG("Number"),2) from research;

select "Footnote" from research ;

select "Footnote",sum("Number") from research group by "Footnote" ;



select "Footnote",sum("Number") AS total from research group by "Footnote" ;

-- having clause is used to put the condition in group by .just like in the select statement we use where clause to 
-- to put the filter 


select "Footnote",sum("Number") AS total from research group by "Footnote" having sum("Number")>=30;

-- TIMESTAMP functions

show timezone

select NOW();

select timeofday();

select current_time;

select current_date;

-- exxtract function is used to get extract te particular part of the timestamp data 


-- SQL Join 

create table department
(
    id integer Primary Key,
    employee_id integer not null,
    department_name  varchar not null,
    employee_name varchar not null
);

alter table employee1

    rename  "id" to "employee_id";

insert into department (id,"employee_id","department_name","employee_name")
values (1,15,'analyst','tanush'),
       (2,20,'developer','vinay'),
       (3,23,'tester','sharanya');

select * from employee1  AS e
                  join department AS d on
    e.employee_id=d.employee_id;

select * from employee1  AS e
                  left join department AS d on
    e.employee_id=d.employee_id;

select * from employee1  AS e
                  right join department AS d on
    e.employee_id=d.employee_id;

select * from employee1  AS e
                  natural join department AS d ;

select name, salary,department_name from employee1 As e
                                             left join department As d on e.employee_id=d.employee_id;

select * from employee1  AS e
                  full  join department AS d on
    e.employee_id=d.employee_id;

-- self join 
alter table department
    add column manager_id varchar;

insert into department(id,employee_id,department_name,employee_name,manager_id)
values(6,26,'hr','brix',26);

update department set employee_id=28 where manager_id='26'


ALTER TABLE department
ALTER COLUMN manager_id TYPE integer
USING manager_id::integer;




select a1.employee_id ,a2.manager_id from department as a1 join department as a2 on a1.employee_id=a2.manager_id;


select * from department;
select * from employee1;


-- UNION and UNION ALL

-- union is the concatenation of the result of two select statement .here no of columns selecting from two tables must be same and columns datat type must be same . Union removes duplicate values where
as union all keeps all the duplicate value .
 


 select employee_id from department 

 union

select employee_id from employee1;


select employee_id,employee_name,id from department

union

select employee_id,name,salary from employee1;

-- subquery or inner query 
-- here below query has select statement inside the another select statement .So this select statement is called inner query or subquery 



select * from department where manager_id<(select max(employee_id)from department )



-- window functions

-- A **window function** in SQL performs a calculation across a set of rows related to the current row, **without collapsing rows into a single result**.
-- It is similar to `GROUP BY`, but the important difference is:
-- - `GROUP BY` reduces rows.
-- - Window functions keep all rows.

--1. row_number()

select * , row_number() over() As row_num from department;
select * , row_number() over(partition by employee_name order by employee_id) As row_num from department;
select * from(select * , row_number() over(partition by employee_name order by employee_id) As row_num from department)t where row_num=1;

select * ,rank() over (order by employee_id) as rank from department;

select * ,dense_rank() over(order by employee_id) as rank from department;
select *,max(employee_id)over (partition by department_name)from department;
select *,avg(employee_id),over (partition by department_name)from department;

select * ,lead(employee_id)over (order by employee_id) as leadby from department;


select * ,lag(employee_id)over (order by employee_id) as leadby from department;


-- case expression
-- if there are multiple condition result will return true condition and if no condition is true it rerun else part
-- if there is no else part then return null

select *,
       CASE
           when department_name='hr'then 'NON IT'
           when  department_name!='hr' then 'IT'
           END AS Categeory
from department;

-- case expression

select *,
       CASE department_name
           when 'hr' then 'NON IT'
           when  'developer'then 'IT'
           when 'analyst'then 'Business'
           when 'tester' then 'testing'

           END AS categeory
from department;


-- CTE- named temporary result from the select statement --there can be multiple select statement just seperated by comma

with department_details AS
         (select * from employee1 as e1 join department as d on e1.employee_id = d.employee_id ),
     max_salary AS
         (select max(salary )from department_details )
select * from max_salary;

-- CTE- named temporary result from the select statement --there can be multiple select statement just seperated by comma

with department_details AS
         (select * from employee1 as e1 join department as d on e1.employee_id = d.employee_id ),
     max_salary AS
         (select max(salary )from department_details )
select * from max_salary;


-- - **CTE** = temporary result for one query.
--**View** = saved query in the database that can be reused.

-- Use a CTE when:
-- You want to simplify a complex query
-- You need temporary logic for one query
-- You want to use recursive queries
--You do not need to reuse the query later

-- Use a View when:
-- You need to reuse the same query many times
--You want to hide complex SQL from users
-- You want to expose limited columns from a table
-- You want a consistent reporting/query layer

create view employee_view as select salary,employee_id from employee1;
select * from employee_view;

create materialized view employee_mview as select * from  employee1;
select * from employee_mview;

-- so basically view just store the query definition in database so whenever we run the view it runs the underlying query and gets
--gets the data from the underlying table in the databse . SO we get the latest data only without manually refreshing it
-- but in materialized view result data is stored physically whenver run the mview gets the stored data
-- to get the latest data we need to refresh the mview manaually

Ex:

insert into employee1("employee_id","name",salary)
values(35,'samay',34000);
-- samay did not come in the result until mview is refreshed

select * from employee_mview;

refresh materialized view employee_mview;

-- - **View** = saved query, used like a table, mostly for reading data.
-- **Stored Procedure** = saved program, called like a command, can perform many actions.

| Thing | Main purpose | How you use it |
| --- | --- | --- |
| **View** | Saved `SELECT` query | Use it like a table |
| **Stored Procedure** | Saved set of actions/steps | Call it like a command |



create procedure employee_procedure
    AS
insert into employee1("employee_id","name","salary")
values(32,'revanna',45000)
GO;


CREATE PROCEDURE employee_procedure()
    LANGUAGE SQL
    AS $$
    INSERT INTO employee1 ("employee_id", "name", "salary")
    VALUES (32, 'revanna', 45000);
$$;

CREATE PROCEDURE employee_procedure2(employee_id integer )
    LANGUAGE SQL
    AS $$
select * from employee1 where employee_id=employee_id;
$$;


CREATE procedure employee_procedure1
(employee_id integer)
    Language SQL
    AS
$$
SELECT *
FROM employee1
WHERE employee_id = employee_id;
$$;


-- sql query syntax may be different in different database. but says the same meaning here in postgress use Language
-- SQL and AS $$ END$$ .. parameter just passed without @

-- BEGIN and END parameter with @ in other db

-- indexes--

-- An **index** in a database is a data structure that helps the database find rows faster.
-- It works like an **index in a book**:
-- - Without an index, the database may scan every row.
-- - With an index, the database can quickly jump to the required data

-- types of indexes
-- primary index
-- cluster index
-- secondary index

-- An **index** in a database is a data structure that helps the database find rows faster.

-- It works like an **index in a book**:

-- - Without an index, the database may scan every row.
-- - With an index, the database can quickly jump to the required data.

-- Example:

-- ```sql
-- CREATE INDEX idx_employee_name
-- ON employee(employee_name);
-- ```


-- This creates an index on the `employee_name` column, so searches by employee name can be faster.

-- Simple definition:

-- > An index is used to speed up searching and retrieving data from a table.

-- example

CREATE INDEX idx_employee_name
    ON employee1(name);

create index index_employee_salry
    ON employee1(salary);

drop index index_employee_salry;

-- when there is primary key is added key is sorted and key is unique then database adds the automatic primary index on it
-- if we want to search the rows on other non primary and unique key and then we can manually create index on that column


-- ACID properties in transactions

--Automicity-Either complete the transaction or rollback ,either in none or full

-- consistency means before the transaction and after the transaction sum should be same .

-- **Isolation** in **ACID** means that when multiple transactions run at the same time, each transaction should behave as if it is running **independently** from the others.
-- In simple words:

-- > **Isolation prevents transactions from interfering with each other**
-- >
-- **Durability** in **ACID** means that once a transaction is **committed**, its changes are saved permanently, even if there is a system crash, power failure, or database restart.
-- Simple definition:

-- > **Durability ensures that committed data is not lost.**





