import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Example code for lecture 13 (Functional Programming).
 * @author Jeffrey Eppinger & Terry Lee
 */
public final class ImmutablePerson {

    /**
     * first name of Person.
     */
    private final String firstName;
    /**
     * last name of Person.
     */
    private final String lastName;
    /**
     * list of friends of person.
     */
    private final List<String> listOfFriends;

    /**
     * Constructor with first, last names and list of friends.
     * @param first first name
     * @param last last name
     * @param friends list of friends
     */
    public ImmutablePerson(String first, String last, List<String> friends) {
        firstName = first;
        lastName = last;
        // Creates a new list.
        listOfFriends = new ArrayList<>(friends);
    }

    /**
     * Returns first name of person.
     * @return first name value
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns last name of person.
     * @return last name value
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns unmodifiable list of friends.
     * @return unmodifiable list of friends
     */
    public List<String> getListOfFriends() {
        return Collections.unmodifiableList(listOfFriends);
    }

    /**
     * Returns string representation of person.
     * @return string representation
     */
    @Override
    public String toString() {
        return "Person (" + firstName + " " + lastName + ") has " + listOfFriends.size() + " friends";
    }

}
