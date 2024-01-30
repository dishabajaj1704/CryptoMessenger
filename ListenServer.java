import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ListenServer extends Thread {
    final BufferedReader serverIn;
    ClientCode client;

    public ListenServer(Socket socket) throws IOException {
        serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.client = new ClientCode();
        this.start();
    }

    public void run() {
        System.out.println("Inside Listen Run");
        try {
            String response = "";
            // System.out.println("response:- " + response);
            while ((response = serverIn.readLine()) != null) {
                // response = serverIn.readLine(); // ispe hold pe chala jayega

                if (response.equals("Existing Connection")) {
                    System.out.println("In hereeee existing connection");
                    // this.sendToServer = false; (race condition)

                } else {
                    System.out.println("In hereeee client");
                    System.out.println(response);

                    // this.sendToServer = true; //(race condition)

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
