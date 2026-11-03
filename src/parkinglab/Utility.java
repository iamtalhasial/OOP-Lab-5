package parkinglab;

public class Utility {
    public static void main(String[] args) {
        ParkingRecord[] records = new ParkingRecord[2];
        records[0] = new ParkingRecord("LHR-1234", "Dr. Ahmed", new int[]{2, 3, 1}, false);
        records[1] = new ParkingRecord("LHR-5678", "Ms. Sara", new int[]{1, 1, 2}, false);

        for (ParkingRecord r : records) {
            r.displayStatus();
        }

        records[0].recordEntry();
        records[0].recordExit();
        records[1].recordExit();

        ParkingRecord alias = records[0];
        alias.updateDuration(2, 3);
        System.out.println("After alias update | " + records[0].getRegistrationNo() + " | Total hours: " + records[0].calculateTotalHours());

        System.out.println("Parking records created: " + ParkingRecord.getRecordsCreated());

        VisitorPass pass = new VisitorPass("VP-10", "Noor", false);
        pass.activate();
        pass.displayPass();
    }
}