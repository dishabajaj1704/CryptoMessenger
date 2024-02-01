import java.io.*;
import java.net.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClientCode {
    // AtomicBoolean flag = new AtomicBoolean(false);
    private boolean sendToServerFlag = false;
    final static ClientCode clientCode = new ClientCode();
    static HelperFunctions helper = new HelperFunctions();

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket("127.0.0.1", 8765); // This will connect to Server

        new ListenServer(socket, clientCode, helper);
        new SendServer(socket, clientCode, helper);

    }

    // public void setSendToServerFlag(boolean value) {
    // this.sendToServerFlag = value;
    // }

    // public boolean getSendToServerFlag() {
    // return sendToServerFlag;
    // }

}