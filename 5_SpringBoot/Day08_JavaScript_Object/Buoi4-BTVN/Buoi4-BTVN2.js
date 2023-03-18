// Tạo 1 constructor tên Person khi khởi tạo có name và age được truyền vào và một property tên stomach là array.
// Các instances của Person khi khởi tạo sẽ có 1 stomach là array rỗng (Chiếc bụng đói)
// Xử lý để các instances của Person có các method sau:
//     method .eat("something") , khi người ăn một cái gì đó, loại thức ăn đó sẽ được đẩy vào array stomach (Đẩy thức ăn vào bụng), method eat này không nhận quá 10 thức ăn vào bụng.
//     method .poop(), khi người thực hiện poops thì array stomach sẽ empty (Đào thải tất cả)
//     method .introduceMyself trả ra string giới thiệu về bản thân theo format sau: This is David, 50 years old

function Person(name, age) {
    this.name = name;
    this.age = age;
    this.stomach = [];
    this.eat = function(something) {
        if (this.stomach.length >= 10) {
            return;
        }
        this.stomach.push(something);
    }
    this.poop = function() {
        this.stomach.length = 0;
    }
    this.introduceMyself = function() {
        console.log(`This is ${this.name}, ${this.age} years old.`);
    }
}

david = new Person("David", 50);

david.eat("chicken");
david.eat("pizza");
david.eat("hamburger");
david.eat("bbq");
david.eat("yogurt");
david.eat("milk");
david.eat("apple");
david.eat("banana");
david.eat("lamb");
david.eat("pork");
david.eat("beef");
console.log(david); // to test whether "beef" is pushed to the stomach array when the array length has reached 10

david.poop();
console.log(david);

david.introduceMyself();