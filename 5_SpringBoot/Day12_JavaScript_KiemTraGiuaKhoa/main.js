// Tạo 1 ứng dụng xem thời tiết đơn giản bằng javascript

// 1. Tạo 1 trang HTML có các yêu cầu sau:

//     1 input nhập vào tên của thành phố muốn xem thời tiết
//     1 Button submit
//     1 Button thêm mới để nhập thêm 1 thành phố mới muốn xem thời tiết (Tối đa 3 thành phố)
//     1 Button xoá để remove thành phố
//     1 Button refresh để reload lại trạng thái thời tiết. (Các icon của button có thể dung các icon sau https://heroicons.com/)
//     Khung hiển thị thông tin thời tiết, có đầy đủ các thông tin sau: Thời gian hiện tại, ngày tháng, tên thành phố, nhiệt độ hiện tại, icon mô tả thời tiết, độ ẩm, thời gian mặt trời mọc, thời gian mặt trời lặn.
//     Tham khảo hình sau (Thiết kế tuỳ ý, ko bắt buộc theo mẫu) hoặc tham khảo một số mẫu sau:
//         https://codepen.io/thomvallez/pen/NqyqWV
//         https://codepen.io/thecodingaviator/pen/BqBMYP

// 2. Sử dụng API weather để lấy thông tin:

//     Tạo tài khoản để lấy API key và hướng dẫn sử dụng api tại: https://www.weatherbit.io/
//     Document chi tiết API: https://www.weatherbit.io/api/weather-current (Xem kỹ)
//     Danh sách icon: https://www.weatherbit.io/api/codes (Lưu ý cần hiển thị icon theo ngày và đêm chính xác theo giờ hiện tại)


const searchInput = document.getElementById("search-field");
const submitBtn = document.getElementById('submit-button');
const removeBtn = document.getElementById('remove-cities-button');
const apiKey = "d9e0abf6205f408db0e3978faa96c84a";
var result;
var count = 0;

// Hàm gọi API để lấy dữ liệu thời tiết mới nhất
function getWeatherData() {
    // Lấy ra city đã được nhập ở ô tìm kiếm
    let cityToSearch = document.getElementById('search-field').value;
    let response = axios.get(`https://api.weatherbit.io/v2.0/current?&city=${cityToSearch}&key=${apiKey}`);
    response
        // Sau khi có data thì gọi hàm renderData
        .then(function(res) {
            result = res.data.data[0];
            ++count;
            while (count <= 3) {
                renderData(result);
                return;
            }
        })
        .catch(error => {
            console.log(error);
        })
}


function renderData(result) {
    document.getElementById(`card-${count}`).getElementsByClassName('city')[0].innerHTML = result.city_name;
    document.getElementById(`card-${count}`).getElementsByClassName('datetime')[0].innerHTML = "Date and time: " + result.ob_time;
    document.getElementById(`card-${count}`).getElementsByClassName('description')[0].innerHTML = result.weather.description;
    document.getElementById(`card-${count}`).getElementsByClassName('humidity')[0].innerHTML = "Humidity: " + result.rh + " %";
    document.getElementById(`card-${count}`).getElementsByClassName('temperature')[0].innerHTML = result.temp;
    document.getElementById(`card-${count}`).getElementsByClassName('weather-icon')[0].querySelector('img').src = `https://www.weatherbit.io/static/img/icons/${result.weather.icon}.png`;
    document.getElementById(`card-${count}`).getElementsByClassName('sunrise-time')[0].innerHTML = "Sunrise time (UTC): " + result.sunrise;
    document.getElementById(`card-${count}`).getElementsByClassName('sunset-time')[0].innerHTML = "Sunset time (UTC): " + result.sunset;
}


// Lắng nghe sự kiện khi nhấn phím Enter sau khi nhập từ khóa
searchInput.addEventListener("keypress", function(event) {
  if (event.key === "Enter") {
    // Cancel the default action, if needed
    event.preventDefault();
    // Trigger the button element with a click
    submitBtn.click();
  }
});

// Lắng nghe sự kiện khi click vào nút "Submit" để add city
submitBtn.addEventListener("click", function () {
    getWeatherData();
});

// Lắng nghe sự kiện khi click vào nút "Remove all cities" để xóa tất cả city
removeBtn.addEventListener("click", function () {
    let cards = document.querySelectorAll(".card");
    cards.forEach(card => {
        card.getElementsByClassName('city')[0].innerHTML = "";
        card.getElementsByClassName('datetime')[0].innerHTML = "";
        card.getElementsByClassName('description')[0].innerHTML = "";
        card.getElementsByClassName('humidity')[0].innerHTML = "";
        card.getElementsByClassName('temperature')[0].innerHTML = "";
        card.getElementsByClassName('weather-icon')[0].innerHTML = "";
        card.getElementsByClassName('sunrise-time')[0].innerHTML = "";
        card.getElementsByClassName('sunset-time')[0].innerHTML = ""
    });
    count = 0;
});