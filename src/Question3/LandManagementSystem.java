package Question3;

import java.util.*;

public class LandManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Land> registry = new ArrayList<>();

        System.out.println("Enter number of lands to register:");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter land type (agricultural, residential, commercial, industrial):");
            String type = scanner.nextLine().toLowerCase();

            System.out.print("Land ID: ");
            String id = scanner.nextLine();

            System.out.print("Owner Name: ");
            String owner = scanner.nextLine();

            System.out.print("Location: ");
            String location = scanner.nextLine();

            System.out.print("Size in acres: ");
            double size = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Land use status (e.g., Vacant, In Use): ");
            String status = scanner.nextLine();

            Land land = null;
            Date regDate = new Date();

            switch (type) {
                case "agricultural":
                    land = new AgriculturalLand(id, owner, location, size, regDate, status);
                    break;
                case "residential":
                    System.out.print("Number of residential units: ");
                    int units = scanner.nextInt();
                    scanner.nextLine();
                    land = new ResidentialLand(id, owner, location, size, regDate, status, units);
                    break;
                case "commercial":
                    land = new CommercialLand(id, owner, location, size, regDate, status);
                    break;
                case "industrial":
                    System.out.print("Environmental clearance (true/false): ");
                    boolean clearance = scanner.nextBoolean();
                    scanner.nextLine();
                    land = new IndustrialLand(id, owner, location, size, regDate, status, clearance);
                    break;
                default:
                    System.out.println("Invalid land type.");
                    i--; // retry this entry
                    continue;
            }

            registry.add(land);
        }

        System.out.println("\n======= LAND REPORTS =======");
        for (Land land : registry) {
            land.generateLandReport();
        }

        scanner.close();
    }
}
