package airlinelab;

public class AirportNotice {
    private final String noticeId;
    private String message;
    private boolean active;

    public AirportNotice(String noticeId, String message, boolean active) {
        this.noticeId = noticeId;
        setMessage(message);
        this.active = active;
    }

    public void setMessage(String message) {
        if (message != null && !message.isEmpty()) {
            this.message = message;
        } else {
            System.out.println("Invalid notice message.");
        }
    }

    public void displayNotice() {
        System.out.println(noticeId + " | " + message + " | Active: " + active);
    }
}