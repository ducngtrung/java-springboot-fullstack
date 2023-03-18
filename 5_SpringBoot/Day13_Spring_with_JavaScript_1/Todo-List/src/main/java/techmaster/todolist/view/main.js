// 1. Định nghĩa các biến và hàm
const API_URL = "http://localhost:8080/api/v1";
const todoListElement = document.getElementById("todolist");
let todos = [];

// Lấy danh sách todo và hiển thị
const getTodos = async () => {
    try {
        // Gọi API
        let response = await axios.get(`${API_URL}/todos`);
        console.log(response);
        todos = response.data; // Lưu lại dữ liệu trả về từ server (dưới dạng array)

        // Hiển thị dữ liệu lên giao diện
        renderTodos(todos);
    } catch (error) {
        console.log(error);
    }
}

const renderTodos = (array) => {
    todoListElement.innerHTML = "";

    if (array.length === 0) {
        todoListElement.innerHTML = '<b>Không có công việc nào trong danh sách</b>';
        return;
    } else {
        let html = "";
        array.forEach(todo => {
            html += `
                <li>
                    <input type="checkbox" id="checkbox-${todo.id}" ${todo.status ? "checked" : ""}>
                    <span class=${todo.status ? "todo-done" : ""}>${todo.title}</span>
                    <button onclick="updateTitle(${todo.id})">Update title</button>
                    <button onclick="updateStatus(${todo.id})">Update status</button>
                    <button onclick="deleteTodo(${todo.id})">Delete</button>
                </li>
            `
        });
        todoListElement.innerHTML = html;
    }
}

const createTodo = () => {
    let newTodoTitle = document.getElementById('input-field').value;
    let response = axios.post(`${API_URL}/todos`, {
        "title" : newTodoTitle,
        "status" : false
    });
    response
        .then((res) => {
            console.log(res);
            alert("Todo created successfully");
            getTodos();
        })
        .catch((error) => {
            console.log(error.response.data);
            alert(error.response.data.message);
        })
}

const updateTitle = (id) => {
    console.log("id to update: " + id);
    let newTitle = document.getElementById('input-field').value;
    let currentStatus = document.getElementById(`checkbox-${id}`).parentNode.querySelector("span").classList.contains("todo-done");
    let response = axios.put(`${API_URL}/todos/${id}`, {
        "title" : newTitle,
        "status" : currentStatus
    });
    response
        .then((res) => {
            console.log(res);
            alert("Todo updated successfully");
            getTodos();
        })
        .catch((error) => {
            console.log(error.response.data);
            alert(error.response.data.message);
        })
}

const updateStatus = (id) => {
    console.log("id to update: " + id);
    let newStatus = document.getElementById(`checkbox-${id}`).checked;
    let currentTitle = document.getElementById(`checkbox-${id}`).parentNode.querySelector("span").innerHTML;
    let response = axios.put(`${API_URL}/todos/${id}`, {
        "title" : currentTitle,
        "status" : newStatus
    });
    response
        .then((res) => {
            console.log(res);
            alert("Todo updated successfully");
            getTodos();
        })
        .catch((error) => {
            console.log(error.response.data);
            alert(error.response.data.message);
        })
}

const deleteTodo = (id) => {
    console.log("id to delete: " + id);
    let response = axios.delete(`${API_URL}/todos/${id}`);
    response
        .then((res) => {
            console.log(res);
            alert("Todo deleted successfully");
            getTodos();
        })
        .catch((error) => {
            console.log(error);
        })
}


// 2. Chạy chương trình
// Vừa load trang sẽ gọi hàm này
getTodos();