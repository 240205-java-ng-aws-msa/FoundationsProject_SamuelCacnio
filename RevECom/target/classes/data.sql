drop table if exists account;
drop table if exists eshop;
create table account (
    account_id int primary key auto_increment,
    email varchar(255) not null unique,
    password varchar(255)
);
create table product (
    item_id int primary key auto_increment,
    name varchar(255) not null unique,
    image_path varchar(255),
    price double,
    description varchar(255)
);

--https://www.baeldung.com/jpa-many-to-many

insert into account values (1114, 'jsmith@123', 'password');
insert into account values (2222, 'johndoe@99', 'password');

insert into product values (1111, 'imperial_knight', 'C:\Users\samca\Revature_Training\FoundationsProject_SamuelCacnio\RevECom\src\main\resources\images\knight.jpg', 60.0, 'For the Emperor!');