let a = 1;
let b = 22;
let name = "John";

// alert(b + a);
// alert(c);
// alert(a + name);
// alert(a + name + b);
// alert(a + b + name);
// alert(name + a);
// alert(name + a + b);
// alert(name + (a + b));
// alert(`Hello ${name}`);
// alert(`${name} + 1`);
// alert(`${name + 1}`);
// alert(`${name + a}`);
// alert(`a + b = ${a + b}`);
// alert(`a + b = ${1 + 2}`);
// alert(`1 + 2 = ${1 + 2}`);
// alert(`1 + 2 = ${a + b}`);

function show_alert(a, b, name) {
    alert(a + name + b);
}

const buttons = document.querySelectorAll('button');
      
for (const button of buttons) {
    button.addEventListener('click', show_alert(a, b, name));
}