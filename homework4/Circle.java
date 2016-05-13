/**
 * @author-Rui Wang rw1
 */
public class Circle extends Shape {
    /**
     * radius of a circle.
     */
    private double radius;
    /**
     * @param newRadius radius for a new circle
     */
    public Circle(double newRadius) {
        //super(Math.PI * newRadius * newRadius, 2 * Math.PI * newRadius);
        radius = newRadius;
    }
    /**
     * Returns radius of a circle.
     *
     * @return radius value of a circle
     */
    public double getRadius() {
        return radius;
    }
    /**
     * @see Shape#getArea()
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    /**
     * @see Shape#getPerimeter()
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    /**
     * Returns string representation of circle object.
     * @return a string representation of circle object
     */
    @Override
    public String toString() {
        return "Circle " + String.format("%.3f", getArea()) + " " + String.format("%.3f", getPerimeter());
    }
}
