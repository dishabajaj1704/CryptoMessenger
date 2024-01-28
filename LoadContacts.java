// package xmlParser;

// import java.io.*;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

// public class LoadContacts {
// ContactsList contactsList;

// public LoadContacts() {
// System.out.println("Load Contacts COnstructor");
// this.parse();
// }

// public void parse() {
// File f = new File("data.xml");
// String line = "";
// String text = "";
// try {
// FileInputStream fis = new FileInputStream(f);
// BufferedReader in = new BufferedReader(new InputStreamReader(fis));
// while (((line = in.readLine()) != null)) {
// text += line;
// }
// String regex =
// "<Contact>\\s*<name>(.*?)<\\/name>\\s*<phoneNumber>(.*?)<\\/phoneNumber>\\s*<email>(.*?)<\\/email>\\s*<DateOfBirth>(.*?)<\\/DateOfBirth>\\s*<\\/Contact>";
// Pattern pattern = Pattern.compile(regex);
// Matcher matcher = pattern.matcher(text);
// while (matcher.find()) {
// System.out.println("Full Group:- " + matcher.group(0));
// System.out.println("Group 1:" + matcher.group(1));
// System.out.println("Group 2:" + matcher.group(2));
// System.out.println("Group 3: " + matcher.group(3));
// System.out.println("Group 4:" + matcher.group(4));
// contactsList = new ContactsList();
// contactsList.addToList(
// new Chat(matcher.group(1), matcher.group(2), matcher.group(3),
// matcher.group(4)));
// }
// in.close();
// fis.close();
// } catch (FileNotFoundException e) {
// System.out.println("File not found!");
// } catch (IOException e) {
// System.out.println("Caught IOException!");
// }
// }

// }