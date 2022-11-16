package bbm.view;

import bbm.controller.InstanceGetter;
import bbm.model.bike.MBikeModel;
import bbm.model.bike.EBikeModel;

import java.util.Scanner;

public class BikeInputView {
    Scanner sc = InstanceGetter.receiveInstance().getScannerInstance();
    private int topSpeed,groundClearance,wheelBase,maxTorque,price;
    private String bikeModel,bodyType,instrumentConsole,seatType;
    private void getBikeDetails() {
        System.out.println("Enter Bike Model \t:");
        bikeModel = sc.next();
        System.out.println("Enter Top Speed \t:");
        topSpeed = sc.nextInt();
        System.out.println("Enter Ground Clearance \t:");
        groundClearance = sc.nextInt();
        System.out.println("Enter Wheel Base \t:");
        wheelBase = sc.nextInt();
        System.out.println("Enter Max Torque \t:");
        maxTorque = sc.nextInt();
        System.out.println("Enter Prize \t:");
        price = sc.nextInt();
        System.out.println("Enter Body Type \t:");
        bodyType = sc.next();
        System.out.println("Enter InstrumentConsole \t:");
        instrumentConsole = sc.next();
        System.out.println("Enter seatType \t:");
        seatType = sc.next();
    }
    public MBikeModel getMBikeDetails(){
        getBikeDetails();
        System.out.println("Enter Mileage \t:");
        int mileage = sc.nextInt();
        System.out.println("Enter No Of Cylinder \t:");
        int noOfCylinders = sc.nextInt();
        System.out.println("Enter Engine Capacity \t:");
        String engineType = sc.next();
        System.out.println("Enter Displacement \t:");
        String displacement = sc.next();
        System.out.println("Enter Cooling System \t:");
        String coolingSystem = sc.next();
        System.out.println("Enter Fuel Supply \t:");
        String fuelSupply = sc.next();
        System.out.println("Enter Gear Box \t:");
        String gearBox = sc.next();
        return MBikeModel.builder()
                .setBikeModel(bikeModel)
                .setTopSpeed(topSpeed)
                .setGroundClearance(groundClearance)
                .setWheelBase(wheelBase)
                .setMaxTorque(maxTorque)
                .setPrice(price)
                .setInstrumentConsole(instrumentConsole)
                .setSeatType(seatType)
                .setBodyType(bodyType)
                .setMileage(mileage)
                .setNoOfCylinders(noOfCylinders)
                .setDisplacement(displacement)
                .setFuelSupply(fuelSupply)
                .setGearBox(gearBox)
                .setCoolingSystem(coolingSystem)
                .build();
    }
    public EBikeModel getEBikeDetails(){
        getBikeDetails();
        System.out.println("Enter Range Eco \t:");
        int rangeEco = sc.nextInt();
        System.out.println("Enter Range Normal \t:");
        int rangeNormal = sc.nextInt();
        System.out.println("Enter Range Sport \t:");
        int rangeSport = sc.nextInt();
        System.out.println("Enter Motor Power \t:");
        int motorPower = sc.nextInt();
        System.out.println("Enter Charge Time \t:");
        int chargeTime = sc.nextInt();
        return EBikeModel.builder()
                .setBikeModel(bikeModel)
                .setTopSpeed(topSpeed)
                .setGroundClearance(groundClearance)
                .setWheelBase(wheelBase)
                .setMaxTorque(maxTorque)
                .setPrice(price)
                .setInstrumentConsole(instrumentConsole)
                .setSeatType(seatType)
                .setBodyType(bodyType)
                .setRangeEco(rangeEco)
                .setRangeNormal(rangeNormal)
                .setRangeSport(rangeSport)
                .setMotorPower(motorPower)
                .setChargeTime(chargeTime)
                .build();
    }

}