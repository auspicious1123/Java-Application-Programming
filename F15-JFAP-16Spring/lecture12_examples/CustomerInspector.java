import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Example code for Reflection (Class class).
 * @author Terry Lee
 */
public class CustomerInspector {

    /**
     * Program to inspect customer class at runtime.
     * @param args arguments
     */
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("Customer");
            
            Field[] fields = c.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                System.out.println(fields[i].toString());
            }
            System.out.println();
            
            Method[] methods = c.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                System.out.println(methods[i].toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
