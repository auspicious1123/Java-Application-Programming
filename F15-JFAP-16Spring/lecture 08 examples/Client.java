import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Example code for lecture 8.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class Client {
    /**
     * Simple client for network example.
     * @param args arguments IP address
     * @throws IOException IOException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket sock = new Socket(args[0], 7777);
        OutputStream os = sock.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(args[1]);
        oos.flush();

        InputStream is = sock.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        Object obj = ois.readObject();
        System.out.println("Received from " + sock.getInetAddress() + ": " + obj);

        sock.close();
    }
}
