// BÀI 1:
// Áp dụng switch-case với bài tính chỉ số BMI và báo kết quả ra cửa sổ console về tình trạng cân nặng theo giá trị chiều cao và cân nặng đưa vào.

function calculateBMI(height, weight) {
    let BMI = weight / (height**2);
    switch (true) {
        case (BMI < 18.5):
            console.log("Chỉ số BMI: " + BMI + " - Underweight");
            break;
        case (BMI < 24.9):
            console.log("Chỉ số BMI: " + BMI + " - Normal weight");
            break;
        case (BMI < 29.9):
            console.log("Chỉ số BMI: " + BMI + " - Pre-obesity");
            break;
        default:
            console.log("Chỉ số BMI: " + BMI + " - Obesity");
            break;
    }
}

calculateBMI(1.73, 69);


// Bài 2: 
// Trong bài tập so sánh tuổi trong buổi 1, hãy thêm 2 biến mới là
// “olderPerson” và “youngerPerson” để lưu giá trị tuổi theo tên người lớn
// tuổi hơn và người nhỏ hơn, sử dụng toán tử ba ngôi để gán giá trị
// cho 2 biến này. Kết quả chỉ cần báo là ai lớn hơn ai bao nhiêu tuổi.
// Không xét đến trường hợp bằng tuổi.

function compareAge(name1, age1, name2, age2) {
    if (age1 == age2) {
        console.log(`${name1} bằng tuổi ${name2}`);
    } else {
        olderPerson = age1 > age2 ? name1 : name2;
        youngerPerson = age1 < age2 ? name1 : name2;
        console.log(`${olderPerson} lớn hơn ${youngerPerson} ${Math.abs(age1-age2)} tuổi`);
    }
}

compareAge("Mai", 18, "Tuấn", 20);


// Bài 3: 
// Quy ước giá trị từ 0 - 6 đại diện cho các ngày trong tuần (0 - Chủ Nhật, 1 - Thứ Hai, ...). Tạo một biến chứa giá trị số trong khoảng trên, sử dụng switch/case và mệnh đề điều kiện để in ra console giá trị theo biến trên theo dạng “Thứ Tư - Ngày trong tuần”,
// “Thứ Bảy - Ngày cuối tuần”...

function checkDay(number) {
    typeOfDay = ((number == 0) || (number == 6)) ? "Ngày cuối tuần" : "Ngày trong tuần";
    switch (number) {
        case 0:
            console.log(`Chủ nhật - ${typeOfDay}`);
            break;
        case 1:
            console.log(`Thứ hai - ${typeOfDay}`);
            break;
        case 2:
            console.log(`Thứ ba - ${typeOfDay}`);
            break;
        case 3:
            console.log(`Thứ tư - ${typeOfDay}`);
            break;
        case 4:
            console.log(`Thứ năm - ${typeOfDay}`);
            break;
        case 5:
            console.log(`Thứ sáu - ${typeOfDay}`);
            break;
        case 6:
            console.log(`Thứ bảy - ${typeOfDay}`);
            break;
        default:
            console.log("Không hợp lệ");
            break;
    }
}

checkDay(1);