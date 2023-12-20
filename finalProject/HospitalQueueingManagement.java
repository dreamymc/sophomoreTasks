import java.util.*;

public class HospitalQueueingManagement extends AbstractClass {
    HashMap<String, List<String>> map = new HashMap<>();
    HashMap<String, Integer> queueMap = new HashMap<>();
    Queue<String> hospitalQueue = new LinkedList<>();

    public void addPatient() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Patient's name: ");
        String name = sc.nextLine();
        System.out.print("Patient's age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Patient's Medical History: ");
        String history = sc.nextLine();
        System.out.println("10]Cardiac Arrest");
        System.out.println("9] Stroke");
        System.out.println("8] Severe Trauma");
        System.out.println("7] Respiratory Failure");
        System.out.println("6] Severe Bleeding");
        System.out.println("5] Heart Attack");
        System.out.println("4] Poisoning");
        System.out.println("3] Severe Allergic Reactions");
        System.out.println("2] Sepsis");
        System.out.println("1] Status Epilepticus");
        System.out.print("Choose the medical condition of the patient: ");
        int medCondition = sc.nextInt();

        System.out.println("4] Catastrophic"
                + "\n3] Critical"
                + "\n2] Serious"
                + "\n1] Mild");
        System.out.print("Choose the severity: ");
        int severity = sc.nextInt();

        int sumSeverity = medCondition + severity;
        if (!map.containsKey(name))
            map.put(name, new LinkedList<>());

        map.get(name).add(Integer.toString(age));
        map.get(name).add(history);
        map.get(name).add(Integer.toString(medCondition));
        map.get(name).add(Integer.toString(severity));
        map.get(name).add(Integer.toString(sumSeverity));
        queueMap.put(name, sumSeverity);
        System.out.println();

    }

    public void displayQueue() {
        System.out.println("Prioritized Patients: ");
        queueMapSorting();
        for (String patient : hospitalQueue)
            System.out.println(patient);
        System.out.println();
    }

    public void displayAllPatients() {
        for (String each : map.keySet()) {
            System.out.println("\nName: " + each);
            System.out.println("Age: " + map.get(each).get(0));
            System.out.println("Medical History: " + map.get(each).get(1));
            System.out.println("Medical Condition: " + medCondition(Integer.parseInt(map.get(each).get(2))));
            System.out.println("Severity: " + severity(Integer.parseInt(map.get(each).get(3))));
            System.out.println("Priority Number: " + map.get(each).get(4));
            System.out.println();
        }
    }

    public void searchPatient() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Search for a patient: ");
        String patient = scan.nextLine();
        if (hospitalQueue.contains(patient))
            System.out.printf(
                    "Patient name: %s\nAge: %s\nMedical History: %s\nMedical Condition: %s\nMedical Severity: %s\n",
                    patient, map.get(patient).get(0), map.get(patient).get(1),
                    medCondition(Integer.parseInt(map.get(patient).get(2))),
                    severity(Integer.parseInt(map.get(patient).get(3))));
        else
            System.out.println("Patient not found.");
        System.out.println();

    }

    public String medCondition(int x) {
        switch (x) {
            case 10:
                return "Cardiac Arrest";
            case 9:
                return "Stroke";
            case 8:
                return "Severe Trauma";
            case 7:
                return "Respiratory Failure";
            case 6:
                return "Severe Bleeding";
            case 5:
                return "Heart Attack";
            case 4:
                return "Poisoning";
            case 3:
                return "Allergic Reaction";
            case 2:
                return "Sepsis";
            case 1:
                return "Status Epilepticus";
        }
        return "";
    }

    public String severity(int y) {
        switch (y) {
            case 4:
                return "Catastrophic";
            case 3:
                return "Critical";
            case 2:
                return "Serious";
            case 1:
                return "Mild";
        }
        return "";
    }

    public void queueMapSorting() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Set<String> addedNames = new HashSet<>(); // To keep track of added names
        for (String key : queueMap.keySet())
            linkedList.add(queueMap.get(key));
        exchangeSort(linkedList);

        // Clear and refill the hospitalQueue
        hospitalQueue.clear();
        for (int each : linkedList) {
            for (String queueMapKey : queueMap.keySet()) {
                if (each == queueMap.get(queueMapKey) && addedNames.add(queueMapKey)) {
                    hospitalQueue.add(queueMapKey);
                }
            }
        }
    }

    public List<Integer> exchangeSort(List<Integer> arr) { // O(n^2)
        for (int i = 0; i < arr.size() - 1; i++)
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) < arr.get(j)) { // Swap arr[i] and arr[j]
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        return arr;
    }

}