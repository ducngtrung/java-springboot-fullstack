const btn1 = document.getElementById("btn1");
const image1 = document.getElementById("image1");

// Lắng nghe sự kiện khi click vào nút "random"
btn1.addEventListener("click", function () {
    getRandomImage1();
})

// Hàm gọi API để lấy dữ liệu và hiển thị
async function getRandomImage1() { // Khi thêm "async" ở đầu function thì đó gọi là function bất đồng bộ, function này luôn return một Promise. Một Promise không bao giờ có kết quả ngay mà ban đầu sẽ ở trạng thái pending.
    try {
        // Gọi API lấy ảnh random của dog
        let response = await axios.get("https://dog.ceo/api/breeds/image/random"); // await dùng để chờ kết quả từ Promise

        // debugger;

        // Gán URL cho thẻ image
        image1.src = response.data.message;
    } catch (error) {
        console.log(error);
    }
}


// Cách 2:
const btn2 = document.getElementById("btn2");
const image2 = document.getElementById("image2");

// Lắng nghe sự kiện khi click vào nút "random"
btn2.addEventListener("click", function () {
    getRandomImage2();
})

// Hàm gọi API để lấy dữ liệu và hiển thị
function getRandomImage2() {
    let response = axios.get("https://dog.ceo/api/breeds/image/random");
    // debugger;
    response
        .then(function(res) { // hoặc .then(res => {
            // Gán URL cho thẻ image
            image2.src = res.data.message;
        })
        .catch(error => {
            console.log(error);
        })
}