

/**
 * @author-Rui Wang rw1
 */
public class Rectangle extends Shape {
    /**
     * width of a Rectangle.
     */
    private double width;
    /**
     * height of a Rectangle.
     */
    private double height;
    /**
     * Constructor with new width and new height.
     * @param newWidth new width of Rectangle
     * @param newHeight new height of Rectangle
     */
    public Rectangle(double newWidth, double newHeight) {
        super(newWidth * newHeight, 2 * (newWidth + newHeight));
        width = newWidth;
        height = newHeight;
    }
    /**
     * Returns width of a rectangle object.
     * @return width value of rectangle object
     */
    public double getWidth() {
        return width;
    }
    /**
     * Returns height of a rectangle object.
     * @return height value of rectangle object
     */
    public double getHeight() {
        return height;
    }
    /**
     * Returns string representation of Rectangle object.
     * @return a string representation of rectangle object
     */
    @Override
    public String toString() {
        return "Rectangle " + String.format("%.3f", getArea()) + " " + String.format("%.3f", getPerimeter());
    }
}
