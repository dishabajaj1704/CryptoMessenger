import java.io.*;
import java.net.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.xml.namespace.QName;

public class ClientCode {
    // AtomicBoolean flag = new AtomicBoolean(false);
    private boolean sendToServerFlag = false;
    final static ClientCode clientCode = new ClientCode();

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket("127.0.0.1", 8765); // This will connect to Server

        new ListenServer(socket, clientCode);
        new SendServer(socket, clientCode);

    }

    // public void setSendToServerFlag(boolean value) {
    //     this.sendToServerFlag = value;
    // }

    // public boolean getSendToServerFlag() {
    //     return sendToServerFlag;
    // }

}