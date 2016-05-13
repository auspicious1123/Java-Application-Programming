/**
 * Example code for lecture 13 (Functional Programming).
 * @author Jeffrey Eppinger & Terry Lee
 */
public class ObservablyImmutable {

    /**
     * hashCode value of a string object set when hachCode() method is called
     * not when it is instantiated.
     * @param args arguments
     */
    public static void main(String[] args) {
        String name = "Donald Trump";
        System.out.println(name);
        System.out.println(name.hashCode());
        System.out.println(name);
    }

}
