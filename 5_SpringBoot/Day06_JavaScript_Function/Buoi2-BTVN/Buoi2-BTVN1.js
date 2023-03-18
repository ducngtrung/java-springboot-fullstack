// Bài 1: 
// Viết function truyền vào 1 số nguyên dường. Tính giai thừa của số đó
// Ví dụ: calculateFactorial(5) = 5 * 4 * 3 * 2 * 1 = 120

function calculateFactorial(number) {
    if ((number == 0) || (number == 1)) return 1;
    let result = 1;
    for (let i = 2; i <= number; ++i) {
        result = result * i;
    }
    return result;
}

calculateFactorial(5);