// Bài 1: Hoán đổi giá trị của biến

// Viết function nhận vào 2 arguments là 2 số, log ra console tên và value của 2 biến đó (vdu: Biến foo có giá trị bằng 2, bar có giá trị bằng 5). Sau đó xử lý để hoán đổi giá trị của 2 biến này và log ra console để được kết quả như sau:

// foo has value 2
// bar has value 5
// swapping ...
// foo has value 5
// bar has value 2

function swapNumber(foo, bar) {
    console.log(`foo has value ${foo}`);
    console.log(`bar has value ${bar}`);
    console.log("swapping...")
    temp = foo;
    foo = bar;
    bar = temp;
    console.log(`foo has value ${foo}`);
    console.log(`bar has value ${bar}`);
}

swapNumber(12, 24);