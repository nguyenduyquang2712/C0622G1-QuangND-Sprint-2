drop database if exists music_web;
create database music_web;
use music_web;

create table artist(
id int auto_increment,
artist_name varchar(255),
note varchar(255),
delete_status int default 0,
primary key(id));

create table product(
id int auto_increment,
media varchar(255),
price double,
product_title varchar(255),
genre varchar(255),
release_date date,
`type` varchar(255),
instock varchar(255),
delete_status int default 0,
primary key(id));

create table produces(
id int auto_increment,
artist_id int,
foreign key(artist_id) references artist(id),
product_id int,
foreign key(product_id) references product(id),
primary key(id));

create table track(
id int auto_increment,
track_title varchar(255),
length int,
delete_status int default 0,
primary key(id));

create table media_track(
id int auto_increment,
track_id int,
foreign key(track_id) references track(id),
product_id int,
foreign key(product_id) references product(id),
delete_status int default 0,
primary key(id));


create table account (
id int primary key auto_increment,
delete_status int default 0,
password varchar (255),
username varchar(255)
);

create table role (
id int primary key auto_increment,
name varchar(255)
);

create table account_role (
id int primary key auto_increment,
account_id int,
role_id int,
foreign key (account_id) references account(id),
foreign key (role_id) references role(id)
);
create table customer(
id int auto_increment,
city varchar(255),
street varchar(255),
zip varchar(255),
first_name varchar(255),
last_name varchar(255),
prefferedgenre varchar(255),
phone_number varchar(255),
email varchar(255),
delete_status int default 0,
account_id int,
foreign key (account_id) references account(id),
primary key(id));

create table customer_order(
id int auto_increment,
order_date date,
delete_status int default 0,
primary key(id));

create table orders(
id int auto_increment,
order_id int,
foreign key(order_id) references customer_order(id),
customer_id int,
foreign key(customer_id) references customer(id),
delete_status int default 0,
primary key(id));

create table list(
id int auto_increment,
product_id int,
foreign key(product_id) references product(id),
order_id int,
foreign key(order_id) references customer_order(id),
delete_status int default 0,
primary key(id));


