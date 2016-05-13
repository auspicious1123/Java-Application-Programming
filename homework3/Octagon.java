

/**
 * @author-Rui Wang rw1
 */
public class Octagon extends Shape {
    /**
     * side for octagon.
     */
    private double side;
    /**
     * immutable value.
     */
    static final int SIDENUMBER = 8;
    /**
     * @param newSide side of octagon
     */
    public Octagon(double newSide) {
        // TODO Auto-generated constructor stub
        super((2 + 2 * Math.sqrt(2)) * newSide * newSide, SIDENUMBER * newSide);
        side = newSide;
    }
    /**
     * Returns side of square object.
     * @return side value of square object
     */
    public double getSide() {
        return side;
    }
    /**
     * Returns string representation of shape object.
     * @return a string representation of shape object
     */
    public String toString() {
        return "Octagon " + String.format("%.3f", getArea()) + " " + String.format("%.3f", getPerimeter());
    }

}
