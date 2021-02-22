# ParkingLot
## Problem Statement
We own a parking lot that can hold up to ‘n’ cars at any given point in time. Each slot is given a number starting at one increasing with increasing distance from the entry point in steps of one. We want to create an automated ticketing system that allows our customers to use our parking lot without human intervention. 

When a car enters the parking lot, we want to have a ticket issued to the driver. The ticket issuing process includes:- 
1. Taking note of the number written on the vehicle registration plate and the age of the driver of the car. 
2. And allocating an available parking slot to the car before actually handing over a ticket to the driver (we assume that our customers are kind enough to always park in the slots allocated to them). 

The customer should be allocated a parking slot that is nearest to the entry. At the exit, the customer returns the ticket, marking the slot they were using as being available. 

Due to government regulation, the system should provide us with the ability to find out:- 
* Vehicle Registration numbers for all cars which are parked by the driver of a certain age
* Slot number in which a car with a given vehicle registration plate is parked. 
* Slot numbers of all slots where cars of drivers of a particular age are parked. 

We interact with the system via a file-based input system, i.e. it should accept a filename as an input. The file referenced by filename will contain a set of commands separated by a newline, we need to execute the commands in order and produce output.

## Solution
### Very first use case is that user should be able to park a vehicle if there is space available in the parking lot.
There is ``parkVehicle`` function present in the ``ParkingLot.java`` file which is responsible for adding a new vehicle in the ParkingLot. It will return the slot at which the requested vehicle is parked. It will return -1 if the parking is full.

Time Complexity of this operation: ``O(logn)``

### Next use case is to remove a vehicle from a particular spot
This is handled by ``departVehicle`` function present in ``ParkingLot.java`` which is responsible for removing a vehicle from a particular slot. It will return ``vehicle`` object who is removed. It will return ``null`` if the slot is already empty.

Time complexity of this operation: ``O(logn)``

### Next use case is to get vehicle registration numbers which are parked by drivers of given age
This is handled by ``getVehicleRegistrationNumbersByDriverAge`` function present in the ``ParkingLot.java`` which will return the list of all the vehicle registration numbers which are parked by driver of given age. Empty List in case there is no vehicle parked by the given driver age.

Time complexity of this operation: ``O(Number of Vehicles Parked By the Given Driver Age)``

### Next use case is to get slot number for a given vehicle number
This is handled by ``getSlotNumberForVehicleNumber`` function present in the ``ParkingLot.java`` file which is responsible for returning the slot number where a particular vehicle is parked. It will return -1 if the requested vehicle is not present in the parking lot.

Time complexity of this operation: ``O(N)``

### Next use case is to get slot nunmbers which are occupied by drivers of given age
This is handled by ``getSlotNumbersforGivenDriverAge`` function present in the ``ParkingLot.java`` file which will return the list of slot numbers which are occupied by driver of given age. Empty list in case there is no vehicle parked by given driver age.

Time complexity of this operation: ``O(Number of Vehicles Parked By the Given Driver Age)``

## Requirements
1. Make sure you have java installed.

## Compiling the project
1. Make sure you are in the project folder. e.g. if your project name is ``ParkingLot``, you should be in ``ParkingLot`` directory
2. use the script compile.sh to compile the system
```
sh compile.sh
```

## Executing the project
1. Make sure you are in the project folder. e.g. if your project name is ``ParkingLot``, you should be in ``ParkingLot`` directory
2. use the script execute.sh to execute the project and also provide input file as command line argument. The path of input file should be with respect to the project folder.
```
sh execute.sh input.txt
```

## Running Unit Tests
1. Make sure you are in the project folder. e.g. if your project name is ``ParkingLot``, you should be in ``ParkingLot`` directory
2. use the script test.sh to execute unit tests
```
sh test.sh
```
