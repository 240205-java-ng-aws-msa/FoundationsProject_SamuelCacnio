drop table if exists account;
drop table if exists eshop;
create table account (
    account_id int primary key auto_increment,
    email varchar(255) not null unique,
    password varchar(255)
);
create table shopItem (
    item_id int primary key auto_increment,
    name varchar(255) not null unique,
    image_path varchar(255),
    price double,
    description varchar(255)
);

--https://www.baeldung.com/jpa-many-to-many

insert into account values (9999, 'jsmith@123', 'password');
insert into account values (9998, 'johndoe@99', 'password');

insert into shopItem values (1111, 'imperial knight', 'C:/Users/samca/Revature_Training/RevECom/src/main/resources/images/knight.jpg', 60.0, 'For the Emperor!');