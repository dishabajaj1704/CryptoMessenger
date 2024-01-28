import java.io.*;

public class XMLForm {
    File f;
    FileOutputStream fout;

    public XMLForm() {
        f = new File("data.xml");
    }

    public void addToXML(Chat c) {
        try {
            this.fout = new FileOutputStream(f, true);
        } catch (FileNotFoundException e) {
        }

        String xmlCode = "\n<Message>\n" +
                "<From>" + c.getFromUser() + "</From>\n" +
                "<To>" + c.getToUser() + "</To>\n" +
                "<Body>" + c.getMessage() + "</Body>\n" +
                "</Message>\n";
        try {
            byte b[];
            b = xmlCode.getBytes();
            fout.write(b);
            fout.flush();
        } catch (IOException e) {
        }
    }

}