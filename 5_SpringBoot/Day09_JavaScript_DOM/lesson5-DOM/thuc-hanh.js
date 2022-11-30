// Bài 1: In ra cửa sổ console thẻ p đầu tiên trong thẻ div có class là “text-content”.
document.getElementsByClassName('text-content')[0].querySelector('p')


// Bài 2: In ra cửa sổ console thẻ p thứ hai trong thẻ div có class là “text-content”.
document.getElementsByClassName('text-content')[0].querySelectorAll('p')[1]


// Bài 3: In ra cửa sổ console các thẻ li có trong list. Đổi kết quả về dạng mảng và in ra cửa sổ console.
Array.from(document.querySelector('ul').querySelectorAll('li'))


// Bài 4: In ra cửa số console các thẻ p trong thẻ div có class là “text-content”. Đổi kết quả về dạng mảng và in ra cửa sổ console (sử dụng spread operator).
pTags = document.getElementsByClassName('text-content')[0].querySelectorAll('p')
pArray = [...pTags]
console.log(pArray)