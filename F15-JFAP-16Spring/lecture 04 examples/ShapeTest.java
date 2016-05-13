/**
 * Shape test class.
 *
 * @author Jeffrey Eppinger & Terry Lee
 */
public class ShapeTest {
    /**
     * Main method to test different shape objects.
     * @param args arguments
     */
    public static void main(String[] args) {
        Circle c = new Circle(3);
        System.out.println(c + " area=" + c.getArea());

        Rectangle r = new Rectangle(5, 3);
        System.out.println(r + " area=" + r.getArea());

        Shape s = new Square(3);
        System.out.println(s + " area=" + s.getArea());

        Shape s1 = c;
        Shape s2 = r;
        System.out.println(s1);
        System.out.println(s2);
    }
}
