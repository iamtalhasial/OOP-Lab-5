package librarylab;

public class BookCopy {
    private final String copyId;
    private String title;
    private String author;
    private boolean available;
    private int[] loanDays;
    private static int bookCount = 0;

    public BookCopy(String copyId, String title, String author, boolean available, int[] loanDays) {
        this.copyId = copyId;
        this.title = title;
        this.author = author;
        this.available = available;
        this.loanDays = new int[3];
        for (int i = 0; i < 3; i++) {
            this.loanDays[i] = (loanDays != null && loanDays[i] >= 0) ? loanDays[i] : 0;
        }
        bookCount++;
    }

    public BookCopy(BookCopy other) {
        this.copyId = other.copyId;
        this.title = other.title;
        this.author = other.author;
        this.available = other.available;
        this.loanDays = other.loanDays;
        bookCount++;
    }

    public BookCopy(BookCopy other, boolean deep) {
        this.copyId = other.copyId;
        this.title = other.title;
        this.author = other.author;
        this.available = other.available;
        if (deep) {
            this.loanDays = new int[other.loanDays.length];
            for (int i = 0; i < other.loanDays.length; i++) {
                this.loanDays[i] = other.loanDays[i];
            }
        } else {
            this.loanDays = other.loanDays;
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

    public void returnBook() { available = true; }

    public void updateLoanDays(int index, int days) {
        if (index >= 0 && index < 3 && days > 0) {
            loanDays[index] = days;
        } else {
            System.out.println("Invalid loan days or index.");
        }
    }

    public double calculateAverageLoanDays() {
        int sum = 0;
        for (int d : loanDays) sum += d;
        return sum / 3.0;
    }

    public boolean hasLongerLoanThan(BookCopy other) {
        return other != null && this.calculateAverageLoanDays() > other.calculateAverageLoanDays();
    }

    public BookCopy getLongerLoanHistory(BookCopy other) {
        if (other == null || this.calculateAverageLoanDays() >= other.calculateAverageLoanDays()) return this;
        return other;
    }

    public void displayBook() {
        System.out.println(copyId + " | " + title + " | Avg loan: " + calculateAverageLoanDays());
    }

    public static int getBookCount() { return bookCount; }
}