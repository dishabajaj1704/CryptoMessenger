import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendServer extends Thread {
    final PrintWriter serverOut;
    final Socket socket;
    ClientCode client;

    public SendServer(Socket socket, ClientCode clientCode) throws IOException {
        this.socket = socket;
        this.client = clientCode;
        serverOut = new PrintWriter(socket.getOutputStream(), true); // we passed true for autoFlush
        this.start();
    }

    public void run() {
        System.out.println("Inside send run");
        String line;
        String userName = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            do {
                // System.out.println("DOODODO");
                // System.out.println("Send DO FLAg:- " + listener.sendToServer);
                if (userName.equals("")) {
                    System.out.println("Enter a userName");
                    line = br.readLine();
                    userName = line;
                    serverOut.println(line);
                    // response = serverIn.readLine(); //causing error as serverIn was share between
                    // 2 threads
                    if (userName.equals("exit")) {
                        break;
                    }
                } else {
                    // if (client.getSendToServerFlag()) {
                        System.out.println("Enter the Message");
                        line = br.readLine();
                        
                        serverOut.println(line);
                    // } else {
                    //     System.out.println("Client is already connected");
                    //     break;
                    // }
                }
            } while (!"exit".equalsIgnoreCase(line));
            System.out.println("Im outside exit");
            serverOut.println("exit");
            socket.close(); // cleint ne apna socket close kiiya
        }catch(

    Exception e)
    {
        System.out.println(e);
    }
}}
