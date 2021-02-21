import java.util.List;

public class ParkingLotTest {

    private static void testParkVehicle_WhenValidInput_ReturnsValidOutput() {
        ParkingLot parkingLot = new ParkingLot(TestConstants.UNIT_TWO);
        parkingLot.parkVehicle(TestConstants.TEST_VEHICLE_NUMBER, TestConstants.TEST_DRIVER_AGE);
        assert parkingLot.parkingLotSize == TestConstants.UNIT_TWO;
        assert parkingLot.availableSlots.size() == TestConstants.UNIT_ONE;
        assert parkingLot.vehicleByDriverAge.get(TestConstants.TEST_DRIVER_AGE).size() == TestConstants.UNIT_ONE;
        assert parkingLot.slotToVehicleMap.get(TestConstants.UNIT_ONE).getVehicleNumber() == TestConstants.TEST_VEHICLE_NUMBER;
    }

    private static void testParkVehicle_WhenParkingIsFull_ShouldHandle() {
        ParkingLot parkingLot = new ParkingLot(TestConstants.UNIT_ONE);
        parkingLot.parkVehicle(TestConstants.TEST_VEHICLE_NUMBER, TestConstants.TEST_DRIVER_AGE);
        parkingLot.parkVehicle(TestConstants.TEST_VEHICLE_NUMBER_TWO, TestConstants.TEST_DRIVER_AGE);
        assert parkingLot.parkingLotSize == TestConstants.UNIT_ONE;
        assert parkingLot.availableSlots.size() == TestConstants.UNIT_ZERO;
        assert parkingLot.vehicleByDriverAge.get(TestConstants.TEST_DRIVER_AGE).size() == TestConstants.UNIT_ONE;
        assert parkingLot.slotToVehicleMap.get(TestConstants.UNIT_ONE).getVehicleNumber() == TestConstants.TEST_VEHICLE_NUMBER;
    }

    private static void testDepartVehicle_WhenValiInput_ReturnsValidOutput() {
        ParkingLot parkingLot = new ParkingLot(TestConstants.UNIT_TWO);
        parkingLot.parkVehicle(TestConstants.TEST_VEHICLE_NUMBER, TestConstants.TEST_DRIVER_AGE);
        parkingLot.departVehicle(TestConstants.UNIT_ONE);
        assert parkingLot.parkingLotSize == TestConstants.UNIT_TWO;
        assert parkingLot.availableSlots.size() == TestConstants.UNIT_TWO;
        assert parkingLot.vehicleByDriverAge.get(TestConstants.TEST_DRIVER_AGE).size() == TestConstants.UNIT_ZERO;
        assert parkingLot.slotToVehicleMap.size() == TestConstants.UNIT_ZERO;
    }

    private static void testDepartVehicle_WhenSlotIsEmpty_ShouldHandle() {
        ParkingLot parkingLot = new ParkingLot(TestConstants.UNIT_TWO);
        parkingLot.departVehicle(TestConstants.UNIT_ONE);
        assert parkingLot.parkingLotSize == TestConstants.UNIT_TWO;
        assert parkingLot.availableSlots.size() == TestConstants.UNIT_TWO;
    }

    private static void testGetVehicleRegistrationNumbersByDriverAge_WhenValidInput_ReturnsValidOutput() {
        ParkingLot parkingLot = new ParkingLot(TestConstants.UNIT_TWO);
        parkingLot.parkVehicle(TestConstants.TEST_VEHICLE_NUMBER, TestConstants.TEST_DRIVER_AGE);
        List<String> vehicleNumbers = parkingLot.getVehicleRegistrationNumbersByDriverAge(TestConstants.TEST_DRIVER_AGE);
        assert vehicleNumbers.size() == TestConstants.UNIT_ONE;
        assert vehicleNumbers.get(TestConstants.UNIT_ZERO) == TestConstants.TEST_VEHICLE_NUMBER;
    }

    private static void testGetVehicleRegistrationNumbersByDriverAge_WhenDriverAgeIsNotPresent_ShouldHandle() {
        ParkingLot parkingLot = new ParkingLot(TestConstants.UNIT_TWO);
        List<String> vehicleNumber = parkingLot.getVehicleRegistrationNumbersByDriverAge(TestConstants.TEST_DRIVER_AGE);
        assert vehicleNumber.size() == TestConstants.UNIT_ZERO;
    }

