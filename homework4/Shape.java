/**
 * @author-Rui Wang rw1
 */
public abstract class Shape {
    /**
     * area of Shape.
     */
    private double area;
    /**
     * perimeter of Shape.
     */
    private double perimeter;
    /**
     * condtructor.
     */
    public Shape() { }
//    /**
//     * @param newArea new Area of shape
//     * @param newPerimeter new perimeter of Shape
//     */
//    public Shape(double newArea, double newPerimeter) {
//        area = newArea;
//        perimeter = newPerimeter;
//    }
    /**
     * abstract method getArea.
     * @return a string representation of shape object
     */
    public abstract double getArea();
    /**
     * abstract method getPerimeter.
     * @return a string representation of shape object
     */
    public abstract double getPerimeter();
    /**
     * Returns string representation of shape object.
     * @return a string representation of shape object
     */
    public String toString() {
        return "Shape " + String.format("%.3f", area) + " " + String.format("%.3f", perimeter);
    }
}

