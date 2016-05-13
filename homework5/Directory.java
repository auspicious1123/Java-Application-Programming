
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author-Rui Wang rw1
 */
public class Directory {
    /**
     * map1 for andrewId and Student.
     */
    private Map<String, Student> andrewIdMap = new HashMap<String, Student>();
    /**
     * map2 for firstName and Student list.
     */
    private Map<String, List<Student>> firstNameMap = new HashMap<String, List<Student>>();
    /**
     * map3 for lastName and Student list.
     */
    private Map<String, List<Student>> lastNameMap = new HashMap<String, List<Student>>();

    /**
     * constructor.
     */
    public Directory() {
    }

    /**
     * @param s
     *            Student
     */
    public void addStudent(Student s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (andrewIdMap.containsKey(s.getAndrewId())) {
            throw new IllegalArgumentException();
        }
        // map1 add student s
        Student copy = new Student(s.getAndrewId());
        copy.setFirstName(s.getFirstName());
        copy.setLastName(s.getLastName());
        copy.setPhoneNumber(s.getPhoneNumber());
        andrewIdMap.put(copy.getAndrewId(), copy);
        // map2 add Student s, if firstName exist, add directly, else new one
        if (firstNameMap.containsKey(copy.getFirstName())) {
            List<Student> firstName = firstNameMap.get(copy.getFirstName());
            firstName.add(copy);
            firstNameMap.put(copy.getFirstName(), firstName);
        } else {
            List<Student> firstName = new ArrayList<Student>();
            firstName.add(copy);
            firstNameMap.put(copy.getFirstName(), firstName);
        }
        // map3 add Student s
        if (lastNameMap.containsKey(s.getLastName())) {
            List<Student> lastName = lastNameMap.get(copy.getLastName());
            lastName.add(copy);
            lastNameMap.put(copy.getLastName(), lastName);
        } else {
            List<Student> lastName = new ArrayList<Student>();
            lastName.add(copy);
            lastNameMap.put(copy.getLastName(), lastName);
        }
    }

    /**
     * @param andrewId
     *            andrew ID
     */
    public void deleteStudent(String andrewId) {
        if (andrewId == null) {
            throw new IllegalArgumentException();
        }
        if (!andrewIdMap.containsKey(andrewId)) {
            throw new IllegalArgumentException();
        } else {
            // map2: based on ID find the Student -> first name -> in List
            // delete student -> put back (key, List)
            Student s = andrewIdMap.get(andrewId);
            List<Student> firstName = firstNameMap.get(s.getFirstName());
            firstName.remove(s);
            if (firstName.isEmpty()) {
                firstNameMap.remove(s.getFirstName());
            } else {
                firstNameMap.put(s.getFirstName(), firstName);
            }
            // map3: based on ID find the Student -> last name -> in List delete
            // student -> put back (key, List)
            List<Student> lastName = lastNameMap.get(s.getLastName());
            lastName.remove(s);
            if (lastName.isEmpty()) {
                lastNameMap.remove(s.getLastName());
            } else {
                lastNameMap.put(s.getLastName(), lastName);
            }
            // map1: remove student
            andrewIdMap.remove(andrewId);
        }
    }

    /**
     * @param andrewId
     *            key word for map1
     * @return Student student object
     */
    public Student searchByAndrewId(String andrewId) {
        if (andrewId == null) {
            throw new IllegalArgumentException();
        }
        return andrewIdMap.get(andrewId);
    }

    /**
     * @param firstName
     *            of map2
     * @return list based on first name
     */
    public List<Student> searchByFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException();
        }
        List<Student> list = new ArrayList<Student>();
        // if search item is not exist, return zero length list
        if (firstNameMap.get(firstName) == null) {
            return list;
        } else {
            return copyList(firstNameMap.get(firstName));
        }
    }

    /**
     * @param lastName
     *            of map3
     * @return list based on last name
     */
    public List<Student> searchByLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException();
        }
        List<Student> list = new ArrayList<Student>();
        if (lastNameMap.get(lastName) == null) {
            return list;
        } else {
            return copyList(lastNameMap.get(lastName));
        }
    }

    /**
     * @param list student list
     * @return List
     */
    public List<Student> copyList(List<Student> list) {
        List<Student> newList = new ArrayList<Student>();
        for (Student s : list) {
            Student copy = new Student(s.getAndrewId());
            copy.setFirstName(s.getFirstName());
            copy.setLastName(s.getLastName());
            copy.setPhoneNumber(s.getPhoneNumber());
            newList.add(copy);
        }
        return newList;
    }

    /**
     * @return size of Directory
     */
    public int size() {
        return andrewIdMap.size();
    }
}
