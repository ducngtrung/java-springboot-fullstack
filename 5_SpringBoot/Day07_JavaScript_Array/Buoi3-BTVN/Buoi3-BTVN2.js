// Bài 5: 
// Viết một hàm nhận tham số là một mảng gồm 5 giá trị số, trong đó giá trị đầu tiên đại diện số giờ 0 (0 - 23), giá trị thứ 2 của mảng đại diện số phút (0 - 59), giá trị thứ 3 đại diện cho ngày (1 - 31), giá trị thứ 4 đại diện cho tháng (1 - 12) và giá trị cuối cùng đại diện cho số năm (> 0). 
// Viết hàm trả về giá trị theo mẫu sau: “05:10 08/10/2022 AM”. 
// Kiểm tra điều kiện hợp lệ của các giá trị trong mảng ở tham số, nếu có giá trị không hợp lệ thì hàm trả về undefined.

function isValidHour(hour) {
    return ((!isNaN(hour)) && (hour >= 0) && (hour <= 23));
}

function isValidMinute(minute) {
    return ((!isNaN(minute)) && (minute >= 0) && (minute <= 59));
}

function isValidDay(day) {
    return ((!isNaN(day)) && (day >= 1) && (day <= 31));
}

function isValidMonth(month) {
    return ((!isNaN(month)) && (month >= 1) && (month <= 12));
}

function isValidYear(year) {
    return ((!isNaN(year)) && (year > 0));
}

function createString(hour, minute, day, month, year) {
    return `${hour}:${minute} ${day}/${month}/${year}`;
}

function dateTimeString(hour, minute, day, month, year) {
    if (!
        ((isValidHour(hour)) 
        && (isValidMinute(minute)) 
        && (isValidDay(day)) 
        && (isValidMonth(month)) 
        && (isValidYear(year)))
        ) {
        return "undefined";
    }
    if (hour < 12) {
        return createString(hour, minute, day, month, year) + " AM";
    } else if (hour == 12) {
        return createString(hour, minute, day, month, year) + " PM";
    } else {
        return createString(hour - 12, minute, day, month, year) + " PM";
    }
}

dateTimeString(14, 30, 28, 15, 2022);