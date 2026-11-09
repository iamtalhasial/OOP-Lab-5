package parkinglab;

public class Utility {
    public static void main(String[] args) {
        ParkingRecord drAhmed = new ParkingRecord("LHR-1234", "Dr. Ahmed", new int[]{2, 3, 1}, false);
        ParkingRecord msSara = new ParkingRecord("LHR-5678", "Ms. Sara", new int[]{1, 1, 2}, false);

        ParkingRecord shallow = new ParkingRecord(drAhmed);
        ParkingRecord deep = new ParkingRecord(drAhmed, true);

        drAhmed.updateDuration(0, 4);

        System.out.println("Original total hours: " + drAhmed.calculateTotalHours());
        System.out.println("Shallow: " + shallow.calculateTotalHours() + " | Deep: " + deep.calculateTotalHours());

        ParkingRecord longer = drAhmed.getLongerRecord(msSara);
        System.out.println("Longer record: " + longer.getRegistrationNo());

        msSara.recordExit(); // Invalid exit attempt
        drAhmed.recordEntry();
        drAhmed.recordExit();

        System.out.println("ParkingRecord objects: " + ParkingRecord.getRecordsCreated());

        VisitorPass pass = new VisitorPass("VP-10", "Noor", false);
        pass.activate();
        pass.displayPass();
    }
}