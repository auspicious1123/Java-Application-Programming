/**
 * Example code for lecture 13 (Functional Programming).
 * @author Jeffrey Eppinger & Terry Lee
 */
public class Circle extends Shape {
    /**
     * Radius instance variable.
     */
    private double radius;

    /**
     * Constructor with a radius value.
     * @param newRadius radius of circle
     */
    public Circle(double newRadius) {
        super(Math.PI * newRadius * newRadius);
        radius = newRadius;
    }

    /**
     * Returns radius value of circle object.
     * @return double value or radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Returns a string representation of Circle object.
     * @return String representation of Circle object
     */
    @Override
    public String toString() {
        return "Circle(radius=" + radius + ")";
    }
}
