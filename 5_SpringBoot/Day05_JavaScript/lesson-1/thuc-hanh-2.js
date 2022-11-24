// BÀI 1:
// Áp dụng mệnh để điều kiện với bài tính chỉ số BMI và báo kết
// quả ra cửa sổ console về tình trạng cân nặng theo giá trị chiều cao và
// cân nặng đưa vào.

function calculateBMI(height, weight) {
    let BMI = weight / (height**2);
    if (BMI < 18.5) {
        console.log("\nChỉ số BMI: " + BMI + " - Underweight");
    } else if (BMI < 24.9) {
        console.log("\nChỉ số BMI: " + BMI + " - Normal weight");
    } else if (BMI < 29.9) {
        console.log("\nChỉ số BMI: " + BMI + " - Pre-obesity");
    } else {
        console.log("\nChỉ số BMI: " + BMI + " - Obesity");
    }
}
calculateBMI(1.73, 69);


// BÀI 2:
// Tạo các biến để lưu giá trị tên và tuổi của 2 người. Sử dụng
// mệnh đề điều kiện để so sánh tuổi của 2 người và báo kết quả ra cửa
// sổ console theo dạng chuỗi. Ví dụ: “Mai nhỏ hơn Tuấn 2 tuổi”, “Minh
// bằng tuổi Quang”, “Lâm lớn hơn Phong 3 tuổi”.

function compare_age(name1, age1, name2, age2) {
    if (age1 > age2) {
        console.log(`\n${name1} lớn hơn ${name2} ${age1-age2} tuổi`);
    } else if (age1 == age2) {
        console.log(`\n${name1} bằng tuổi ${name2}`);
    } else {
        console.log(`\n${name1} nhỏ hơn ${name2} ${age1-age2} tuổi`);
    }
}
compare_age("Mai", 20, "Tuấn", 18)


// BÀI 3:
// Viết điều kiện để tính tổng tiền hóa đơn của một cửa hàng ăn.
// Được biết với hóa đơn trong khoảng 100 - 400USD thì tiền tip tính
// bằng 10% hóa đơn, các trường hợp khác tiền tip tính bằng 15%. In ra
// của sổ console chi tiết của hóa đơn (Gồm tiền dịch vụ sử dụng, tip và
// tổng tiền cần thanh toán).

function print_invoice(amount) {
    let tip;
    if ((amount >= 100) && (amount <= 400)) {
        tip = amount*10/100;
    } else {
        tip = amount*15/100;
    }
    console.log("\nTiền dịch vụ: " + amount);
    console.log("Tiền tip: " + tip);
    console.log("\tTổng tiền: " + (amount+tip));
}
print_invoice(450)