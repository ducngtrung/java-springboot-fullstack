function Airplane(name) {
    this.name = name;
    this.isFlying = false;
}

const airplanePrototype = {
    takeOff() {
        this.isFlying = true
    },
    land() {
        this.isFlying = false
    }
}

Airplane.prototype = airplanePrototype;

boeing = new Airplane("boeing");
airbus = new Airplane("airbus");

console.log(boeing.isFlying);
boeing.takeOff();
console.log(boeing.isFlying);
boeing.land();
console.log(boeing.isFlying);