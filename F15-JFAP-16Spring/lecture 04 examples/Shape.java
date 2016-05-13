/**
 * The super class for all shapes.
 *
 * @author Jeffrey Eppinger & Terry Lee
 */
public class Shape {
    /**
     * area of Shape.
     */
    private double area;

    /**
     * Constructor with new area.
     * @param newArea new Area of shape
     */
    public Shape(double newArea) {
        area = newArea;
    }

    /**
     * Returns area of shape object.
     * @return area value of shape object
     */
    public double getArea() {
        return area;
    }

    /**
     * Returns string representation of shape object.
     * @return a string representation of shape object
     */
    public String toString() {
        return "Shape(area=" + area + ")";
    }
}
