package Day09_Interface.Polygon;

public class Square implements Polygon {
    private double side;

    // Getter and Setter
    public double getSide() {
        return this.side;
    }
    public void setSide(double side) {
        this.side = side;
    }

    // Constructor
    public Square(double side) {
        this.side = side;
    }

    @Override
    public void display() {
        System.out.println("\nSquare with " + side + " side");        
    }

    @Override
    public void calArea() {
        System.out.println("\tArea: " + side*side);        
    }
}