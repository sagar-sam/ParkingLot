import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * Driver class where the execution of program starts
 *
 */
class Solution {
	public static void main(String[] args) throws InvalidInputException {
		try {
			File myObj = new File(args[0]);
			Scanner reader = new Scanner(myObj);
			ParkingLot parkingLot = null;
			while (reader.hasNextLine()) {
				String input = reader.nextLine();
				String[] splitedInput = input.split(" ");
				switch (splitedInput[Constants.UNIT_ZERO]) {
					case Constants.CREATE_PARKING_LOT:
						int size = Utils.convertStringToInt(splitedInput[Constants.UNIT_ONE]);
						parkingLot = new ParkingLot(size);
						System.out.println("Created parking of " + size + " slots");
						break;
					case Constants.PARK:
						String vehicleNumber = splitedInput[Constants.UNIT_ONE];
						int slot = parkingLot.parkVehicle(
								vehicleNumber,
								Utils.convertStringToInt(splitedInput[Constants.UNIT_THREE]));
						if(slot == Constants.MINUS_ONE)
							System.out.println("No empty slot left");
						else
							System.out.println("Car with vehicle registration number " + vehicleNumber +
								" has been parked at slot number " + slot);
						break;
					case Constants.LEAVE:
						final Vehicle leavingVehicle = parkingLot
								.departVehicle(Utils.convertStringToInt(splitedInput[Constants.UNIT_ONE]));
						if(leavingVehicle == null)
							System.out.println("Slot already vacant");
						else
							System.out.println("Slot number " + leavingVehicle.getSlotNumber() +
									" vacated, the car with vehicle registration number " + leavingVehicle.getVehicleNumber() +
									" left the space, the driver of the car was of age " + leavingVehicle.getDriverAge());
						break;
					case Constants.SLOT_NUMBERS_FOR_DRIVER_OF_AGE:
						System.out.println(parkingLot
								.getSlotNumbersforGivenDriverAge(
										Utils.convertStringToInt(splitedInput[Constants.UNIT_ONE])));
						break;
					case Constants.SLOT_NUMBER_FOR_CAR_WITH_NUMBER:
						int slotNumber = parkingLot.getSlotNumberForVehicleNumber(splitedInput[Constants.UNIT_ONE]);
						if(slotNumber == Constants.MINUS_ONE) {
							System.out.println("The car with the given number is not present in the parking lot");
						}
						else {
							System.out.println(slotNumber);
						}
						break;
					case Constants.VEHICLE_REGISTRATION_NUMBER_FOR_DRIVER_OF_AGE:
						System.out.println(parkingLot
								.getVehicleRegistrationNumbersByDriverAge(
										Utils.convertStringToInt(splitedInput[Constants.UNIT_ONE])));
						break;
					default:

				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error while reading input file.");
			e.printStackTrace();
		}
	}
}
