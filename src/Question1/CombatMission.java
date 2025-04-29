package Question1;

import java.util.Date;
import java.util.List;

public class CombatMission extends Mission {
    private List<Resource> resources;

    public CombatMission(String missionId, String missionName, Date missionStartDate, Date missionEndDate,
                         String status, List<Personnel> assignedPersonnel) {
        super(missionId, missionName, missionStartDate, missionEndDate, status);
        this.resources = resources;
    }

    @Override
    public void assignTask() {
        System.out.println("Assigning combat tasks: defense, attack, and strategic operations...");
        for (Personnel p : assignedPersonnel) {
            System.out.println("Assigned combat role to: " + p.getPersonnelName());
        }
    }

    @Override
    public void allocateResources(List<Resource> availableResources) {

    }

    @Override
    public void allocateResources() {
        boolean ammunitionAvailable = false;
        boolean vehiclesAvailable = false;

        for (Resource r : resources) {
            if (r.getResourceName().equalsIgnoreCase("Ammunition") && r.getQuantity() > 0) {
                ammunitionAvailable = true;
                System.out.println("Allocating Ammunition...");
            }
            if (r.getResourceName().equalsIgnoreCase("Vehicle") && r.getQuantity() > 0) {
                vehiclesAvailable = true;
                System.out.println("Allocating Combat Vehicles...");
            }
        }

        if (!ammunitionAvailable || !vehiclesAvailable) {
            System.out.println("Error: Combat resources insufficient!");
        }
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Tracking combat mission outcomes...");
        // Logic for recording defense, attack results, progress status
    }

    @Override
    public void generateMissionReport() {
        System.out.println("Generating Combat Mission Report...");
        // Include mission achievements, casualties, resource usage
    }

    public boolean validateMinimumPersonnel() {
        return assignedPersonnel.size() >= 3;
    }
}
