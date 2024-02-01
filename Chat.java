public class Chat {
    private String fromUser, toUser, message, key = "";

    public Chat() {
    }

    public Chat(String fromUser, String toUser, String message, String key) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.message = message;
        this.key = key;
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

    public String getKey(){
        return this.key;
    }

    @Override
    public String toString() {
        return "Chat: [" + this.fromUser + " , " + this.toUser + " , " + this.message + "] ";
    }
}
