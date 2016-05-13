/**
 * Example enumeration of days of the week
 * @author Jeff Eppinger & Terry Lee
 */
public enum DayOfWeek {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;
    
    /**
     * Returns a String representation of the day of the week.
     * @return String representation of dow
     */
    @Override
    public String toString() {
        switch (this) {
        case SUNDAY:
        case SATURDAY:
            return "Weekend :-)";
        default:
            return "Weekday :-(";
        }
    }
}
