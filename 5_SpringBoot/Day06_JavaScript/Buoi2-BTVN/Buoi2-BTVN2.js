// Bài 2: 
// Viết function truyền vào 1 chuỗi. In ra chuỗi đảo ngược của chuỗi đó
// Ví dụ: reverseString(‘hello’) => olleh

function reverseString(s) {
    let newString = "";
    for (let i = s.length-1; i >= 0; --i) {
        newString += s[i];
    }
    return newString;
}

// Cách 2:
// function reverseString(s) {
//     return s.split("").reverse().join("");
// }

reverseString("hello");