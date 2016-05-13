/**
 * Example class to represent a square shape.
 *
 * @author Jeffrey Eppinger & Terry Lee
 *
 */
public class Square extends Rectangle {
    /**
     * Side value of square.
     */
    private double side;

    /**
     * Constructor with new side.
     * @param newSide new side value of square
     */
    public Square(double newSide) {
        super(newSide, newSide);
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
        return "Square(side=" + side + ")";
    }
}
