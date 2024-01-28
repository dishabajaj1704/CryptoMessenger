import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendServer extends Thread {
    final PrintWriter serverOut;
    final Socket socket;

    public SendServer(Socket socket) throws IOException {
        this.socket = socket;
        serverOut = new PrintWriter(socket.getOutputStream(), true); // we passed true for autoFlush
        this.start();
    }

    public void run() {
        String line;
        String userName = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            do {
                if (userName.equals("")) {
                    System.out.println("Enter a userName");
                    line = br.readLine();
                    userName = line;
                    serverOut.println(line);
                    // response = serverIn.readLine(); //causing error as serverIn was share between
                    // 2 threads
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
}
