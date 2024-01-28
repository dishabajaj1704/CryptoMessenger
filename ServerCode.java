import java.net.*;
import java.util.HashMap;
import java.io.*;

public class ServerCode {
    public static void main(String args[]) throws IOException {
        ServerSocket s = new ServerSocket(8765);
        HashMap<String, Socket> clientSockets = new HashMap<>();
        while (true) {
            new Echoer(s.accept(), clientSockets);
        }
    }
}