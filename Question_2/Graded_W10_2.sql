create database gl;
use gl;
create table employee (
	id int primary key,
    name varchar(50) not null,
    email_id varchar(50) not null,
    phone_number varchar(20) not null
);
desc employee;
select * from employee;