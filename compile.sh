echo "Compiling src/constants/Constants.java"
javac src/constants/Constants.java -d classes -cp classes/
echo "Compiling src/model/Vehicle.java"
javac src/model/Vehicle.java -d classes -cp classes/
echo "Compiling src/exceptions/InvalidInputException.java"
javac src/exceptions/InvalidInputException.java -d classes -cp classes
echo "Compiling src/utils/Utils.java"
javac src/utils/Utils.java -d classes -cp classes
echo "Compiling src/ParkingLot.java"
javac src/ParkingLot.java -d classes -cp classes/
echo "Compiling src/Solution.java"
javac src/Solution.java -d classes -cp classes/
echo "Congratulations!! Compilation is successful"