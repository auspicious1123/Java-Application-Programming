import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example code for lecture 13 (Functional Programming).
 * @author Jeffrey Eppinger & Terry Lee
 */
public class PersonTestFP2 {

    /**
     * Simple program to demo lambda expressions and examples of default methods.
     * @param args arguments
     */
    public static void main(String[] args) {
        List<ImmutablePerson> list = buildPersonList();

        System.out.println("Before sort");
        list.forEach(e -> System.out.println(e));

        list.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
        System.out.println("\nAfter sort by last name");
        list.forEach(e -> System.out.println(e));

        list.sort((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
        System.out.println("\nAfter sort by first name");
        list.forEach(e -> System.out.println(e));

        list.sort((p1, p2) -> Integer.compare(p2.getListOfFriends().size(), p1.getListOfFriends().size()));
        System.out.println("\nAfter sort by number of friends");
        list.forEach(e -> System.out.println(e));
    }

    /**
     * Builds a person list.
     * @return list of person objects
     */
    private static List<ImmutablePerson> buildPersonList() {
        List<ImmutablePerson> list = new ArrayList<>();
        List<String> gbFriends = Arrays.asList("Jeb Bush", "John Wang");
        List<String> boFriends = Arrays.asList("Michell Obama", "Joe Biden", "Michael Jordan");
        List<String> bcFriends = Arrays.asList("Hillary Clinton");
        List<String> jbFriends = Arrays.asList("George Bush");
        List<String> hcFriends = Arrays.asList("Patty", "Amber", "Dabney");
        list.add(new ImmutablePerson("George", "Bush", gbFriends));
        list.add(new ImmutablePerson("Barack", "Obama", boFriends));
        list.add(new ImmutablePerson("Bill", "Clinton", bcFriends));
        list.add(new ImmutablePerson("Jeb", "Bush", jbFriends));
        list.add(new ImmutablePerson("Hillary", "Clinton", hcFriends));
        return list;
    }

}
