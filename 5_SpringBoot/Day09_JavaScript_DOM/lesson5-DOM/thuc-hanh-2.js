// Bài 1: Viết một hàm nhận 2 tham số là các giá trị chuỗi, tham số thứ nhất đại diện cho CSS Selector, tham số thứ 2 là nội dung text. Hàm tìm ra phần tử HTML có CSS Selector như tham số 1 và thay nội dung text của nó bằng giá trị của tham số thứ 2. Chú ý, trong trường hợp không tìm thấy phần tử HTML nào phương thức DOM sẽ trả về null, null.textContent sẽ báo lỗi. Trong trường hợp này, hàm trả về return (không cần trả về giá trị) để ngăn code không thực thi tiếp.

function editSelector1(selector, text) {
    paragraph = document.querySelector(selector);
    if (paragraph == null) {
        return;
    }
    paragraph.textContent = text;
    console.log(document.querySelector(selector));
}

editSelector1(".second-text", "New Content");


// Bài 2: Viết một hàm nhận 2 tham số, tham số 1 là giá trị chuỗi đại diện cho CSS Selector, tham số 2 là một object gồm các key sau: element (tên thẻ HTML), content (text hoặc nội dung HTML), className (tên CSS class). Hàm tìm ra phần tử HTML có CSS Selector như tham số 1 và thay đổi nội dung HTML của nó theo dữ liệu của tham số thứ 2. (Style cho tên class trong object)

function editSelector2(selector, object) {
    paragraph = document.querySelector(selector);
    if (paragraph == null) {
        return;
    }
    paragraph.innerHTML = `<${object.element} class="${object.className}">${object.content}</${object.element}>`;
    console.log(document.querySelector(selector));
}

editSelector2(".second-text", {element: "b", content: "New Content", className: "bold-text"});


// Bài 3: Viết một hàm nhận 2 tham số là các giá trị chuỗi, tham số thứ nhất đại diện cho CSS Selector, tham số thứ 2 nhận một trong 2 giá trị là “add” hoặc “remove”. Hàm tìm ra phần tử HTML có CSS Selector như tham số 1 và thêm hoặc xóa tên class “active” cho phần tử đó dựa theo giá trị của tham số thứ 2. (Style cho phần tử đó trong trường hợp có class “active”).

function editSelector3(selector, action) {
    paragraph = document.querySelector(selector);
    if (paragraph == null) {
        return;
    }
    if (action == "add") {
        paragraph.classList.add("active");
    } else if (action == "remove") {
        paragraph.classList.remove("active");
    }
    console.log(document.querySelector(selector));
}

editSelector3(".first-text", "add");
editSelector3(".first-text", "remove");