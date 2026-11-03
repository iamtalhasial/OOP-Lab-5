package librarylab;

public class BookCopy {
    private final String copyId;
    private String title;
    private String author;
    private boolean available;
    private int[] loanDays;
    private static int bookCount = 0;

    public BookCopy(String copyId, String title, String author, boolean available, int[] loans) {
        this.copyId = copyId;
        this.title = title;
        this.author = author;
        this.available = available;
        this.loanDays = new int[3];
        for (int i = 0; i < 3; i++) {
            this.loanDays[i] = (loans[i] >= 0) ? loans[i] : 0;
        }
        bookCount++;
    }

    public void issueBook() {
        if (available) {
            available = false;
            System.out.println("Book issued: " + copyId);
        } else {
            System.out.println("Cannot issue: book unavailable.");
        }
    }

    public void returnBook() {
        available = true;
        System.out.println("Book returned: " + copyId);
    }

    public void updateLoanDays(int index, int days) {
        if (index >= 0 && index < 3 && days > 0) {
            loanDays[index] = days;
        } else {
            System.out.println("Invalid loan days or index.");
        }
    }

    public double calculateAverageLoanDays() {
        int sum = 0;
        for (int d : loanDays) {
            sum += d;
        }
        return sum / 3.0;
    }

    public void displayBook() {
        System.out.println(copyId + " | " + title + " | Available: " + available + " | Avg loan: " + calculateAverageLoanDays());
    }

    public static int getBookCount() { return bookCount; }
}