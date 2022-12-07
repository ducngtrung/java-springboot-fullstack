const btn = document.getElementById('btn');
const image = document.getElementById('image');
const select = document.getElementById('breed-list');
const list = document.getElementById('sub-breed-list');

// Hàm gọi API để lấy danh sách breed
function getBreedList() {
    let response = axios.get("https://dog.ceo/api/breeds/list/all");
    response
        // Sau khi có data thì gọi hàm renderBreed
        .then(function(res) {
            // debugger;
            renderBreed(res.data.message); // res.data.message là một json chứa danh sách breed
        })
        .catch(error => {
            console.log(error);
        })
}

// Hàm duyệt qua từng key trong danh sách breed -> tạo thẻ option tương ứng -> dùng DOM để đưa thẻ option vào trong thẻ select
function renderBreed(breedList) {
    Object.keys(breedList).forEach(breed => {
        let newOption = document.createElement("option");
        newOption.innerHTML = breed;
        newOption.value = breed;
        select.appendChild(newOption);
    });
}

// Hàm gọi API để lấy danh sách breed
function getSubBreedList() {
    // Lấy ra breed đang được select
    let activeBreed = document.getElementById("breed-list").value;

    let response = axios.get(`https://dog.ceo/api/breed/${activeBreed}/list`);
    response
        // Sau khi có data thì gọi hàm renderSubBreed
        .then(function (res) {
            // debugger;
            renderSubBreed(res.data.message); // res.data.message là một array chứa sub-breed
        })
        .catch(error => {
            console.log(error);
        })
}

// Hàm duyệt qua từng key trong danh sách sub-breed -> tạo thẻ li tương ứng -> dùng DOM để đưa thẻ li vào trong thẻ ul
function renderSubBreed(subBreedList) {
    // Refresh (làm rỗng) list
    list.textContent = "";
    // Nếu không có sub-breed nào trong list thì hiển thị "Sub-breed not found"
    if (subBreedList.length == 0) {
        let newItem = document.createElement("li");
        newItem.innerHTML = "Sub-breed not found";
        list.appendChild(newItem);
        return;
    } else { // Nếu có sub-breed thì tạo các item tương ứng và add vào trong list
        subBreedList.forEach(subBreed => {
            let newItem = document.createElement("li");
            newItem.innerHTML = subBreed;
            newItem.className = "item";
            newItem.style.cursor = "pointer";
            list.appendChild(newItem);
        });
    }
}

// Hàm gọi API để lấy ảnh breed theo tên
function getSubBreedImage(subBreed) {
    let activeBreed = document.getElementById("breed-list").value;

    let response = axios.get(`https://dog.ceo/api/breed/${activeBreed}/${subBreed}/images/random`);
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

// Lắng nghe sự kiện khi click vào nút "Get sub-breed" để lấy danh sách sub-breed
btn.addEventListener("click", function () {
    getSubBreedList();
})

// Lắng nghe sự kiện khi click vào thẻ li để hiển thị ảnh sub-breed
list.addEventListener("click", function(event) {
    if (event.target && event.target.matches("li.item")) {
        let activeSubBreed = event.target.innerText;
        getSubBreedImage(activeSubBreed);
    }
});