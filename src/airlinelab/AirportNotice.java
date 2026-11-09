package airlinelab;

public class AirportNotice {
    private final String noticeId;
    private String message;
    private boolean active;
    private static int noticeCount = 0;

    public AirportNotice(String noticeId, String message, boolean active) {
        this.noticeId = noticeId;
        setMessage(message);
        this.active = active;
        noticeCount++;
    }

    public String getNoticeId() { return noticeId; }
    public String getMessage() { return message; }

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

    public static int getNoticeCount() { return noticeCount; }
}