

/**
 * @author-Rui Wang rw1
 */
public class ShapeSortTest {
    /**
     * @param args the args
     */
    public static void main(String[] args) {
        Shape[] shapeArray = new Shape[args.length];
        for (int i = 0; i < shapeArray.length; i++) {
            int lastIndex = args[i].length();
            Shape shape = null;
            switch (args[i].charAt(0)) {
            case 'C':
                shape = new Circle(Integer.parseInt(args[i].substring(1, lastIndex)));
                break;
            case 'S':
                shape = new Square(Integer.parseInt(args[i].substring(1, lastIndex)));
                break;
            case 'H':
                shape = new Hexagon(Integer.parseInt(args[i].substring(1, lastIndex)));
                break;
            case 'O':
                shape = new Octagon(Integer.parseInt(args[i].substring(1, lastIndex)));
                break;
            default:
                break;
            }
            shapeArray[i] = shape;
        }

        for (int i = 0; i < shapeArray.length - 1; i++) {
            for (int j = i + 1; j < shapeArray.length; j++) {
                if (shapeArray[i].getArea() > shapeArray[j].getArea()) {
                    Shape temp = shapeArray[i];
                    shapeArray[i] = shapeArray[j];
                    shapeArray[j] = temp;
                }
            }
        }
        for (int i = 0; i < shapeArray.length; i++) {
            System.out.println(shapeArray[i]);
        }
        System.out.println();
        for (int i = 0; i < shapeArray.length - 1; i++) {
            for (int j = i + 1; j < shapeArray.length; j++) {
                if (shapeArray[i].getPerimeter() < shapeArray[j].getPerimeter()) {
                    Shape temp = shapeArray[i];
                    shapeArray[i] = shapeArray[j];
                    shapeArray[j] = temp;
                }
            }
        }
        for (int i = 0; i < shapeArray.length; i++) {
            System.out.println(shapeArray[i]);
        }
    }
}
