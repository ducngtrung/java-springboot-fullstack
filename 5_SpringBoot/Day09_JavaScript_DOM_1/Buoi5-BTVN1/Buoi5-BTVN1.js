// Câu 1. Tạo 1 thẻ p có id=“text”, có nội dung bất kỳ (có thể tạo bằng HTML hay Javascript - tùy chọn).
// Yêu cầu:
    // Đặt màu văn bản thành #777
    // Đặt kích thước phông chữ thành 2rem
    // Đặt nội dung HTML thành Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript.

function question1() {
    paragraph = document.querySelector("#text");
    paragraph.style.color = "#777";
    paragraph.style.fontSize = "2rem";
    paragraph.innerHTML = "Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript."
}


// Câu 2. Sử dụng vòng lặp để đặt màu chữ cho tất cả thẻ li thành màu blue (tạo thẻ ul-li bằng html)
    // <ul>
    //     <li>Item 1</li>
    //     <li>Item 2</li>
    //     <li>Item 3</li>
    // </ul>

function question2() {
    liArray = Array.from(document.querySelector("ul").querySelectorAll("li"));
    liArray.forEach(li => li.style.color = "blue");
}


// Câu 3. Cho mã HTML có nội dung như sau (tạo thẻ ul-li bằng html):
    // <ul id="list">
    //    <li>Item 1</li>
    //    <li>Item 2</li>
    //    <li>Item 3</li>
    //    <li>Item 4</li>
    //    <li>Item 5</li>
    //    <li>Item 6</li>
    //    <li>Item 7</li>
    // </ul>
// Sử dụng javascript để thực hiện những công việc sau:
    // Thêm 3 thẻ <li> có nội dung Item 8, Item 9, Item 10 vào cuối danh sách
    // Sửa style cho thẻ <li> 1 thành màu đỏ (color)
    // Sửa background cho thẻ <li> 3 thành màu xanh lá (background-color)
    // Remove thẻ <li> 4
    // Thêm thẻ <li> mới thay thế cho thẻ <li> 4 bị xóa ở bước trước, thẻ <li> mới có nội dung bất kỳ

function question3() {
    myList = document.getElementById("list");
    
    // Thêm 3 thẻ <li> có nội dung Item 8, Item 9, Item 10 vào cuối danh sách
    myList.innerHTML += "<li>Item 8</li> <li>Item 9</li> <li>Item 10</li>";
    
    // Sửa style cho thẻ <li> 1 thành màu đỏ (color)
    liElements = myList.querySelectorAll("li");
    liElements[0].style.color = "red";
    
    // Sửa background cho thẻ <li> 3 thành màu xanh lá (background-color)
    liElements[2].style.backgroundColor = "green";
    
    // Remove thẻ <li> 4
    liElements[3].remove();
    
    // Thêm thẻ <li> mới thay thế cho thẻ <li> 4 bị xóa ở bước trước, thẻ <li> mới có nội dung bất kỳ
    newNode = document.createElement("li");
    newNode.innerHTML = "New item";
    myList.insertBefore(newNode, liElements[4]);
}