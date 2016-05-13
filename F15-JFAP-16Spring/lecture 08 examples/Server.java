import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Example code for lecture 8.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class Server {
    /**
     * Simple program to act as server to accept Object and Write it back.
     * @param args arguments
     * @throws IOException throws IOException
     * @throws ClassNotFoundException throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket ss = new ServerSocket(7777);
        Socket sock = ss.accept();
        System.out.println("Connection from " + sock.getInetAddress());

        InputStream is = sock.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        Object obj = ois.readObject();
        System.out.println("   Received: " + obj);

        OutputStream os = sock.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject("Thank you: " + sock.getInetAddress());

        oos.close();
        ois.close();
        sock.close();
        ss.close();
    }
}
