

/**
 * @author-Rui Wang rw1
 */
public class Shape {
    /**
     * area of Shape.
     */
    private double area;
    /**
     * perimeter of Shape.
     */
    private double perimeter;
    /**
     * @param newArea new Area of shape
     * @param newPerimeter new perimeter of Shape
     */
    public Shape(double newArea, double newPerimeter) {
        area = newArea;
        perimeter = newPerimeter;
    }
    /**
     * Returns area of shape object.
     * @return area value of shape object
     */
    public double getArea() {
        return area;
    }
    /**
     * Returns area of shape object.
     * @return area value of shape object
     */
    public double getPerimeter() {
        return perimeter;
    }
    /**
     * Returns string representation of shape object.
     * @return a string representation of shape object
     */
    public String toString() {
        return "Shape " + String.format("%.3f", area) + " " + String.format("%.3f", perimeter);
    }
}

