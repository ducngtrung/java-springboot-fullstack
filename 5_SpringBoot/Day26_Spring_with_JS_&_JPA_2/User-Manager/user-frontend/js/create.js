// 1. Định nghĩa các biến và hàm
const API_URL = "http://localhost:8080/api/v1";
const btnSave = document.getElementById("btn-save");
const selectAddress = document.getElementById("address");

// Hàm gọi API để lấy danh sách tỉnh thành
const getProvinces =  async () => {
    try { 
        // Gọi API
        let response = await axios.get("https://provinces.open-api.vn/api/p/");
        console.log(response);
        let provinces = response.data; // Lưu lại dữ liệu trả về từ server (dưới dạng array)

        // Hiển thị dữ liệu lên giao diện
        renderProvinces(provinces);
    } catch (error) {
        console.log(error);
    }
}

// Hàm duyệt qua từng key trong danh sách tỉnh thành -> tạo thẻ option tương ứng -> dùng DOM để đưa thẻ option vào trong thẻ select
const renderProvinces = (array) => {
    array.forEach(province => {
        let newOption = document.createElement("option");
        newOption.innerHTML = province.name;
        newOption.value = province.name;
        selectAddress.appendChild(newOption);
    });
}

// Tạo user mới
btnSave.addEventListener("click", async () => {
    try {
        const address = document.getElementById("address").value;
        let response = await axios.post(`${API_URL}/users`, {
            "name" : $("#name").val(),
            "email" : $("#email").val(),
            "phone" : $("#phone").val(),
            "address" : address,
            "password" : $("#password").val()
        });
        console.log(response);

        // Tạo user xong thì điều hướng về trang index.html
        window.location.href = "./index.html";
    } catch (error) {
        console.log(error.response.data);
        alert(error.response.data.message);
    }
})


// 2. Chạy chương trình
// Vừa load trang sẽ gọi hàm này
getProvinces();