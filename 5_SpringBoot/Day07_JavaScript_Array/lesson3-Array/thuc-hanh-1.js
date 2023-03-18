// Bài 1: 
// Viết một hàm nhận tham số là một mảng gồm các giá trị số. Hàm trả về một mảng mới gồm
// các giá trị gấp đôi giá trị của mảng tham số truyền vào.

function doubleArray(array) {
    return array.map(x => x*2);
}

doubleArray([3, 0, 1, 2]);


// Bài 3: 
// Viết một hàm nhận tham số là một số. Hàm trả về một mảng có các giá trị từ 0 cho đến giá trị
// tham số truyền vào. Ví dụ tham số truyền vào là 3 hàm trả về mảng [0, 1, 2, 3].

function createArray(maxNumber) {
    let array = [];
    for (let i = 0; i <= maxNumber; ++i) {
        array.push(i);
    }
    return array;
}

createArray(7);


// Bài 5: 
// Viết một hàm nhận tham số là một mảng gồm các giá trị số. Hàm kiểm tra xem trong mảng
// truyền vào có giá trị nào bằng tổng của các giá trị còn lại hay không. Nếu có trả về giá trị đó, nếu
// không có trả về null.

function checkArray(array) {
    let sum = 0;
    for (let i = 0; i <= array.length-1; ++i) {
        sum += array[i];
    }
    for (let i = 0; i <= array.length-1; ++i) {
        if (array[i] == (sum/2)) {
            return true;
        }
    }
    return false;
}

checkArray([3, 8, 0, 1, 4]);