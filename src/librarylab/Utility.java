package librarylab;

public class Utility {
    public static void main(String[] args) {
        BookCopy[] books = new BookCopy[2];
        books[0] = new BookCopy("B-204", "Clean Code", "Robert C. Martin", true, new int[]{7, 10, 13});
        books[1] = new BookCopy("B-205", "Effective Java", "Joshua Bloch", true, new int[]{5, 7, 9});

        for (BookCopy b : books) {
            b.displayBook();
        }

        books[0].issueBook();
        books[0].issueBook();

        BookCopy alias = books[0];
        alias.returnBook();

        System.out.println("Book objects created: " + BookCopy.getBookCount());

        ReadingRoom room = new ReadingRoom("R-1", 1);
        room.occupySeat();
        room.displayRoom();
        room.occupySeat();
    }
}