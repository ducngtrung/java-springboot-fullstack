// Bài 1: Trong HTML, viết một thẻ có content là một số (mặc định là 0) và hai nút button có nội dung là “+” và “-”.
// Khi click vào nút cộng hoặc nút trừ sẽ cập nhật giá trị của số trên.

let btn1 = document.getElementById("buttons-group").querySelectorAll(".btn")[0]
let btn2 = document.getElementById("buttons-group").querySelectorAll(".btn")[1];
let number = parseInt(document.querySelector(".content").innerText);

btn1.addEventListener("click", function increase(){
    ++number;
    document.querySelector(".content").innerText = String(number)
});

btn2.addEventListener("click", function decrease(){
    --number;
    document.querySelector(".content").innerText = String(number);
})


// Bài 2: Giả sử cửa sổ trình duyệt của bạn là một căn phòng, nền trắng là đang bật đèn. Hãy tạo một nút button để tắt đèn của căn phòng này. Hãy quy định content hoặc style cho nút này để người dùng biết ấn vào sẽ thế nào (Ví dụ đèn đang sáng thì content ghi là “On”, ấn tắt đi thì chuyển sang “Off”). Có thể thêm icon hình bóng đèn và đổi màu nền của button sang màu tối hơn khi đèn tắt.

let btn3 = document.getElementById("button").querySelector(".btn");
btn3.addEventListener("click", function switchLight(){
    let btnText = btn3.innerText;
    if (btnText == "Light On") {
        btn3.textContent = "Light Off";
        document.getElementById("button").style.background = "gray";
    } else {
        btn3.textContent = "Light On";
        document.getElementById("button").style.background = "white";
    }
});