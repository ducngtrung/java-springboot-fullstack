// Function as Constructor
function Animal(type, name) {
    this.name = name;
    this.type = type;
    this.talk = function() {
        console.log(`My name is ${this.name}`);
    }
}

// // Cách 2: Khai báo class
// class Animal {
//     constructor(type, name) {
//         this.name = name;
//         this.type = type;
//         this.talk = function () {
//             console.log(`My name is ${this.name}`);
//         };
//     }
// }

dog = new Animal("husky", "John");
dog.talk();


// Prototype
const samplePrototype = {
    name: "abc",
    greet() {
        console.log(`My name is ${this.name}`)
    }
}

sample_1 = Object.create(samplePrototype);
sample_1.greet();
sample_1.__proto__;

sample_1.greet = function() { // ghi đè phương thức trong prototype
    console.log("Not from prototype")
}
sample_1.greet();


function Computer(cpu, ram) {
    this.cpu = cpu;
    this.ram = ram;
}

function Laptop(cpu, ram) {
    this.cpu = cpu;
    this.ram = ram;
}

const pcPrototype = {
    talk() {
        console.log(`${this.cpu} and ${this.ram}`)
    },
    speak() {
        console.log(`Speaking from ${this.cpu}`)
    }
}

Computer.prototype.talk = pcPrototype.talk;
Laptop.prototype = pcPrototype;

acer = new Computer("i7", "16GB");
acer.talk();
dell = new Laptop("i5", "8GB");
dell.speak();