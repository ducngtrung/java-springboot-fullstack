-----Create tables-----    
create table skin (
    id int not null auto_increment,
    name varchar(30) not null,
    price double not null,
    limited boolean,
    PRIMARY KEY (id)
);

alter table skin
    add type_id int not null;

alter table skin
    add constraint skin_costumeType_id_fk
        foreign key (type_id) references costume_type(id);

create table figure (
    id int not null auto_increment,
    name varchar(30) not null,
    combo_skill varchar(20),
    PRIMARY KEY (id)
);

create table costume_type (
    id int not null auto_increment,
    name varchar(30) not null,
    color varchar(10) not null,
    PRIMARY KEY (id)
);

create table costume_line (
    id int not null auto_increment,
    name varchar(30) not null,
    create_date date,
    release_date date,
    PRIMARY KEY (id)
);

alter table costume_line
    add skin_id int not null;

alter table costume_line
    add constraint costumeLine_skin_id_fk
        foreign key (skin_id) references skin(id);

create table figure_costumeLine (
    id int not null,
    figure_id int not null,
    costume_line_id int not null,
    primary key (id),
    foreign key (figure_id) references figure(id),
    foreign key (costume_line_id) references costume_line(id)
)

-----Insert data-----
insert into costume_type(id, name, color) values
(1, 'huyen thoai', 'red'),
(2, 'su thi', 'blue'),
(3, 'normal', 'silver'),
(4, 'toi thuong', 'yellow');

INSERT INTO skin(id, name, price, limited, type_id) VALUES
(1, 'Yasua ma kiem', 599, 0, 1),
(2, 'Yone ba vuong hv chien binh', 369, 0, 1),
(3, 'lux vu khi toi thuong', 999, 1, 3),
(4, 'Kathur than chet', 120, 1, 4),
(5, 'Teemo sieu nhan', 180, 0, 2);

INSERT INTO figure(id, name, combo_skill) VALUES
(1, 'Yasua', 'Flash + Ctrl'),
(2, 'Kathur', 'Die + R'),
(3, 'Yone', ' Q + Q + W'),
(4, 'Teemo', 'Only R');

INSERT INTO costume_line(id, name, create_date, release_date, skin_id) VALUES
(1, 'Line 1', '2022-09-01', '2022-09-15', 3),
(2, 'Line 2', '2022-09-02', '2022-09-16', 2),
(3, 'Line 3', '2022-09-03', '2022-09-14', 4),
(4, 'Line 4', '2022-09-04', '2022-09-15', 1);

INSERT INTO figure_costumeline(id, figure_id, costume_line_id) VALUES
(1, 3, 1),
(2, 2, 3),
(3, 4, 2),
(4, 1, 1);


-- Hiển thị thông tin về các vị tướng và các dòng trang phục của các vị tướng ấy
select f.name figure, s.name skin, ct.name costume_type, cl.create_date, cl.release_date
from figure_costumeline fc
inner join figure f on fc.figure_id = f.id
inner join costume_line cl on fc.costume_line_id = cl.id
inner join skin s on cl.skin_id = s.id
inner join costume_type ct on s.type_id = ct.id;

-- Hiển thị tất cả thông tin liên quan đến skin limited
select s.id skin_id, s.name skin_name, s.price price, ct.name type, ct.color color
from skin s
inner join costume_type ct on s.type_id = ct.id
where s.limited = 1;

-- Tìm kiếm tất cả các trang phục loại huyền thoại có giá từ 290 đến 560
select s.id skin_id, s.name skin_name, s.price price, ct.name type, ct.color color
from skin s
inner join costume_type ct on s.type_id = ct.id
where ct.name = 'huyen thoai'
and s.price between 290 and 560;