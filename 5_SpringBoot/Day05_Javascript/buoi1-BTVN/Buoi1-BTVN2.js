// Bài 2: FooBar

// Viết function kiểm tra số nhập vào có thỏa mãn điều kiện không.
// Nếu có log ra console như sau:

//     Nếu chia hết cho 3 => Log ra Foo
//     Nếu chia hết cho 5 => Log ra Bar
//     Nếu chia hết cho cả 3 và 5 => Log ra FooBar
//     Nếu không chia hết cho cả 3 và 5 => Log ra Not FooBar
//     Nếu số nhập vào không phải là Number => Log ra Not a Number!

function checkNumber(number) {
    if (number % 15 == 0) {
        console.log("FooBar");
    } else if (number % 3 == 0) {
        console.log("Foo");
    } else if (number % 5 == 0) {
        console.log("Bar");
    } else if (!isNaN(number)) { // hoặc (Number.isFinite(number))
        console.log("Not FooBar");
    } else {
        console.log("Not a Number");
    }
}

checkNumber(12);