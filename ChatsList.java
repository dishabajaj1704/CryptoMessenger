import javax.swing.*;
import java.util.*;

public class ChatsList extends JPanel {
    private static ArrayList<Chat> chats = new ArrayList<>();
    private static XMLForm xmlForm = new XMLForm();

    public ChatsList() {
        System.out.println("Contacs:-" + chats);
    }

    public void addChat(Chat c) {
        chats.add(c);
        xmlForm.addToXML(c);
        System.out.println(chats);
    }

    public void addToList(Chat c) {
        chats.add(c);
    }

    public int getchatsSize() {
        int size = chats.size();
        return size;
    }

}