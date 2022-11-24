function calculateBMI() {
    var BMI = weight / (height**2);
    console.log(BMI);
}

var height = 1.73;
var weight = 69;

const buttons = document.querySelectorAll('button');

for (const button of buttons) {
    button.addEventListener('click', calculateBMI);
}