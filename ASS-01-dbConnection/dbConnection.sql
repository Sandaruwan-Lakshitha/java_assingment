create database test;
use test;
create table customer(
	id varchar(5) primary key,
    name varchar(50) NOT NULL,
    address varchar(50) NOT NULL,
    tel double(10,0) NOT NULL);
