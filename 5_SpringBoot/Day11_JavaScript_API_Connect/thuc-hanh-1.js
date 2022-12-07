// Công việc 1 : Giả sử sau 4s thì thực hiện xong
function funcA() {
    setTimeout(function () {
        console.log("three");
    }, 4000)
}

// Công việc 2 : Giả sử sau 3s thì thực hiện xong
function funcB() {
    setTimeout(function () {
        console.log("four");
    }, 3000)
}

// Tổng thời gian thực hiện hết cả công việc 1 và công việc 2 là 4s
funcA();
funcB();