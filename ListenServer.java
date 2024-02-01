import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListenServer extends Thread {
    final BufferedReader serverIn;
    ClientCode client;
    GenerateKeys generateKey;
    HelperFunctions helper;
    Socket socket;

    public ListenServer(Socket socket, ClientCode clientCode, HelperFunctions helper) throws IOException {
        this.socket = socket;
        serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.client = clientCode;
        this.helper = helper;
        this.start();
    }

    public void run() {
        try {
            String response = "";
            // System.out.println("response:- " + response);
            while ((response = serverIn.readLine()) != null) {
                // response = serverIn.readLine(); // ispe hold pe chala jayega

                if (response.equals("Existing Connection")) {

                    System.out.println(response);
                    // System.out.println("In hereeee existing connection");
                    // this.sendToServer = false; (race condition)
                    // client.setSendToServerFlag(true);
                    // Countdown the latch

                } else if (response.equalsIgnoreCase("exit")) {
                    System.out.println("Response:- " + response);
                    socket.close();
                    break;
                } else {
                    if (response.contains("From")) {
                        String decryptedText = "";
                        String regex = "^From:(.*) Message:(.*) Key:([\\d]{1,64})";
                        Pattern pattern = Pattern.compile(regex);
                        Matcher matcher = pattern.matcher(response);
                        String fromUser = "", message = "", keyStr = "";
                        while (matcher.find()) {
                            fromUser = matcher.group(1);
                            message = matcher.group(2);
                            keyStr = matcher.group(3);
                        }
                        String hexKey = helper.padKey(keyStr);
                        String decryptedHexaText = "";
                        for (int i = 0; i < message.length(); i += 16) {
                            GenerateKeys generateKey = new GenerateKeys(hexKey, helper);

                            // Encryption encryption = new Encryption(lastRound, helper);
                            // decryptedText += encryption.getEncryptedHexaText();
                            Decryption decryption = new Decryption(helper, generateKey, message);
                            decryptedHexaText += decryption.getDecryptedText();
                        }
                        decryptedText = helper.hexToString(decryptedHexaText);
                        System.out.println("From:" + fromUser + " Message:" + decryptedText + " Key: " + keyStr);
                    } else {
                        System.out.println(response);

                    }

                    // System.out.println("In hereeee client");

                    // client.setSendToServerFlag(true);
                    // this.sendToServer = true; //(race condition)

                }
            }
        } catch (Exception e) {
            System.out.println("yaha pe hai error");
            System.out.println(e);
        }

    }

}
