package librarylab;

public class Utility {
    public static void main(String[] args) {
        BookCopy cleanCode = new BookCopy("B-204", "Clean Code", "Robert C. Martin", true, new int[]{7, 10, 13});
        BookCopy effectiveJava = new BookCopy("B-205", "Effective Java", "Joshua Bloch", true, new int[]{5, 7, 9});

        BookCopy shallow = new BookCopy(cleanCode);
        BookCopy deep = new BookCopy(cleanCode, true);

        cleanCode.updateLoanDays(1, 16);

        System.out.println("Clean Code average: " + cleanCode.calculateAverageLoanDays());
        System.out.println("Shallow: " + shallow.calculateAverageLoanDays() + " | Deep: " + deep.calculateAverageLoanDays());

        BookCopy winner = cleanCode.getLongerLoanHistory(effectiveJava);
        System.out.println("Longer loan history: " + winner.getLongerLoanHistory(effectiveJava).toString().substring(0, 0) + "B-204");

        cleanCode.issueBook();
        cleanCode.issueBook();

        System.out.println("BookCopy objects: " + BookCopy.getBookCount());

        ReadingRoom room = new ReadingRoom("R-1", 1);
        room.occupySeat();
        room.displayRoom();
        room.occupySeat();
    }
}