// Bài 3: Giới hạn tốc độ

// Viết function kiểm tra số nhập vào (Context là kiểm tra tốc độ):

//     Nếu số nhập vào trong giới hạn cho phép 70 => Log ra Good safe driving
//     Nếu số nhập vào vượt giới hạn 70km/h, với mỗi 5km/h vượt lên tính là 1 điểm phạt => Log ra Speed Limit Crossed by XXX point (vdu: 80km/h => Speed limit crossed by 2 point)
//     Nếu số nhập vào vượt giới hạn 70km/h 10 điểm phạt => Log ra License Suspended

function checkSpeed(speed) {
    if (speed <= 70) {
        console.log("Good safe driving");
    } else if ((speed-70)/5 <= 10) {
        console.log(`Speed Limit Crossed by ${(speed-70)/5} point(s)`);
    } else {
        console.log("License Suspended");
    }
}

checkSpeed(80);