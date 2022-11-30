// Bài 1: Tạo một biến lưu thông tin về một con vật nuôi trong nhà là một object gồm các key sau: type (chó, mèo, chim...), name, breed (giống), hairColor, favoriteFood (là một mảng gồm các giá trị chuỗi).

const pet = {
    type: "dog",
    name: "alex",
    breed: "chihuahua",
    hairColor: "yellow",
    favoriteFood: ["sausage, bread"] 
};


// Bài 2: In ra cửa sổ console giá trị của một key bất kỳ trong object tạo ra từ bài 1.

console.log(pet.favoriteFood);


// Bài 3: Thêm vào object ở bài 1 key “yearOld” để bổ sung số tuổi cho con vật, sử dụng giá trị số. In ra cửa sổ console dữ liệu của object sau khi đã bổ sung key - value mới.

pet.yearOld = 5;
console.log(pet);


// Bài 4: Viết một hàm nhận tham số là một object giống object của bài 1. Từ các key và giá trị của
// object đó, hàm trả về một chuỗi có nội dung như sau: “Nhà tôi có một con mèo tên là Tom, nó thích ăn cá, bánh xèo, bít tết.”

function createString(object) {
    return `Nhà tôi có một con ${object.type} tên là ${object.name}, nó thích ăn ${object.favoriteFood}.`
}

console.log(createString(pet));


// Bài 5: Tạo một biến có giá trị là một mảng chứa 3 object giống bài 1. Thông tin về các con vật không được trùng nhau quá nhiều và tuổi của chúng phải khác nhau.

var petArray = [
    {
        type: "dog",
        name: "alex",
        breed: "chihuahua",
        hairColor: "yellow",
        favoriteFood: ["sausage, bread"],
        age: 2
    },
    {
        type: "cat",
        name: "arthur",
        breed: "Vietnamese cat",
        hairColor: "yellow",
        favoriteFood: ["sausage"],
        age: 4
    },
    {
        type: "bird",
        name: "rodri",
        breed: "pigeon",
        hairColor: "black",
        favoriteFood: ["bread"],
        age: 3
    }
];