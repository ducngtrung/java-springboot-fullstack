var name = "Huyen";

function createParagraph() {
    const para = document.createElement('p');

    var name = "Duc"; // biến được khai báo bằng từ khóa var khả dụng trong phạm vi function
    {
        let name = "ABC";
        console.log(name); // biến được khai báo bằng từ khóa let chỉ khả dụng trong block hiện tại
    }
    console.log(name);
    para.textContent = name;
    document.body.appendChild(para);
}

console.log(name);

const buttons = document.querySelectorAll('button');

for (const button of buttons) {
    button.addEventListener('click', createParagraph);
}

a = "hom nay la thu hai" // Kiểu dữ liệu literal
String("hom nay la thu hai") // Kiểu dữ liệu primitive