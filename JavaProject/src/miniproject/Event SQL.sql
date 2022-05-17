create database Project;
create table Event(
S_No int primary key auto_increment,
Cust_Name varchar(30) not null,
Event_Type varchar(30) not null,
Venue_Name varchar(30)not null,
Gift_Name varchar (30) not null,
Total_Amount double,
Event_Date date,
Location varchar(45) not null,
City varchar(15) not null,
Phone_No varchar(30),
Mail_Id varchar(45)
);

select * from project.event;

