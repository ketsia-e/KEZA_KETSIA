package Question3;

import java.util.Date;

public class IndustrialLand extends Land {
    private boolean hasEnvironmentalClearance;

    public IndustrialLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus, boolean hasEnvironmentalClearance) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
        this.hasEnvironmentalClearance = hasEnvironmentalClearance;
    }

    @Override
    public boolean validateOwnership() {
        return ownerName != null && !ownerName.trim().isEmpty();
    }

    @Override
    public boolean checkZoningCompliance() {
        return hasEnvironmentalClearance;
    }

    @Override
    public double calculateTax() {
        return sizeInAcres * 12000 * 0.03;
    }

    @Override
    public void generateLandReport() {
        System.out.println("===== INDUSTRIAL LAND REPORT ======");
        System.out.println("Land ID: " + landId);
        System.out.println("Owner: " + ownerName);
        System.out.println("Location: " + location);
        System.out.println("Size (acres): " + sizeInAcres);
        System.out.println("Environmental Clearance: " + hasEnvironmentalClearance);
        System.out.println("Tax Due: $" + calculateTax());
        System.out.println("Zoning Compliant: " + checkZoningCompliance());
        System.out.println("Ownership Valid: " + validateOwnership());
        System.out.println("Status: " + landUseStatus);
        System.out.println("===================================");
    }
}
