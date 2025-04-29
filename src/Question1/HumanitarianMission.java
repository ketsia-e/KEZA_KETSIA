package Question1;

import java.util.Date;
import java.util.List;

public class HumanitarianMission extends Mission {
    private List<Resource> resources;

    public HumanitarianMission(String missionId, String missionName, Date missionStartDate, Date missionEndDate,
                               String status, List<Personnel> assignedPersonnel) {
        super(missionId, missionName, missionStartDate, missionEndDate, status);
        this.resources = resources;
    }

    @Override
    public void assignTask() {
        System.out.println("Assigning humanitarian tasks: distribution, logistics, medical aid...");
        for (Personnel p : assignedPersonnel) {
            System.out.println("Assigned humanitarian role to: " + p.getPersonnelName());
        }
    }

    @Override
    public void allocateResources(List<Resource> availableResources) {

    }

    @Override
    public void allocateResources() {
        boolean foodAvailable = false;
        boolean medicalKitsAvailable = false;

        for (Resource r : resources) {
            if (r.getResourceName().equalsIgnoreCase("Food Supplies") && r.getQuantity() > 0) {
                foodAvailable = true;
                System.out.println("Allocating Food Supplies...");
            }
            if (r.getResourceName().equalsIgnoreCase("Medical Kit") && r.getQuantity() > 0) {
                medicalKitsAvailable = true;
                System.out.println("Allocating Medical Kits...");
            }
        }

        if (!foodAvailable || !medicalKitsAvailable) {
            System.out.println("Error: Essential humanitarian resources missing!");
        }
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Tracking humanitarian aid distribution progress...");
        // Logic to monitor how many people helped, aid distributed, etc.
    }

    @Override
    public void generateMissionReport() {
        System.out.println("Generating Humanitarian Mission Report...");
        // Summary of aid distribution, beneficiaries, resources consumed
    }

    public boolean validateEssentialResourcesAvailable() {
        boolean foodAvailable = false;
        boolean medicalAvailable = false;

        for (Resource r : resources) {
            if (r.getResourceName().equalsIgnoreCase("Food Supplies") && r.getQuantity() > 0) {
                foodAvailable = true;
            }
            if (r.getResourceName().equalsIgnoreCase("Medical Kit") && r.getQuantity() > 0) {
                medicalAvailable = true;
            }
        }
        return foodAvailable && medicalAvailable;
    }
}
