--create a procedure
DELIMITER $$
CREATE PROCEDURE show_all_skins()
BEGIN
    select * from skin;
END $$
DELIMITER ;

call show_all_skins();


--create a procedure with input
DELIMITER $$
CREATE PROCEDURE show_limited_skins(IN var int)
BEGIN
    select s.id skin_id, s.name skin_name, s.price price, ct.name type, ct.color color
    from skin s
    inner join costume_type ct on s.type_id = ct.id
    where s.limited = var;
END $$
DELIMITER ;

call show_limited_skins(1);


--create a procedure with both input and output
DELIMITER $$
CREATE PROCEDURE count_limited_skins(IN var int, OUT count int)
BEGIN
    select count(1) into count from skin where limited = var;
END $$
DELIMITER ;

call count_limited_skins(1, @count);
select @count;


--create a procedure with input, output, if-else
DELIMITER $$
CREATE PROCEDURE check_existed_skin(IN priceToCheck int, OUT result varchar(10))
BEGIN
    declare var int;
    select count(1) into var from skin where skin.price > priceToCheck;
    if var > 0 then
        set result = "exists";
    else
        set result = "not exist";
    end if;
END $$
DELIMITER ;

call check_existed_skin(500, @result);
select @result;


--create a procedure with input, output, if-else, while loop
DELIMITER $$
CREATE PROCEDURE count_skin_by_price(IN lowerLimit double, OUT result int)
BEGIN
    declare var int;
    declare skinPrice double;
    declare count int;
    set var = 1;
    set count = 0;
    while var <= 5 do
        select price into skinPrice from skin where id = var;
        if skinPrice > lowerLimit then
            set count = count + 1;
        end if;
        set var = var + 1;
    end while;
    set result = count;
END $$
DELIMITER ;

call count_skin_by_price(150, @result);
select @result;