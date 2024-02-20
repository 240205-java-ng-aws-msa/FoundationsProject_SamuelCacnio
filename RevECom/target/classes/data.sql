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

insert into account values (1, 'jsmith@123', 'password');
insert into account values (2, 'johndoe@99', 'password');

insert into product values (1, 'Fury', 'C:/Users/samca/Revature_Training/FoundationsProject_SamuelCacnio/RevECom/src/main/resources/images/fury.jpg', 60.0, 'M4 Sherman tank as seen in the eponymous film');
insert into product values (2, 'KV-2', 'C:/Users/samca/Revature_Training/FoundationsProject_SamuelCacnio/RevECom/src/main/resources/images/kv2.jpg', 80.0, 'The Death Fridge');
insert into product values (3, 'Thunderbolt-VII', 'C:/Users/samca/Revature_Training/FoundationsProject_SamuelCacnio/RevECom/src/main/resources/images/thunderboltvii.jpg', 70.0, 'Commanded by Lieutenant Colonel Creighton Abrams');
insert into product values (4, 'Tiger-131', 'C:/Users/samca/Revature_Training/FoundationsProject_SamuelCacnio/RevECom/src/main/resources/images/tiger131.jpg', 90.0, 'The last Tiger');