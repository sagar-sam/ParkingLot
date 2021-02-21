import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * This class store the details related to a parking lot
 *
 */
public class ParkingLot {

    int parkingLotSize;
    PriorityQueue<Integer> availableSlots;
    Map<Integer, List<Vehicle>> vehicleByDriverAge;
    Map<Integer, Vehicle> slotToVehicleMap;

    /**
     * Constructor for PrakingLot class
     *
     * @param parkingLotSize
     */
    public ParkingLot(final int parkingLotSize) {
        this.parkingLotSize = parkingLotSize;
        availableSlots = new PriorityQueue<>();
        for(int i = 1;i<=parkingLotSize;i++) {
            availableSlots.add(i);
        }
        vehicleByDriverAge = new HashMap<>();
        slotToVehicleMap = new HashMap<>();
    }

    /**
     * This function parks the vehicle in the first available slot
     *
     * @param vehicleNumber
     * @param driverAge
     */
    public int parkVehicle(final String vehicleNumber, final int driverAge) {
        if(availableSlots.size() == Constants.UNIT_ZERO) {
            return -1;
        }
        int firstSlot = availableSlots.peek();
        Vehicle vehicle = new Vehicle(vehicleNumber, firstSlot, driverAge);
        availableSlots.poll();
        if(vehicleByDriverAge.get(driverAge) == null) {
            vehicleByDriverAge.put(driverAge, new ArrayList<Vehicle>());
        }
        vehicleByDriverAge.get(driverAge).add(vehicle);
        slotToVehicleMap.put(firstSlot, vehicle);
        return firstSlot;
    }

    /**
     * This function removes the vehicle present at the given slot from the parking
     *
     * @param slot
     */
    public Vehicle departVehicle(final int slot) {
        if(slotToVehicleMap.get(slot) == null) {
            return null;
        }
        availableSlots.add(slot);
        Vehicle leavingVehicle = slotToVehicleMap.get(slot);
        slotToVehicleMap.remove(slot);
        vehicleByDriverAge.get(leavingVehicle.getDriverAge()).remove(leavingVehicle);
        return leavingVehicle;
    }

    /**
     * This function returns the list of vehicle numbers which are present in the parking lot which
     * has a driver of given age.
     *
     * @param driverAge
     * @return
     */
    public List<String> getVehicleRegistrationNumbersByDriverAge(final int driverAge) {
        if(vehicleByDriverAge.get(driverAge) == null) {
            return Collections.emptyList();
        }
        return vehicleByDriverAge.get(driverAge)
                .stream()
                .map(Vehicle::getVehicleNumber)
                .collect(Collectors.toList());
    }

    /**
     * This function returns the slot number for a given vehicle number
     *
     * @param vehicleNumber
     * @return
     */
    public int getSlotNumberForVehicleNumber(final String vehicleNumber) {
        Optional<Map.Entry<Integer, Vehicle>> slotNumber = slotToVehicleMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getVehicleNumber().equals(vehicleNumber))
                .findAny();
        if(slotNumber.isPresent()) {
            return slotNumber.get().getValue().getSlotNumber();
        }
        else {
            return Constants.MINUS_ONE;
        }
    }

    /**
     * This function returns the list of slots where those vehicles are parked which has a driver of given age.
     *
     * @param driverAge
     * @return
     */
    public List<Integer> getSlotNumbersforGivenDriverAge(final int driverAge) {
        if(vehicleByDriverAge.get(driverAge) == null) {
            return Collections.emptyList();
        }
        return vehicleByDriverAge.get(driverAge)
                .stream()
                .map(Vehicle::getSlotNumber)
                .collect(Collectors.toList());
    }
}
