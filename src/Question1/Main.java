package Question1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Personnel> personnelList = new ArrayList<>();
        List<Resource> resourceList = new ArrayList<>();
        System.out.println("Welcome to Mission Management System!");

        // Step 1: Get basic mission info
        System.out.print("Enter Mission ID: ");
        String missionId = scanner.nextLine();
        System.out.print("Enter Mission Name: ");
        String missionName = scanner.nextLine();
        Date startDate = new Date(); // Just using current date for simplicity
        Date endDate = new Date();   // Same here, you can customize if needed
        System.out.print("Enter Mission Status (e.g., Planned, In Progress, Completed): ");
        String missionStatus = scanner.nextLine();
        System.out.print("Enter Mission Type (Rescue / Combat / Humanitarian): ");
        String missionType = scanner.nextLine();

        // Step 2: Get personnel
        System.out.print("How many personnel to assign? ");
        int personnelCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < personnelCount; i++) {
            System.out.println("Enter Personnel #" + (i + 1) + " details:");
            System.out.print("Personnel ID: ");
            String pId = scanner.nextLine();
            System.out.print("Personnel Name: ");
            String pName = scanner.nextLine();
            System.out.print("Personnel Role: ");
            String pRole = scanner.nextLine();
            personnelList.add(new Personnel(pId, pName, pRole));
        }

        // Step 3: Get resources
        System.out.print("How many resources to allocate? ");
        int resourceCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < resourceCount; i++) {
            System.out.println("Enter Resource #" + (i + 1) + " details:");
            System.out.print("Resource ID: ");
            String rId = scanner.nextLine();
            System.out.print("Resource Name: ");
            String rName = scanner.nextLine();
            System.out.print("Resource Quantity: ");
            int rQuantity = Integer.parseInt(scanner.nextLine());
            resourceList.add(new Resource(rId, rName, rQuantity));
        }

        // Step 4: Create Mission based on type
        Mission mission = null;
        switch (missionType.toLowerCase()) {
            case "rescue":
                mission = new RescueMission(missionId, missionName, startDate, endDate, missionStatus, personnelList);
                break;
            case "combat":
                mission = new CombatMission(missionId, missionName, startDate, endDate, missionStatus, personnelList);
                break;
            case "humanitarian":
                mission = new HumanitarianMission(missionId, missionName, startDate, endDate, missionStatus, personnelList);
                break;
            default:
                System.out.println("Invalid mission type entered!");
                System.exit(0);
        }

        // Step 5: Execute mission methods
        System.out.println("\n--- Mission Operations ---\n");
        mission.assignTask();
        mission.allocateResources(resourceList); // Pass the resource list to the method
        mission.trackMissionProgress();
        mission.generateMissionReport();
        System.out.println("\nMission completed successfully!");
        scanner.close();
    }
}
