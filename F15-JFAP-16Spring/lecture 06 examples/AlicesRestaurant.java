/**
 * Example code for lecture 6.
 * Can you sing?
 * https://en.wikipedia.org/wiki/Alice%27s_Restaurant
 * Watch it at www.youtube.com/watch?v=m57gzA2JCcM
 * @author Jeffrey Eppinger & Terry Lee
 */
public class AlicesRestaurant {
    /**
     * Refrain of the song.
     * This method makes it easier to write the code
     */
    public static void refrain() {
        System.out.println();
        System.out.println("You can get anything you want ...");
        System.out.println("You can get anything you want ...");
        System.out.println("Walk right in it's around the ...");
        System.out.println("Just a half a mile from the ra...");
        System.out.println("You can get anything you want ...");
        System.out.println();
    }

    /**
     * Print the song.
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println("This song is called Alice's Re...");
        refrain();
        System.out.println("Now it all started about two T...");
        refrain();
        refrain();
        // ...
    }
}
