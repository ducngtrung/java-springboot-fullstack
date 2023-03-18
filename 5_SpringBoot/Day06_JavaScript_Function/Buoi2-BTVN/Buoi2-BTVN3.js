// Bài 3: 
// Viết function truyền vào mã quốc gia. Trả về message có ý nghĩa là “Xin chào”, tương ứng với mã quốc gia được truyền vào.
// Ví dụ: translate(‘VN’) => “Xin chào”
//        translate(‘EN’) => “Hello”
// Gợi ý: Sử dụng switch-case. Học viên tự nghĩ ra 1 vài mã quốc gia và câu chào tương ứng.

function translate(countryCode) {
    switch (countryCode.toUpperCase()) {
        case "VN":
            console.log("Xin chào");
            break;
        case "EN":
            console.log("Hello");
            break;
        case "FR":
            console.log("Bonjour");
            break;
        case "ES":
            console.log("Hola");
            break;
        case "KR":
            console.log("Annyeonghaseyo");
            break;
        case "JP":
            console.log("Kon'nichiwa");
            break;
        case "CN":
            console.log("Nǐ hǎo");
            break;
        default:
            console.log("NOT FOUND");
    }
}

translate("jp");