// Danh sách các sản phẩm có trong giỏ hàng
let products = [
    {
        name: "Iphone 13 Pro", // Tên sản phẩm
        price: 30000000, // Giá mỗi sản phẩm
        brand: "Apple", // Thương hiệu
        count: 2, // Số lượng sản phẩm trong giỏ hàng
    },
    {
        name: "Samsung Galaxy Z Fold3",
        price: 41000000,
        brand: "Samsung",
        count: 1,
    },
    {
        name: "IPhone 11",
        price: 15500000,
        brand: "Apple",
        count: 1,
    },
    {
        name: "OPPO Find X3 Pro",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },
]


// 1. In ra thông tin các sản phẩm trong giỏ hàng theo cấu trúc sau
// Tên - Giá - Thương Hiệu - Số lượng
// Ví dụ : OPPO Find X3 Pro - 19500000 - OPPO - 3

for (let item of products) {
    console.log(`${item.name} - ${item.price} - ${item.brand} - ${item.count}`)
}


// 2. Tính tổng tiền tất cả sản phẩm trong giỏ hàng
// Tổng tiền mỗi sản phẩm = price * count

let sum = 0;
for (let item of products) {
    sum += item.price * item.count;
}
console.log(sum);


// 3. Tìm các sản phẩm của thuơng hiệu "Apple"

for (let item of products) {
    if (item.brand == "Apple") {
        console.log(item.name);
    }
}


// 4. Tìm các sản phẩm có giá > 20000000

for (let item of products) {
    if (item.price > 20000000) {
        console.log(item.name);
    }
}


// 5. Tìm các sản phẩm có chữ "pro" trong tên (Không phân biệt hoa thường)

for (let item of products) {
    if (item.name.toLowerCase().includes("pro")) {
        console.log(item.name);
    }
}


// 6. Thêm 1 sản phẩm bất kỳ vào trong mảng product

products.push({
    name: "iPhone 12 Pro Max",
    price: 25000000,
    brand: "Apple",
    count: 5
})


// 7. Xóa tất cả sản phẩm của thương hiệu "Samsung" trong giỏ hàng

for (let i = 0; i < products.length; ++i) {
    if (products[i].brand == "Samsung") {
        products.splice(i, 1);
    }
}
console.log(products);


// 8. Sắp xếp giỏ hàng theo price tăng dần

products.sort((a, b) => {
    return a.price - b.price;
});
console.log(products);


// 9. Sắp xếp giỏ hàng theo count giảm dần

products.sort((a, b) => {
    return b.count - a.count;
});
console.log(products);


// 10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng

console.log(products[Math.floor(Math.random() * products.length)]);
console.log(products[Math.floor(Math.random() * products.length)]);