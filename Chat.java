public class Chat {
    private String fromUser, toUser, message = "";

    public Chat() {
    }

    public Chat(String fromUser, String toUser, String message) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.message = message;
    }

    public String getFromUser() {
        return this.fromUser;
    }

    public String getToUser() {
        return this.toUser;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return "Chat: [" + this.fromUser + " , " + this.toUser + " , " + this.message + "] ";
    }
}
