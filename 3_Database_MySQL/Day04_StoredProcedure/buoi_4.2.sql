-----BTVN1
delimiter $$
create procedure BTVN1()
begin
    --Insert dữ liệu vào bảng figure
    insert into figure(id, name, combo_skill) values
    (5, 'Dennis', 'Ctrl + A'),
    (6, 'Huyen Khanh', 'Alt + Z');

    --Update các trường trong bảng skin
    update skin set price = 799 where name like '%toi thuong';
    update skin set limited = 1 where price between 550 and 650;
end $$
delimiter ;

call BTVN1();


-----BTVN2
delimiter $$
create procedure BTVN2(OUT number_of_figure int, OUT avg_price double, OUT count_costume_line int)
begin
    --Đếm số lượng các vị tướng trong bảng figure
    select count(1) into number_of_figure from figure;

    --Tính giá tiền trung bình trong bảng skin
    select avg(price) into avg_price from skin;

    --Đếm số dòng trang phục (costume_line) được bán vào ngày 15-9
    select count(1) into count_costume_line from costume_line where release_date = '2022-09-15';
end $$
delimiter ;

call BTVN2(@result1, @result2, @result3);
select @result1, @result2, @result3;


-----BTVN3
delimiter $$
create procedure BTVN3(OUT result text)
begin
    declare id_ int;
    declare var int;
    declare count int;
    declare total int;
    set id_ = 1;
    set var = 0;

    --Insert 5 records vào bảng costume_line
    INSERT INTO costume_line(id, name, create_date, release_date, skin_id) VALUES
    (5, 'Line 5', '2022-08-05', '2022-10-15', 2),
    (6, 'Line 6', '2022-07-02', '2022-09-16', 2),
    (7, 'Line 7', '2022-06-30', '2022-08-14', 4),
    (9, 'Line 12', '2022-07-29', '2022-09-20', 3),
    (8, 'Line 10', '2022-08-04', '2022-10-25', 3);

    --Kiểm tra dòng trang phục ‘Line 12’ đã tồn tại hay chưa
    select count(1) into total from costume_line;
    while id_ <= total do
        select count(1) into count from costume_line where name = 'Line 12' and id = id_;
        if count > 0 then
            set var = var + 1;
        end if;
        set id_ = id_ + 1;
    end while;
    if var > 0 then
        set result = 'exists';
    else
        set result = 'not exist';
    end if;
end $$
delimiter ;

call BTVN3(@result);
select @result;