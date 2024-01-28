import java.io.*;
import java.net.*;

public class ClientCode {
    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket("127.0.0.1", 8765); // This will connect to Server
        final BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), true); // we passed true for autoFlush

        new Thread(new Runnable() {
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
        }).start();

        new Thread(new Runnable() {
            public void run() {
                String line;
                String response = "";
                String userName = "";
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                try {
                    do {
                        if (userName.equals("")) {
                            System.out.println("Enter a userName");
                            line = br.readLine();
                            userName = line;
                            serverOut.println(line);
                            // response = serverIn.readLine();
                            // System.out.println("UserName:- " + response);
                            if (userName.equals("exit")) {
                                break;
                            }
                        } else {
                            System.out.println("Enter the Message");
                            line = br.readLine();
                            // line += " From:" + userName;
                            serverOut.println(line);
                        }
                    } while (!"exit".equalsIgnoreCase(line));
                    serverOut.println("exit");
                    socket.close(); // cleint ne apna socket close kiiya
                } catch (Exception e) {

                }
            }

        }).start();

    }
}