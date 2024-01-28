import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Echoer extends Thread {
    private Socket clientSocket;
    ChatsList chatsList = new ChatsList();
    HashMap<String, Socket> clientSocketsList;
    String userName = "";

    public Echoer(Socket clientSocket, HashMap<String, Socket> clientSocketsList) {
        this.clientSocket = clientSocket;
        this.clientSocketsList = clientSocketsList;
        this.start();
    }

    public void run() {
        try {
            BufferedReader clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // client jo input dega
            PrintWriter clientOut = new PrintWriter(clientSocket.getOutputStream(), true);

            String line;

            do {
                if (userName.equals("")) {
                    line = clientIn.readLine();
                    this.userName = line;
                    System.out.println(line);

                    if (!this.clientSocketsList.containsKey(this.userName)) {
                        clientSocketsList.put(this.userName, this.clientSocket); // This condition is used to check
                                                                                 // whether user is existing or visiting
                                                                                 // for the first time
                        clientOut.println("Connected");
                    } else {
                        if (clientSocketsList.get(this.userName) == null) {
                            clientSocketsList.put(this.userName, this.clientSocket);
                            clientOut.println("Connected");
                        } else {
                            clientOut.println("Existing Connection");
                            clientSocket.close();
                            break;

                        }
                    }
                } else {
                    line = clientIn.readLine();
                    System.out.println("Line:- " + line);
                    String regex = "^To:(.*) Message:(.*)";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(line);
                    String toUser = "";
                    String fromUser = "";
                    String message = "";
                    while (matcher.find()) {
                        toUser = matcher.group(1);
                        System.out.println("to User:- " + toUser);
                        message = matcher.group(2);
                        // fromUser = matcher.group(3);
                        fromUser = userName;
                    }
                    if (clientSocketsList.containsKey(toUser)) {
                        System.out.println(clientSocketsList);
                        Socket toUserClientSocket = clientSocketsList.get(toUser);
                        if (toUserClientSocket != null) {
                            BufferedReader toUserIn = new BufferedReader(
                                    new InputStreamReader(toUserClientSocket.getInputStream()));
                            // client jo input dega
                            PrintWriter toUserOut = new PrintWriter(toUserClientSocket.getOutputStream(), true);
                            toUserOut.println("From:- " + fromUser + " Message:- " + message);
                            chatsList.addChat(new Chat(fromUser, toUser, message));
                            clientOut.println("Message Delivered");
                        } else {
                            clientOut.println("Client is Offline");
                            // break;
                        }
                    } else {
                        if (line.equals("exit")) {
                            clientSocketsList.put(this.userName, null);
                            break;
                        } else {
                            clientOut.println("Client Doesn't exist");
                        }
                        // break;
                    }

                    System.out.println(line); // we are printing

                }
            } while (!"exit".equalsIgnoreCase(line));

            System.out.println("Client Closed!");
            clientSocket.close();
        } catch (Exception e) {
            // e.printStackTrace();
            clientSocketsList.put(this.userName, null);
        }
    }
}