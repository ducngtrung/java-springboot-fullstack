// 1. Định nghĩa các biến và hàm
const API_URL = "http://localhost:8080/api/v1";
const btnUpdate = document.getElementById("btn-save");
const btnChangePassword = document.getElementById("btn-change-password");
const btnForgotPassword = document.getElementById("btn-forgot-password");
const selectAddress = document.getElementById("address");
const imageContainer = document.querySelector(".image-container");
const btnChooseImage = document.getElementById("btn-choose-image");
const btnDeleteImage = document.getElementById("btn-delete-image");
const avatarPreview = document.getElementById("avatar-preview");
const avatarInput = document.getElementById("avatar-input");
const modalImage = new bootstrap.Modal(document.getElementById("modal-image"), {
    keyboard: false
})

// Lấy ra userId từ đường dẫn trên address bar của cửa sổ trình duyệt
const params = new URLSearchParams(window.location.search);
const userId = params.get("id");

// Nếu userId = null thì điều hướng đến trang 404.html
if (!userId) {
    window.location.href = "../html/404.html"
}

// Lấy thông tin user hiện tại và hiển thị lên giao diện
const getUser = async () => {
    let response = axios.get(`${API_URL}/users/${userId}`);
    response
        .then((res) => {
            console.log(res.data);
            let user = res.data;
            // Hiển thị thông tin name, email, phone, avatar lên giao diện
            $("#fullname").val(user.name);
            $("#email").val(user.email);
            $("#phone").val(user.phone);
            avatarPreview.src = user.avatar;
            // Render danh sách tỉnh thành và hiển thị tỉnh thành của user hiện tại
            let userAddress = user.address;
            getProvinces(userAddress);
        })
        .catch((error) => {
            console.log(error);
        })
}

// Hàm gọi API để lấy danh sách tỉnh thành và hiển thị tỉnh thành của user hiện tại
const getProvinces =  async (userAddress) => {
    try { 
        // Gọi API
        let response = await axios.get("https://provinces.open-api.vn/api/p/");
        console.log(response);
        let provinces = response.data; // Lưu lại dữ liệu trả về từ server (dưới dạng array)

        // Hiển thị dữ liệu lên giao diện
        renderProvinces(provinces, userAddress);
    } catch (error) {
        console.log(error);
    }
}

// Hàm duyệt qua từng key trong danh sách tỉnh thành -> tạo thẻ option tương ứng -> dùng DOM để đưa thẻ option vào trong thẻ select
const renderProvinces = (array, userAddress) => {
    array.forEach(province => {
        let newOption = document.createElement("option");
        newOption.innerHTML = province.name;
        newOption.value = province.name;
        selectAddress.appendChild(newOption);
        // Nếu province name = tỉnh thành của user hiện tại thì set province đó làm option mặc định
        if (province.name == userAddress) {
            selectAddress.selectedIndex = array.indexOf(province);
        }
    });
}

// Cập nhật thông tin user (name, phone, address)
btnUpdate.addEventListener("click", async () => {
    try {
        const address = document.getElementById("address").value;
        let response = await axios.put(`${API_URL}/users/${userId}`, {
            "name" : $("#fullname").val(),
            "phone" : $("#phone").val(),
            "address" : address,
        });
        console.log(response);
    } catch (error) {
        console.log(error);
    }
})

// Đổi mật khẩu
btnChangePassword.addEventListener("click", async () => {
    try {
        await axios.put(`${API_URL}/users/${userId}/update-password`, {
            "oldPassword" : $("#old-password").val(),
            "newPassword" : $("#new-password").val()
        });
        alert("Đổi mật khẩu thành công!");
    } catch (error) {
        alert(error.response.data.message);
    }
})

// Quên mật khẩu (alert mật khẩu mới sau khi gọi API thành công)
btnForgotPassword.addEventListener("click", async () => {
    try {
        let response = await axios.get(`${API_URL}/users/${userId}/forgot-password`);
        alert("Mật khẩu mới: " + response.data);
    } catch (error) {
        console.log(error);
    }
})


// Quản lý ảnh
// Khởi tạo mảng chứa images
let images = [];

// Lấy danh sách đường dẫn ảnh của user hiện tại
const getImages = async () => {
    try {
        // Gọi API
        let response = await axios.get(`${API_URL}/users/${userId}/files`);
        console.log(response);
        images = response.data; // images là một array chứa các image path

        renderPaginationAndRenderImages(images);
    } catch (error) {
        console.log(error);
    }
}

