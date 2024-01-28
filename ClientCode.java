import java.io.*;
import java.net.*;

public class ClientCode {
    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket("127.0.0.1", 8765); // This will connect to Server

        new ListenServer(socket);
        new SendServer(socket);

    }
}