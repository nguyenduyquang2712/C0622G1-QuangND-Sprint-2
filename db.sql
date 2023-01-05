drop database if exists music_web_v3;
create database music_web_v3;
use music_web_v3;
create table `role`(
id int auto_increment,
name varchar(255),
primary key (id));

create table `account`(
id int auto_increment,
`password` varchar(255),
username varchar(255),
delete_status int default 0,
primary key(id));

create table account_role(
id int auto_increment,
account_id int,
foreign key(account_id) references `account`(id),
role_id int,
foreign key(role_id) references `role`(id),
primary key(id));
create table `user`(
id int auto_increment,
city varchar(255),
street varchar(255),
zip varchar(255),
first_name varchar(255),
last_name varchar(255),
gender int,
phone_number varchar(255),
email varchar(255),
delete_status int default 0,
account_id int,
foreign key(account_id) references `account`(id),
primary key(id));

create table artist(
id int auto_increment,
`name` varchar(255),
`description` longtext,
delete_status int default 0,
primary key(id));
create table type_album(
id int auto_increment,
type varchar(255),
delete_status int default 0,
primary key(id));
create table album(
id int auto_increment,
price double,
title text,
`description` longtext,
genre varchar(255),
release_date date,
instock_status int,
artist_id int,
foreign key(artist_id) references artist(id),
type_id int,
foreign key(type_id) references type_album(id),
delete_status int default 0,
primary key(id));

create table image_album(
id int auto_increment,
url_image text,
album_id int,
foreign key(album_id) references album(id),
delete_status int default 0,
primary key(id));

create table song(
id int auto_increment,
title varchar(255),
`description` text,
genre varchar(255),
image text,
album_id int,
foreign key(album_id) references album(id),
delete_status int default 0,
primary key(id));

create table play_list(
id int auto_increment,
`name` varchar(255),
user_id int,
foreign key(user_id) references `user`(id),
delete_status int default 0,
primary key(id));

create table play_list_song(
id int auto_increment,
play_list_id int,
foreign key(play_list_id) references play_list(id),
song_id int,
foreign key(song_id) references song(id),
primary key(id));

create table payment(
id int auto_increment,
total_price double,
order_date date,
payment_status int default 0,
delete_status int default 0,
user_id int,
foreign key(user_id) references `user`(id),
primary key(id));

create table order_album(
id int auto_increment,
payment_id int,
foreign key(payment_id) references payment(id),
album_id int,
foreign key(album_id) references album(id),
quantity int,
delete_status int default 0,
primary key(id));
