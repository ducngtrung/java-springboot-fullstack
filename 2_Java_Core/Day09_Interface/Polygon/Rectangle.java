package Day09_Interface.Polygon;

public class Rectangle implements Polygon {
    private double length;
    private double width;

    // Getter and Setter
    public double getLength() {
        return this.length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getWidth() {
        return this.width;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void display() {
        System.out.println("\nRectangle with " + width + " width and " + length + " length");        
    }

    @Override
    public void calArea() {
        System.out.println("\tArea: " + length*width);        
    }
}