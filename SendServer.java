import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SendServer extends Thread {
    final PrintWriter serverOut;
    final Socket socket;
    ClientCode client;
    String encryptedText = "";
    HelperFunctions helper;

    public SendServer(Socket socket, ClientCode clientCode, HelperFunctions helper) throws IOException {
        this.socket = socket;
        this.client = clientCode;
        serverOut = new PrintWriter(socket.getOutputStream(), true); // we passed true for autoFlush
        this.helper = helper;
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
                    if (line.equalsIgnoreCase("exit")) {
                        serverOut.println("exit");
                        socket.close();
                        break;
                    }
                    String regex = "^To:(.*) Message:(.*) Key:([\\d]{1,64})";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(line);
                    String toUser = "", message = "", keyStr = "";
                    while (matcher.find()) {
                        toUser = matcher.group(1);
                        message = matcher.group(2);
                        keyStr = matcher.group(3);

                    }
                    String hexKey = helper.padKey(keyStr);
                    String hexMessage = helper.padMessage(message);

                    for (int i = 0; i < hexMessage.length(); i += 16) {
                        GenerateKeys generateKey = new GenerateKeys(hexKey, helper);
                        ComputeRound computeRound = new ComputeRound(hexMessage.substring(i, i + 16), generateKey,
                                helper,
                                generateKey.getRoundKeys());
                        String lastRound[] = computeRound.getLastRoundText();
                        Encryption encryption = new Encryption(lastRound, helper);
                        encryptedText += encryption.getEncryptedHexaText();
                    }

                    String MessageForServer = "To:" + toUser + " Message:" + encryptedText + " Key:" + keyStr;
                    serverOut.println(MessageForServer);
                    // } else {
                    // System.out.println("Client is already connected");
                    // break;
                    // }
                }
            } while (!"exit".equalsIgnoreCase(line));
            System.out.println("Im outside exit");
            serverOut.println("exit");
            socket.close(); // cleint ne apna socket close kiiya
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
