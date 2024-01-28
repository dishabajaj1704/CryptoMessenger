import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ListenServer extends Thread {
    final BufferedReader serverIn;

    public ListenServer(Socket socket) throws IOException {
        serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.start();
    }

    public void run() {
        // System.out.println("Inside Run");
        try {
            String response = "";
            // System.out.println("response:- " + response);
            while ((response = serverIn.readLine()) != null) {
                // response = serverIn.readLine(); // ispe hold pe chala jayega
                System.out.println(response);
                if (response.equals("Existing Connection")) {

                }
            }
        } catch (Exception e) {

        }

    }
}
