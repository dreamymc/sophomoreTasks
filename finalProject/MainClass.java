import java.util.Scanner;

public class MainClass {
    public static void main(String[] ukiyo) {
        new MainClass();
    }

    public MainClass() {
        run();
    }

    private void run() {
        Scanner scan = new Scanner(System.in);
        HospitalQueueingManagement queue = new HospitalQueueingManagement();
        System.out.println("Hospital Queue Management System");
        while (true) {
            System.out.println("[1] Add a patient to the queue");
            System.out.println("[2] Displays the current queue");
            System.out.println("[3] Search for a patient and display information");
            System.out.println("[4] Displays all the patient and their information");
            System.out.print("Input: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    queue.addPatient();
                    break;
                case 2:
                    queue.displayQueue();
                    break;
                case 3: // Search
                    queue.searchPatient();
                    break;
                case 4:
                    queue.displayAllPatients();
                    break;
                default:
                    System.out.println("Invalid Input.");
            }
        }
    }
}
