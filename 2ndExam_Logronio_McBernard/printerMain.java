import java.util.Scanner;

public class printerMain {
    public static void main(String[] _dreamymc) {
        try (Scanner scan = new Scanner(System.in)) {
            printerImplementation printer = new printerImplementation();
            while (true) {
                System.out.println("------------------------------------");
                System.out.print(
                        "Printer Options \n[1] Add Paper to printer \n[2] Check if the printer has papers \n[3] Print \n[4] Close printer \n[5] Views the top of the papers \nEnter: ");
                int choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter how many papers to add: ");
                        printer.addPaper(scan.nextInt());
                        break;
                    case 2:
                        if (printer.checkPrinter() == true)
                            System.out.println("The printer has papers.");
                        else
                            System.out.println("The printer has no papers.");
                        break;
                    case 3:
                        printer.print();
                        break;
                    case 4:
                        System.out.println("Printer closed.");
                        System.exit(0);
                        break;
                    case 5:
                        System.out.println(printer.stack_enqueue.peek());
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
        }
    }
}