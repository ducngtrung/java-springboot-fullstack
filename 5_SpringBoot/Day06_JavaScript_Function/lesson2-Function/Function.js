// Các cách khai báo function

// Cách 1:
function calSquare1(a, b) {
    console.log(`Biến a là ${a}`);
    console.log(`Biến b là ${b}`);
    return a * b;
}

calSquare1(3, 5);


// Cách 2: Dùng function expression
const calSquare2 = function(a, b) {
    console.log(`Biến a là ${a}`);
    console.log(`Biến b là ${b}`);
    return a * b;
}

calSquare2(2, 4);


// Cách 3:
const calSquare3 = (a, b) => {
    return a * b;
}

calSquare3(4, 5);


// Function nhận tham số là một function khác
function testFunction(a, b, newFunction) {
    result = newFunction(a, b);
    return result;
}

function sumFuction(a, b) {
    return a + b;
}

testFunction(3, 4, sumFuction)


// Toán tử 3 ngôi
a = 1;
b = 2;
c = a < b ? 3 : 4