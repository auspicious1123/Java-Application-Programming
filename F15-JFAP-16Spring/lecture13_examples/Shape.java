/**
 * Example code for lecture 13 (Functional Programming).
 * @author Jeffrey Eppinger & Terry Lee
 */
public class Shape {
    /**
     * area variable.
     */
    private double area;

    /**
     * Constructor with a area.
     * @param newArea a area value
     */
    public Shape(double newArea) {
        area = newArea;
    }

    /**
     * Returns area of shape.
     * @return double value of area
     */
    public double getArea() {
        return area;
    }

    /**
     * Returns String representation of Shape object.
     * @return String representation
     */
    @Override
    public String toString() {
        return "Shape(area=" + area + ")";
    }
}
