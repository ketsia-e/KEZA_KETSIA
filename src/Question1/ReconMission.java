package Question1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReconMission extends Mission {

    private List<Resource> resources = new ArrayList<>();
    private List<Personnel> assignedPersonnel; // Assuming Personnel is a class

    public ReconMission(String missionId, String missionName, Date startDate, Date endDate, String status, List<Personnel> assignedPersonnel) {
        super(missionId, missionName, startDate, endDate, status);
        this.assignedPersonnel = assignedPersonnel; // Assigning the personnel
    }

    @Override
    public void assignTask() {
        if (assignedPersonnel.size() < 2) {
            System.out.println("At least 2 personnel are required.");
            return;
        }
        System.out.println("Recon tasks assigned to personnel.");
    }

    @Override
    public void allocateResources(List<Resource> availableResources) {
        for (Resource r : availableResources) {
            if (r.getResourceName().equalsIgnoreCase("Drone") && r.getQuantity() > 0) {
                resources.add(r);
                r.decrementQuantity(1);
                System.out.println("Drone allocated.");
            }
        }
        if (resources.isEmpty()) {
            System.out.println("No drones available for allocation!");
        }
    }

    @Override
    public void allocateResources() {

    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Tracking recon mission progress...");
        this.status = "IN_PROGRESS";
    }

    @Override
    public void generateMissionReport() {
        System.out.println("=== Recon Mission Report ===");
        System.out.println("Mission Name: " + missionName);
        System.out.println("Status: " + status);
        System.out.println("Personnel Assigned: " + assignedPersonnel.size());
        System.out.println("Resources Used: " + resources.size() + " drones");
    }
}

