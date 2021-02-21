/**
 * This Class store the details of a vehicle.
 *
 */
public class Vehicle {

    /**
     * Constructor of the class vehicle
     * @param vehicleNumber
     * @param slotNumber
     * @param driverAge
     */
    public Vehicle(final String vehicleNumber, final int slotNumber, final int driverAge) {
        this.vehicleNumber = vehicleNumber;
        this.slotNumber = slotNumber;
        this.driverAge = driverAge;
    }

    /**
     * Getter method for Vehicle Number
     * @return
     */
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    /**
     * Getter method for slot number
     * @return
     */
    public int getSlotNumber() {
        return slotNumber;
    }

    /**
     * Getter method for getting Driver Info
     * @return
     */
    public int getDriverAge() {
        return driverAge;
    }

    private String vehicleNumber;

    private int slotNumber;

    private int driverAge;
}