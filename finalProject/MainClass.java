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
            System.out.println("Current bed spaces available: " + queue.bedSpace);
            System.out.println("[1] Add a patient to the queue");
            System.out.println("[2] Displays the current queue");
            System.out.println("[3] Search for a patient and display information");
            System.out.println("[4] Displays all the patient and their information");
            System.out.println("[5] Treat a patient");
            System.out.println("[6] Exit");
            System.out.print("Input: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    if(queue.bedSpace!=0)
                    queue.addPatient();
                    else 
                    System.out.println("There are no bed spaces available. Sorry for the inconvenience.");
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
                case 5:
                    queue.treatPatient();
                    break;
                case 6:
                    System.out.println("Program closed.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input.");
            }
        }
    }
}
