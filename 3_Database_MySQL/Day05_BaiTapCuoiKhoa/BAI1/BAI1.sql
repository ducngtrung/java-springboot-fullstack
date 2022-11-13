create table item(
    id int primary key auto_increment,
    name varchar(30),
    price double,
    description varchar(100)
);

insert into item(id, name, price, description) values
(1, 'thuoc ngu', 120000, 'thuoc ngu vi cafe'),
(2, 'ban chai', 250000, 'ban chai dien'),
(3, 'kinh mat', 200000, 'kinh cho nguoi mu'),
(4, 'ao ca sa', 300000, 'ao ca sa mau huong');

create table customer(
    id int primary key auto_increment,
    name varchar(30),
    phone varchar(15),
    address varchar(100)
);

insert into customer(id, name, phone, address) values
(1, 'Nguyen Trung Duc', '0913893392', 'Cau Giay, Hanoi'),
(2, 'Vuong Khanh Huyen', '0829392294', 'Ba Dinh, Hanoi'),
(3, 'Chu Tien Dat', '0872952883', 'Gia Lam, Hanoi');

create table stock(
    item_id int not null,
    quantity int not null,
    foreign key (item_id) references item(id)
);

insert into stock(item_id, quantity) values
(1, 10),
(2, 15),
(3, 7),
(4, 20);

create table orders(
    id int primary key auto_increment,
    customer_id int not null,
    item_id int not null,
    quantity int not null,
    order_date date,
    total double,
    foreign key (customer_id) references customer(id),
    foreign key (item_id) references item(id)
);

insert into orders(id, customer_id, item_id, quantity, order_date) values
(1, 2, 3, 5, '2022-09-15'),
(2, 3, 4, 10, '2022-08-19'),
(3, 1, 2, 9, '2022-09-23'),
(4, 2, 1, 6, '2022-07-12');

update orders
set total = quantity * (
    select item.price
    from item
    where orders.item_id = item.id
);

select * from orders;

create table wallet(
    id int primary key auto_increment,
    bank_name varchar(20),
    account_number varchar(20),
    amount double,
    customer_id int not null,
    foreign key (customer_id) references customer(id)
);

insert into wallet(id, bank_name, account_number, amount, customer_id) values
(1, 'BIDV', '009188113123', 10000000, 2),
(2, 'TPBank', '00113814323', 7000000, 3),
(3, 'Vietcombank', '04910001241781', 15000000, 1);

create table comment(
    id int primary key auto_increment,
    customer_id int not null,
    question varchar(100),
    answer varchar(100),
    foreign key (customer_id) references customer(id)
);

insert into comment(id, customer_id, question, answer) value
(1, 2, 'Tet nam nay duoc nghi bao nhieu ngay?', '9 ngay');