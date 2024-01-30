import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClientCode {
    // AtomicBoolean flag = new AtomicBoolean(false);

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket("127.0.0.1", 8765); // This will connect to Server

        new ListenServer(socket);
        new SendServer(socket);

    }
}