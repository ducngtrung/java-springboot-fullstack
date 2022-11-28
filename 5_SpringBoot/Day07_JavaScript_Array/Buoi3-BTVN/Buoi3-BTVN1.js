// Bài 4: 
// Viết một hàm nhận tham số là một chuỗi là một đoạn văn. Hàm trả về chuỗi nhận được từ tham số với tất cả các chữ cái đầu của các từ viết hoa. Ví dụ tham số là “It is a good day”, kết quả trả về “It Is A Good Day”.

function uppercaseString(str) {
    let splitStr = str.toLowerCase().split(" ");
    for (let i = 0; i < splitStr.length; ++i) {
        splitStr[i] = splitStr[i].charAt(0).toUpperCase() + splitStr[i].substring(1);
    }
    str = splitStr.join(" ");
    return str;
}

uppercaseString("It is a good day");