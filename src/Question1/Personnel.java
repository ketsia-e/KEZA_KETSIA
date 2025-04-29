package Question1;

public class Personnel {
    private String personnelId;
    private String personnelName;
    private String personnelRole;
    private Mission assignedMission;

    public Personnel(String personnelId, String personnelName, String personnelRole) {
        this.personnelId = personnelId;
        this.personnelName = personnelName;
        this.personnelRole = personnelRole;
    }

    public String getPersonnelRole() {
        return personnelRole;
    }

    public void setAssignedMission(Mission mission) {
        this.assignedMission = mission;
    }

    public String getPersonnelName() {
        return personnelName;
    }
}
