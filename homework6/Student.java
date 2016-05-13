
/**
 * @author-Rui Wang rw1
 */
public class Student {
    /**
     * first name.
     */
    private String firstName;
    /**
     * last name.
     */
    private String lastName;
    /**
     * Andrew ID.
     */
    private String andrewId;
    /**
     * phone number.
     */
    private String phoneNumber;
    /**
     * @param andrewId andrew Id
     */
    public Student(String andrewId) {
        super();
        this.andrewId = andrewId;
    }

    /**
     * @param firstName first name of student
     * @param lastName last name of student
     * @param andrewId andrew id of student
     * @param phoneNumber phone number of student
     */
    public Student(String firstName, String lastName, String andrewId, String phoneNumber) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.andrewId = andrewId;
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * @return the andrewID
     */
    public String getAndrewId() {
        return andrewId;
    }
    /**
     * @param andrewId for andrew ID
     */
    public void setAndrewId(String andrewId) {
        this.andrewId = andrewId;
    }
    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * @return student information
     */
    public String toString() {
         return getFirstName() + " " + getLastName() + " " + "(Andrew ID: " + getAndrewId()
         +  ", Phone Number: " + getPhoneNumber() + ")";
    }
}
