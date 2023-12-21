import java.util.*;

public class HospitalQueueingManagement extends abstractFinal {
    HashMap<String, List<String>> map = new HashMap<>(); // HashMap to store patient information
    HashMap<String, Integer> queueMap = new HashMap<>(); // HashMap to store the priority of patients based on their
                                                         // medical condition and severity
    Integer bedSpace = 15;
    Queue<String> hospitalQueue = new LinkedList<>(); // // Queue to maintain the order of patients in the hospital
                                                      // queue

    public void addPatient() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Patient's name: ");
        String name = sc.nextLine();
        System.out.print("Patient's age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Patient's Medical History: ");
        String history = sc.nextLine();
        medicalConditionOfThePatient();
        System.out.print("Choice: ");
        int medCondition = sc.nextInt();

        System.out.println("\nSEVERITY");
        System.out.println("4] Catastrophic" + "\n3] Critical" + "\n2] Serious" + "\n1] Mild");
        System.out.print("Choice: ");
        int severity = sc.nextInt();

        int sumSeverity = medCondition + severity; // Calculate the sum of medical condition and severity to determine
                                                   // priority value

        if (!map.containsKey(name)) // If the patient is not already in the map, add them with an empty list
            map.put(name, new LinkedList<>());

        map.get(name).add(Integer.toString(age));
        map.get(name).add(history);
        map.get(name).add(Integer.toString(medCondition));
        map.get(name).add(Integer.toString(severity));
        map.get(name).add(Integer.toString(sumSeverity));
        queueMap.put(name, sumSeverity);
        bedSpace--;
        System.out.println();

    }

    public void displayQueue() { // Displays the prioritized patients in the hospital queue
        System.out.println("Prioritized Patients: ");
        queueMapSorting();
        for (String patient : hospitalQueue)
            System.out.println(patient);
        System.out.println();
    }

    public void displayAllPatients() { // Display helper
        for (String each : map.keySet()) {
            System.out.println("\nName: " + each);
            System.out.println("Age: " + map.get(each).get(0));
            System.out.println("Medical History: " + map.get(each).get(1));
            System.out.println("Medical Condition: " + medCondition(Integer.parseInt(map.get(each).get(2))));
            System.out.println("Severity: " + severity(Integer.parseInt(map.get(each).get(3))));
            System.out.println("Priority Number: " + map.get(each).get(4));
            System.out.println("Medical Treatment: " + medTreatment(Integer.parseInt(map.get(each).get(2))));
            System.out.println();
        }
    }

    public void searchPatient() { // Searches for patients and displays their information as well
        Scanner scan = new Scanner(System.in);
        System.out.print("Search for a patient: ");
        String patient = scan.nextLine();
        if (map.containsKey(patient)) { // Check if the patient exists in the map
            System.out.printf(
                    "Patient name: %s\nAge: %s\nMedical History: %s\nMedical Condition: %s\nMedical Severity: %s\nMedical Treatment: %s",
                    patient, map.get(patient).get(0), map.get(patient).get(1),
                    medCondition(Integer.parseInt(map.get(patient).get(2))),
                    severity(Integer.parseInt(map.get(patient).get(3))),
                    medTreatment(Integer.parseInt(map.get(patient).get(2))));
            System.out.println();
        } else {
            System.out.println("Patient not found.");
        }
        System.out.println();
    }

    public String medCondition(int x) { // For display purposes
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

    public String medTreatment(int x) { // For display purposes
        switch (x) {
            case 10:
                return "To perform cardiopulmonary resuscitation (CPR), use an \nautomated external defibrillator (AED) if available, and provide other medication to ease the condition.";
            case 9:
                return "Stroke treatment in the emergency room involves immediate interventions such as clot-busting drugs\n for ischemic stroke, surgery for hemorrhagic stroke, and supportive care like monitoring vital signs and oxygen levels, \nproviding ventilator support if needed, and initiating early rehabilitation.";
            case 8:
                return "Assessing and stabilizing the patient, controlling bleeding, ensuring clear airways, \nand providing pain relief, with further interventions like surgery or diagnostic tests as needed.";
            case 7:
                return "Ensuring an open airway, providing artificial ventilation if needed, and addressing the underlying cause, \nwhich may involve supplemental oxygen, mechanical ventilation, or other respiratory support as determined by the doctors.";
            case 6:
                return "Apply direct pressure to the wound using a sterile bandage or cloth, if possible, and seek emergency medical \nassistance. Additionally, consider using a tourniquet as a last resort if bleeding cannot be controlled by direct pressure, \nbut this should be done with caution and ideally by trained personnel.";
            case 5:
                return "Administer oxygen for optimal oxygenation, relieve pain using medications like nitroglycerin, \nand initiate \nantiplatelet therapy such as aspirin. \nFurther interventions may include thrombolytics or PCI to restore blood flow, while continuous cardiac monitoring \nand diagnostic tests guide our treatment approach for the individual patient.";
            case 4:
                return "Ensure that the patient is always hydrated with clear fluids, and symptomatic relief with over-the-counter anti-diarrheal medications.";
            case 3:
                return "Administer epinephrine using an auto-injector like an EpiPen immediately if severe \nsymptoms such as difficulty breathing or swelling occur. Follow up with antihistamines \nfor less severe reactions, but seek emergency medical assistance promptly after using epinephrine.";
            case 2:
                return "Administer broad-spectrum antibiotics to target the underlying infection. \nIntravenous fluids are given to maintain blood pressure, and in severe cases, \nvasopressors may be used. Continuous monitoring of vital signs, frequent laboratory tests, and imaging studies help \nguide ongoing treatment, while supportive care addresses organ dysfunction.";
            case 1:
                return "Administration of benzodiazepines, such as lorazepam or diazepam, \nto quickly stop the seizures, followed by antiepileptic medications for longer-term \nmanagement.";
        }
        return "";
    }

    public String severity(int y) { // For display purposes
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

    public void queueMapSorting() { // sort the hospital queue based on priority using exchange sort
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

    @Override
    public void treatPatient() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Search for a patient: ");
        String patientName = scan.nextLine();
        if (map.containsKey(patientName)) {
            map.remove(patientName); // Remove patient from the map
            queueMap.remove(patientName); // Remove patient from the priority map
            hospitalQueue.remove(patientName); // Remove patient from the queue
            System.out.println("Patient '" + patientName + "' has been treated and removed from the queue.");
        } else {
            System.out.println("Patient not found in the queue.");
        }
        bedSpace++;
        System.out.println();
    }

    public void medicalConditionOfThePatient() {
        System.out.println("\nMEDICAL CONDITION OF THE PATIENT");
        System.out.println(
                "10]Cardiac Arrest || (Coronary Artery Disease (CAD), Arrhythmias, Drug Overdose, Hypoxia, Cardiomyopathy)");
        System.out.println("9] Stroke || (Ischemic, Hemorrhagic, Transient Ischemic Attack, Cryptogenic)");
        System.out
                .println("8] Severe Trauma || (Car accidents, Sexual Assults, Physical Assault, Falls, Combat Trauma)");
        System.out.println("7] Respiratory Failure || (Acute, Chronic, Hypoxemic, Hypercapnic)");
        System.out.println("6] Severe Bleeding || (External, Internal, Intracranial)");
        System.out.println(
                "5] Heart Attack || (Atherosclerosis, Thrombosis, Severe Physical Exertion, Hypertension, Diabetes)");
        System.out.println("4] Poisoning || (Bacterial, Viral, Parasitic, Toxin-Mediated, Chemical)");
        System.out.println(
                "3] Severe Allergic Reactions || (Food-Induced, Insect Sting-Induced, Medication-Induced, Latex-Induced)");
        System.out.println("2] Sepsis || (Septic Shock, Organ Dysfunction, Quick SOFA , Early Goal-Directed Therapy)");
        System.out
                .println("1] Status Epilepticus || (Convulsive Status Epilepticus, Non-Convulsive Status Epilepticus)");
    }

}