// Hiển thị ảnh lên giao diện
const renderImages = (array) => {
    imageContainer.innerHTML = "";
    let html = "";
    array.forEach(imagePath => {
        html += `
            <div class="image-item" onclick="chooseImage(this)">
                <img
                    src="http://localhost:8080${imagePath}"
                    alt="ảnh"
                />
            </div>
        `
    });
    imageContainer.innerHTML = html;

    // Disable các button "Chọn ảnh" và "Xóa ảnh"
    btnChooseImage.disabled = true;
    btnDeleteImage.disabled = true;
}

// Phân trang hiển thị ảnh
// Đọc thêm: https://pagination.js.org/
const renderPaginationAndRenderImages = (array) => {
    $(".pagination-container").pagination({
        dataSource: array,
        pageSize: 8,
        callback: function(data, pagination) {
            console.log(data);
            console.log(pagination);
            renderImages(data);
        }
    })
}

// Chọn ảnh
// Khi click vào một image element thì nó phải được highlight, các button chức năng phải active
const chooseImage = (imageElement) => {
    // Xóa ảnh đã được highlight trước đó (nếu có)
    const imageActiveElement = document.querySelector(".image-active");
    if (imageActiveElement) {
        imageActiveElement.classList.remove("image-active");
    }

    // Highlight ảnh đang chọn bằng cách gán thêm class "image-active" (đã được style CSS)
    imageElement.classList.add("image-active");

    // Enable các button "Chọn ảnh" và "Xóa ảnh"
    btnChooseImage.disabled = false;
    btnDeleteImage.disabled = false;
}

// Xóa ảnh
btnDeleteImage.addEventListener("click", async () => {
    try {
        const imageActiveElement = document.querySelector(".image-active img");
        // Nếu chưa có active image thì kết thúc
        if (!imageActiveElement) {
            return;
        }

        // Lấy đường dẫn của ảnh đang active
        const url = imageActiveElement.src;

        // Gọi API để xóa ảnh trên server
        await axios.delete(url);

        // Xóa ảnh ở client bằng cách lọc ra các đường dẫn ảnh không chứa biến "url" bên trên
        // Ví dụ: Nếu "url" là http://localhost:8080/api/v1/users/1/files/1671175129
        // Mảng "images" gồm các đường dẫn sau:
            // /api/v1/users/1/files/1671022047
            // /api/v1/users/1/files/1671021675
            // /api/v1/users/1/files/1671175129
        // thì chỉ lọc ra 2 đường dẫn đầu tiên
        images = images.filter(image => !url.includes(image))

        // Render lại mảng "images"
        renderPaginationAndRenderImages(images);
    } catch (error) {
        console.log(error);
    }
})

// Thay đổi ảnh avatar của user
btnChooseImage.addEventListener("click", async () => {
    try {
        const imageActiveElement = document.querySelector(".image-active img");
        // Nếu chưa có active image thì kết thúc
        if (!imageActiveElement) {
            return;
        }

        // Lấy đường dẫn của ảnh đang active
        const url = imageActiveElement.src;
        console.log(url);

        // Gọi API để update avatar trên server
        await axios.put(`${API_URL}/users/${userId}/update-avatar`, {
            "avatar" : url
        });
        
        // Update avatar ở client
        avatarPreview.src = url;

        // Đóng modal chọn ảnh
        modalImage.hide();
    } catch (error) {
        console.log(error);
    }
})

// Upload ảnh
avatarInput.addEventListener("change", async (event) => {
    try {
        // Lấy ra file cần upload
        const fileToUpload = event.target.files[0];

        // Tạo đối tượng Form Data
        const formData = new FormData();
        formData.append("file", fileToUpload);

        // Gọi API để upload ảnh, trả về đường dẫn mới của ảnh
        const response = await axios.post(`${API_URL}/users/${userId}/files`, formData);
        
        // Cập nhật ảnh vừa upload lên client
        images.unshift(response.data); // Đưa đường dẫn của ảnh vừa upload vào đầu mảng "images"
        renderPaginationAndRenderImages(images);
    } catch (error) {
        console.log(error);
    }
})


// 2. Chạy chương trình
// Vừa load trang sẽ gọi các hàm này
getUser();
getImages();