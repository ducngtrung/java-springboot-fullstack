// Bài 4: 
// Cho function truyền vào 1 chuỗi dài hơn 15 ký tự. Viết 1 function cắt chuỗi, lấy ra 10 ký tự đầu tiên và thêm vào dấu “…” ở cuối chuỗi.
// Ví dụ: subString(“xinchaocacbandenvoiTechmaster”) => “xinchaocac…”

function cutString(s) {
    return s.substring(0, 10) + "...";
}

cutString("xinchaocacbandenvoiTechmaster");