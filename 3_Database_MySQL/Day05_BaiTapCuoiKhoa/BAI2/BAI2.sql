create table event(
    id int primary key auto_increment,
    name varchar(30),
    address varchar(100)
);

insert into event(id, name, address) values
(1, 'dam cuoi', 'Cau Giay, Ha Noi'),
(2, 'dam ma', 'Lang Son');

create table activity(
    id int primary key auto_increment,
    name varchar(30)
);

create table person(
    id int primary key auto_increment,
    name varchar(30),
    address varchar(100),
    phone varchar(15),
    role varchar(15)
);

create table income_statistics(
    id int primary key auto_increment,
    person_id int,
    event_id int,
    given_money double,
    foreign key (person_id) references person(id),
    foreign key (event_id) references event(id)
);

create table invitation_card(
    id int primary key auto_increment,
    description varchar(100),
    qr_code varchar(30),
    event_id int,
    person_id int,
    foreign key (event_id) references event(id),
    foreign key (person_id) references person(id)
);

create table food(
    id int primary key auto_increment,
    name varchar(30),
    price double,
    quantity int
);

insert into food(id, name, price, quantity) values
(1, 'ga luoc', 250000, 10),
(2, 'tom chien', 100000, 15),
(3, 'xoi xeo', 70000, 9);

create table equipment(
    id int primary key auto_increment,
    name varchar(30),
    price double,
    quantity int,
    status varchar(15) /* da tra, chua tra, da mat */
);

insert into equipment(id, name, price, quantity, status) values
(1, 'bo ban ghe', 120000, 20, 'da tra'),
(2, 'bo loa dai', 200000, 14, 'chua tra');

create table spending_statistics(
    id int primary key auto_increment,
    spending_type varchar(10), /* food, equipment */
    spending_id int,
    spending_name varchar(30),
    spending_amount double
);

delimiter $$
create procedure insert_spending_statistics()
begin
    declare count_food int;
    declare count_equip int;
    declare id_ int;
    declare var int;
    declare name_ varchar(30);
    declare total double;

    set id_ = 1;
    set var = 1;
    select count(1) into count_food from food;
    select count(1) into count_equip from equipment;

    while id_ <= count_food do
        select food.name into name_ from food where food.id = id_;
        select food.price*food.quantity into total from food where food.id = id_;
        insert into spending_statistics(id, spending_type, spending_id, spending_name, spending_amount) 
        values (var, 'food', id_, name_, total);
        set var = var + 1;
        set id_ = id_ + 1;
    end while;

    set id_ = 1;

    while id_ <= count_equip do
        select equipment.name into name_ from equipment where equipment.id = id_;
        select equipment.price*equipment.quantity into total from equipment where equipment.id = id_;
        insert into spending_statistics(id, spending_type, spending_id, spending_name, spending_amount) 
        values (var, 'equipment', id_, name_, total);
        set var = var + 1;
        set id_ = id_ + 1;
    end while;
end $$
delimiter ;

call insert_spending_statistics();
select * from spending_statistics;