    private static void testGetSlotNumberForVehicleNumber_WhenValidInput_ReturnsValidOutput() {
        ParkingLot parkingLot = new ParkingLot(TestConstants.UNIT_TWO);
        parkingLot.parkVehicle(TestConstants.TEST_VEHICLE_NUMBER, TestConstants.TEST_DRIVER_AGE);
        int slotNumber = parkingLot.getSlotNumberForVehicleNumber(TestConstants.TEST_VEHICLE_NUMBER);
        assert slotNumber == TestConstants.UNIT_ONE;
    }

    private static void testGetSlotNumberForVehicleNumber_WhenInvalidVehicleNumber_shouldHandle() {
        ParkingLot parkingLot = new ParkingLot(TestConstants.UNIT_TWO);
        int slotNumber = parkingLot.getSlotNumberForVehicleNumber(TestConstants.TEST_VEHICLE_NUMBER);
        assert slotNumber == TestConstants.MINUS_ONE;
    }

    private static void testGetSlotNumbersforGivenDriverAge_WhenValidInput_ReturnsValidOutput() {
        ParkingLot parkingLot = new ParkingLot(TestConstants.UNIT_TWO);
        parkingLot.parkVehicle(TestConstants.TEST_VEHICLE_NUMBER, TestConstants.TEST_DRIVER_AGE);
        List<Integer> slotNumbers = parkingLot.getSlotNumbersforGivenDriverAge(TestConstants.TEST_DRIVER_AGE);
        assert slotNumbers.size() == TestConstants.UNIT_ONE;
        assert slotNumbers.get(TestConstants.UNIT_ZERO) == TestConstants.UNIT_ONE;
    }

    private static void testGetSlotNumbersforGivenDriverAge_WhenDriverAgeIsNotPresent_ShouldHandle() {
        ParkingLot parkingLot = new ParkingLot(TestConstants.UNIT_TWO);
        List<Integer> slotNumbers = parkingLot.getSlotNumbersforGivenDriverAge(TestConstants.TEST_DRIVER_AGE);
        assert slotNumbers.size() == TestConstants.UNIT_ZERO;
    }

    public static void main(String[] args) {
        testParkVehicle_WhenValidInput_ReturnsValidOutput();
        System.out.println("testParkVehicle_WhenValidInput_ReturnsValidOutput successfully executed");
        testParkVehicle_WhenParkingIsFull_ShouldHandle();
        System.out.println("testParkVehicle_WhenParkingIsFull_ShouldHandle successfully executed");
        testDepartVehicle_WhenValiInput_ReturnsValidOutput();
        System.out.println("testDepartVehicle_WhenValiInput_ReturnsValidOutput successfully executed");
        testDepartVehicle_WhenSlotIsEmpty_ShouldHandle();
        System.out.println("testDepartVehicle_WhenSlotIsEmpty_ShouldHandle successfully executed");
        testGetVehicleRegistrationNumbersByDriverAge_WhenValidInput_ReturnsValidOutput();
        System.out.println("testGetVehicleRegistrationNumbersByDriverAge_WhenValidInput_ReturnsValidOutput successfully executed");
        testGetVehicleRegistrationNumbersByDriverAge_WhenDriverAgeIsNotPresent_ShouldHandle();
        System.out.println("testGetVehicleRegistrationNumbersByDriverAge_WhenDriverAgeIsNotPresent_ShouldHandle successfully executed");
        testGetSlotNumberForVehicleNumber_WhenValidInput_ReturnsValidOutput();
        System.out.println("testGetSlotNumberForVehicleNumber_WhenValidInput_ReturnsValidOutput successfully executed");
        testGetSlotNumberForVehicleNumber_WhenInvalidVehicleNumber_shouldHandle();
        System.out.println("testGetSlotNumberForVehicleNumber_WhenInvalidVehicleNumber_shouldHandle successfully executed");
        testGetSlotNumbersforGivenDriverAge_WhenValidInput_ReturnsValidOutput();
        System.out.println("testGetSlotNumbersforGivenDriverAge_WhenValidInput_ReturnsValidOutput successfully executed");
        testGetSlotNumbersforGivenDriverAge_WhenDriverAgeIsNotPresent_ShouldHandle();
        System.out.println("testGetSlotNumbersforGivenDriverAge_WhenDriverAgeIsNotPresent_ShouldHandle successfully executed");
    }
}