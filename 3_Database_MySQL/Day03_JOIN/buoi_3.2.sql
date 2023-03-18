-----Create tables-----
create table role(
    id int primary key auto_increment,
    name varchar(30)
);

create table user(
    id int primary key auto_increment,
    name varchar(30),
    phone varchar(15),
    email varchar(30),
    role_id int,
    foreign key (role_id) references role(id)
    /* bankAccount_id int,
    foreign key (bankAccount_id) references bankAccount(id) */
);

create table bankAccount(
    id int primary key auto_increment,
    bank_name varchar(20),
    account_number varchar(20),
    user_id int not null,
    foreign key (user_id) references user(id)
);

create table course(
    id int primary key auto_increment,
    name varchar(30),
    time_to_finish varchar(15),
    price double,
    course_type varchar(15), /*'online' or 'offline'*/
    rating double          
);

create table openingSchedule(
    id int primary key auto_increment,
    start_date date,
    address varchar(50),
    study_day varchar(50),
    study_time varchar(15)
);

create table course_openingSchedule(
    id int primary key auto_increment,
    course_id int not null,
    openingSchedule_id int not null,
    foreign key (course_id) references course(id),
    foreign key (openingSchedule_id) references openingSchedule(id)
);

create table transactionHistory(
    id int primary key auto_increment,
    user_id int not null,
    course_id int not null,
    registration_date date,
    status varchar(15),
    foreign key (user_id) references user(id),
    foreign key (course_id) references course(id)
);

-----Insert data-----
insert into role(id, name) values
(1, 'student'),
(2, 'teacher'),
(3, 'admin');

insert into user(id, name, phone, email, role_id) values
(1, 'Nguyen Trung Duc', '091278178', 'ducnguyen.bme@gmail.com', 1),
(2, 'Tran Thanh Huong', '099123192', 'huongtran@gmail.com', 3),
(3, 'Ngo Huu Hung', '090939823', 'hungngo87@gmail.com', 1),
(4, 'Nguyen Tien Dat', '089342839', 'datnt90@gmail.com', 2),
(5, 'Vuong Khanh Huyen', '0998318491', 'khanhhuyen712@gmail.com', 1);

insert into bankAccount(id, bank_name, account_number, user_id) values
(1, 'BIDV', '009188113123', 2),
(2, 'TPBank', '00113814323', 5),
(3, 'Vietcombank', '04910001241781', 4),
(4, 'Techcombank', '018313894342', 1),
(5, 'MBBank', '131431138', 3);

insert into course(id, name, time_to_finish, price, course_type, rating) values
(1, 'Java Spring Boot Fullstack', '9 months', 22000000, 'offline', 4.6),
(2, 'Amazon Web Services', '3 months', 8000000, 'online', 4.2),
(3, 'PHP Fullstack', '8 months', 20000000, 'offline', 4.5),
(4, 'Web Front-end', '7 months', 15000000, 'offline', 4.3),
(5, 'DevOps', '3 months', 10000000, 'online', 4.1);

insert into openingSchedule(id, start_date, address, study_day, study_time) values
(1, '2022-09-15', 'Dich Vong Hau', 'Thu2-Thu4-Thu6', '18h30-21h30'),
(2, '2022-09-05', 'To Huu', 'Thu3-Thu5-Thu7', '18h30-21h30'),
(3, '2022-09-15', 'Dich Vong Hau', 'Thu2-Thu4-Thu6', '14h30-17h30'),
(4, '2022-10-20', 'Nguyen Dinh Chieu', 'Thu2-Thu4-Thu6', '8h30-11h30'),
(5, '2022-11-10', 'To Huu', 'Thu3-Thu5-Thu7', '14h30-17h30');

insert into course_openingSchedule(id, course_id, openingSchedule_id) values
(1, 1, 1),
(2, 2, 4),
(3, 3, 5),
(4, 4, 1),
(5, 5, 3);

insert into transactionHistory(id, user_id, course_id, registration_date, status) values
(1, 1, 1, '2022-08-21', 'successful'),
(2, 3, 5, '2022-08-25', 'pending'),
(3, 5, 2, '2022-09-01', 'canceled'),
(4, 1, 2, '2022-07-15', 'successful'),
(5, 5, 4, '2022-08-21', 'pending');


-- Hiển thị Hồ sơ cá nhân của các user (id, name, phone, email, role, thông thẻ tin ngân hàng)
select u.id user_id, u.name user, r.name role, u.phone, u.email,
    bA.bank_name, bA.account_number
from user u
join role r on u.role_id = r.id
join bankAccount bA on u.id = bA.user_id;

-- Tìm kiếm tất cả các học viên đăng ký học online
select u.id user_id, u.name student, c.name course_name, c.course_type
from user u
join transactionHistory tH on u.id = tH.user_id
join course c on tH.course_id = c.id
where c.course_type = 'online';

-- Hiển thị lịch khai giảng và thông tin các khóa học trong buổi khai giảng đó
select oS.start_date, oS.address, oS.study_day, oS.study_time, c.name course
from course_openingSchedule co
right join course c on co.course_id = c.id
right join openingSchedule oS on co.openingSchedule_id = oS.id;

-- Hiển thị chi tiết lịch sử giao dịch của các học viên: mã giao dịch, tên học viên, tên khóa học,
-- ngày đăng ký, trạng thái
select tH.id transaction_id, u.name student, c.name course,
    tH.registration_date, tH.status
from transactionHistory tH
join course c on tH.course_id = c.id
join user u on tH.user_id = u.id;