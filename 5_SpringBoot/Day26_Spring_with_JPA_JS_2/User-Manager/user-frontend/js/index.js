// 1. Định nghĩa các biến và hàm
const API_URL = "http://localhost:8080/api/v1";
const userTable = document.querySelector("tbody");
const searchInput = document.getElementById("search");
let todos = [];


// Lấy danh sách users và hiển thị
const getUsers = async () => {
    try {
        // Gọi API
        let response = await axios.get(`${API_URL}/users`);
        console.log(response);
        let users = response.data; // Lưu lại dữ liệu trả về từ server (dưới dạng array)

        // Hiển thị dữ liệu lên giao diện
        renderUsers(users);
    } catch (error) {
        console.log(error);
    }
}


// Render thông tin users (id, name, email, phone, address) lên trang index.html
const renderUsers = (array) => {
    userTable.innerHTML = "";

    if (array.length === 0) {
        userTable.innerHTML = '<span>Không có user nào</span>';
        return;
    } else {
        let html = "";
        array.forEach(user => {
            html += `
                <tr>
                  <td>${user.id}</td>
                  <td>${user.name}</td>
                  <td>${user.email}</td>
                  <td>${user.phone}</td>
                  <td>${user.address}</td>
                  <td>
                    <a href="./detail.html?id=${user.id}" class="btn btn-success"
                      >Xem chi tiết</a
                    >
                    <button class="btn btn-danger" onclick="deleteUser(${user.id})">Xóa</button>
                  </td>
                </tr>
            `
        });
        userTable.innerHTML = html;
    }
}


// Tìm kiếm user theo tên (lắng nghe sự kiện nhấn phím Enter sau khi nhập từ khóa)
searchInput.addEventListener("keypress", async (event) => {
    if (event.key === "Enter") {
        // Cancel the default action, if needed
        event.preventDefault();
        try {
            const nameToSearch = document.getElementById("search").value;
            // Gọi API
            let response = await axios.get(`${API_URL}/users/search?name=${nameToSearch}`);
            console.log(response);
            let searchResult = response.data; // Lưu lại dữ liệu trả về từ server (dưới dạng array)

            // Hiển thị dữ liệu lên giao diện
            renderUsers(searchResult);
        } catch (error) {
            console.log(error);
        }
    }
});


// Xóa user
const deleteUser = (id) => {
    console.log("id to delete: " + id);
    let response = axios.delete(`${API_URL}/users/${id}`);
    response
        .then((res) => {
            console.log(res);
            getUsers();
        })
        .catch((error) => {
            console.log(error);
        })
}


// 2. Chạy chương trình
// Vừa load trang sẽ gọi hàm này
getUsers();