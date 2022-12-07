const btn = document.getElementById('btn');
const image = document.getElementById('image');
const select = document.getElementById('breed-list');

// Hàm gọi API để lấy danh sách breed
function getBreedList() {
    let response = axios.get("https://dog.ceo/api/breeds/list/all");
    // debugger;
    response
        // Sau khi có data thì hiển thị kết quả lên giao diện
        .then(function(res) {
            renderBreed(res.data.message); // res.data.message la một map chứa danh sách breed
        })
        .catch(error => {
            console.log(error);
        })
}

// Hàm duyệt qua từng key trong danh sách breed -> tạo thẻ option tương ứng -> dùng DOM để gắn option vào trong thẻ select
function renderBreed(breedList) {
    Object.keys(breedList).forEach(breed => {
        let newOption = document.createElement("option");
        newOption.innerHTML = breed;
        newOption.value = breed;
        select.appendChild(newOption);
    });
}

// Hàm gọi API để lấy ảnh breed theo tên
function getDogImage() {
    let requestURL = "".concat(document.querySelectorAll("p")[0].innerText, 
                                document.getElementById("breed-list").value,
                                document.querySelectorAll("p")[1].innerText);
    console.log(requestURL);
    let response = axios.get(requestURL);
    // debugger;
    response
        .then(function(res) { 
            // Gán image URL cho thẻ image
            image.src = res.data.message;
        })
        .catch(error => {
            console.log(error);
        })
}


// Khi vừa load trang web phải lấy được danh sách breed từ API
getBreedList();

// Lắng nghe sự kiện khi click vào nút "Fetch" để hiển thị ảnh breed
btn.addEventListener("click", function () {
    getDogImage();
})