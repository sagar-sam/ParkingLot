echo "Compiling tst/TestConstants.java"
javac tst/TestConstants.java -d classes -cp classes/
echo "Compiling tst/ParkingLotTest.java"
javac tst/ParkingLotTest.java -d classes -cp classes/
cd classes
echo "Executing Test Cases"
java -ea ParkingLotTest