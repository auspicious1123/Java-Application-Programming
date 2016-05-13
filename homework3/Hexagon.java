

/**
 * @author-Rui Wang rw1
 */
public class Hexagon extends Shape {
    /**
     * side for hexagon.
     */
    private double side;
    /**
     * final value for equation.
     */
    static final double TIMES = 1.5;
    /**
     * final value for equation.
     */
    static final double SQRT = 3;
    /**
     * final value for equation.
     */
    static final int SIDENUM = 6;
    /**
     * @param newSide side of hexagon
     */
    public Hexagon(double newSide) {
        super(TIMES * Math.sqrt(SQRT) * newSide * newSide, SIDENUM * newSide);   // super is eara
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
        return "Hexagon " + String.format("%.3f", getArea()) + " " + String.format("%.3f", getPerimeter());
    }

}
