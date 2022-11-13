create table wallet(
    id int primary key auto_increment,
    bank_name varchar(20),
    account_number varchar(20),
    balance double
);

create table customer(
    id int primary key auto_increment,
    name varchar(30),
    address varchar(100),
    phone varchar(15),
    wallet_id int,
    foreign key (wallet_id) references wallet(id)
);

create table shipper(
    id int primary key auto_increment,
    name varchar(30),
    phone varchar(15),
    wallet_id int,
    foreign key (wallet_id) references wallet(id)
);

create table orders(
   id int primary key auto_increment,
   customer_id int not null,
   shipper_id int not null,
   item_name varchar(30),
   shipping_address varchar(100),
   order_date_time datetime,
   shipping_fee double,
   status varchar(20), /* cho xac nhan, dang van chuyen, thanh cong, that bai, da huy */
   foreign key (customer_id) references customer(id),
   foreign key (shipper_id) references shipper(id)
);