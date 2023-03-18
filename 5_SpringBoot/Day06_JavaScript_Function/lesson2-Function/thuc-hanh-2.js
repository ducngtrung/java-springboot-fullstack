// Bài 1: 
// Viết một hàm nhận tham số là một số. Hàm trả về kết quả báo số đó là số chẵn hay số lẻ.

function checkNumber(number) {
    return ((number % 2) == 0) ? "số chẵn" : "số lẻ"
}

checkNumber(11);


// Bài 2: 
// Viết một hàm tính diện tích của hình tròn, tham số truyền vào là bán kính hình tròn đó.

function calCircle(radius) {
    return ((Math.PI)*(radius**2)).toFixed(2);
}

calCircle(4.6);


// Bài 3: 
// Viết một hàm nhận giá trị là một số hoặc một chuỗi. Hàm chuyển đổi tham số về giá trị số (nếu cần) và trả về kết quả dưới dạng “8px”, “10px”... Nếu tham số không thể chuyển đổi về dạng số, trả về “0px”.

function bai3(input) {
    let number = Number.parseInt(input);
    if (isNaN(number)) {
        return "0px";
    } else {
        return `${number}px`;
    }
}

bai3("15.5px")


// Bài 4: 
// Viết một hàm trả về một số ngẫu nhiên từ 3 đến 8.

function randomInteger(min, max) {
    return Math.floor(Math.random() * (max - min + 1) + min);
}

randomInteger(3, 8);