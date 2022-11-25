// Bài 3: 
// Viết một hàm nhận tham số là một mảng gồm các chuỗi là tên của người hoặc đồ vật... 
// Hàm trả về một chuỗi có dạng như sau: Ví dụ tham số truyền vào là [“Mai”, “Vân”, “Tùng”, “Khánh”] thì kết quả trả về là “Mai, Vân, Tùng và Khánh”

function splitArray(array) {
    if (array.length == 2) {
        return `${array[0]} và ${array[1]}`;
    }

    let string = array[0];
    for (let i = 1; i <= array.length-2; ++i) {
        string += `, ${array[i]}`;
    }
    string += ` và ${array[array.length-1]}`;
    return string;
}

splitArray(["Mai", "Vân", "Tùng", "Khánh"]);