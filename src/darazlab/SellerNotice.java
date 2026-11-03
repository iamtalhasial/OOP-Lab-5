package darazlab;

public class SellerNotice {
    private final String noticeId;
    private String message;
    private boolean active;

    public SellerNotice(String noticeId, String message, boolean active) {
        this.noticeId = noticeId;
        this.message = message;
        this.active = active;
    }

    public void setMessage(String message) { this.message = message; }
    public void deactivate() { this.active = false; }

    public void displayNotice() {
        System.out.println(noticeId + " | " + message + " | Active: " + active);
    }
}