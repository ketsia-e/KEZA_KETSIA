package Question1;

import java.util.Date;
import java.util.List;

public class RescueMission extends Mission {
    private List<Resource> resources;

    public RescueMission(String missionId, String missionName, Date missionStartDate, Date missionEndDate,
                         String status, List<Personnel> assignedPersonnel) {
        super(missionId, missionName, missionStartDate, missionEndDate, status);
        this.resources = resources;
    }

    @Override
    public void assignTask() {
        System.out.println("Assigning rescue, medical, and logistics tasks to personnel...");
        for (Personnel p : assignedPersonnel) {
            System.out.println("Assigned task based on role: " + p.getPersonnelRole());
        }
    }

    @Override
    public void allocateResources(List<Resource> availableResources) {

    }

    @Override
    public void allocateResources() {
        boolean medicalSuppliesAvailable = false;
        for (Resource r : resources) {
            if (r.getResourceName().equalsIgnoreCase("Medical Kit") && r.getQuantity() > 0) {
                medicalSuppliesAvailable = true;
                System.out.println("Allocating Medical Kit...");
            }
            if (r.getResourceName().equalsIgnoreCase("Ambulance") && r.getQuantity() > 0) {
                System.out.println("Allocating Ambulance...");
            }
        }
        if (!medicalSuppliesAvailable) {
            System.out.println("Error: Medical supplies unavailable for Rescue Mission!");
        }
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Tracking rescue mission progress...");
        // Logic to track milestones: rescued individuals, treated injured, etc.
    }

    @Override
    public void generateMissionReport() {
        System.out.println("Generating Rescue Mission Report...");
        // Include personnel tasks, resource usage, rescue stats
    }

    public boolean validateMedicAssigned() {
        for (Personnel p : assignedPersonnel) {
            if (p.getPersonnelRole().equalsIgnoreCase("Medic")) {
                return true;
            }
        }
        return false;
    }
}
