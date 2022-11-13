package Day09_Interface;

import Day09_Interface.LOL.Lucian;
import Day09_Interface.LOL.Yasuo;
import Day09_Interface.Polygon.Rectangle;
import Day09_Interface.Polygon.Square;

public class Main9 {
    public static void main(String[] args) {
        Yasuo yasuo = new Yasuo();
        yasuo.setHair("long");
        yasuo.setWeapon("sword");
        yasuo.display();
        yasuo.surf();

        Lucian lucian = new Lucian();
        lucian.setHair("short");
        lucian.setWeapon("pistol");
        lucian.display();
        lucian.surf();
        lucian.shoot();
        lucian.checkDefault();

        Rectangle rectangle = new Rectangle(12.5, 9.8);
        rectangle.display();
        rectangle.calArea();
        Square square = new Square(4.5);
        square.display();
        square.calArea();
    }
}