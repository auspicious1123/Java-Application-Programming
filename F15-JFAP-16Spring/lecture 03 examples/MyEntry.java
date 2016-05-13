/**
 * A class that shows an example of a subclass.
 *
 * @author Jeffrey Eppinger
 */
public class MyEntry extends AddressBookEntry {
    int age;

    public void birthday() {
      age = age + 1;
    }

    void print() {
        super.print();
        System.out.println("Age     " + age);
        System.out.println();
    }

    public static void main(String[] args) {
      MyEntry jeff = new MyEntry();
      jeff.firstName = "Jeffrey";
      jeff.lastName  = "Eppinger";
      jeff.telephoneNumber = "412-268-7688";
      jeff.eMailAddress = "eppinger@cmu.edu";
      jeff.age = 54;

      jeff.print();
    }
}
