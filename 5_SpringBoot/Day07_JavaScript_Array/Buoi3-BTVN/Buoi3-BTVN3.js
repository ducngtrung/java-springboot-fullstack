// Bài 3: 
// Viêt 1 hàm nhận vào 2 tham số, trong đó:
//     Tham số đầu là 1 mảng,
//     Tham số sau là 1 số nguyên
//     Function này có chức năng tách mảng nhận vào ban đầu thành các mảng nhỏ hơn, và các mảng nhỏ hơn này có số phần tử bằng với tham số thứ 2 được truyền vào
//     Vdu: chunk([1, 2, 3, 4, 5], 2) => [1, 2], [3, 4], [5]

function chunkArray(array, chunkSize) {
    for (let i = 0; i < array.length; i += chunkSize) {
        let chunk = array.slice(i, i + chunkSize);
        console.log(chunk);
    }
}

chunkArray([3, 8, 0, 1, 4], 2);