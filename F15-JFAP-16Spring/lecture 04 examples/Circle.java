/**
 * Example class to represent a circle shape.
 *
 * @author Jeffrey Eppinger & Terry Lee
 *
 */
public class Circle extends Shape {
    /**
     * radius of a circle.
     */
    private double radius;

    /**
     * Constructor with radius.
     *
     * @param newRadius
     *            radius for a new circle
     */
    public Circle(double newRadius) {
        super(Math.PI * newRadius * newRadius);
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
     * Returns string representation of circle object.
     * @return a string representation of circle object
     */
    public String toString() {
        return "Circle(radius=" + radius + ")";
    }
}
