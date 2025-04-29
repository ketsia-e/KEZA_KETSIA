package Question1;

public class Resource {
    private String resourceId;
    private String resourceName;
    private int quantity;
    private String resourceType;

    public Resource(String resourceId, String resourceName, int quantity) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.quantity = quantity;
        this.resourceType = resourceType;
    }

    public String getResourceName() {
        return resourceName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decrementQuantity(int count) {
        this.quantity -= count;
    }
}
