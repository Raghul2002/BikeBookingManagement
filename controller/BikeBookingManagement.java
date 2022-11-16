package bbm.controller;

import bbm.model.Database;
import bbm.model.account.*;
import bbm.model.account.OwnerModel;
import bbm.model.bike.EBikeModel;
import bbm.model.bike.MBikeModel;

import java.util.*;

public class BikeBookingManagement {
    static {
        System.out.println("Bike Booking Management");
        Database db = Database.getInstance();
        OwnerModel.addOwner(AccountModel.builder().setUserName("owner").setPassword("t|sjw").setEmailId("teddy@gmail.com").setFirstName("Teddy").setPhoneNo(834572345).build());
        OwnerModel.addCustomer(CustomerModel.builder().setUserName("customer").setPassword("hzxytrjw").setEmailId("spidy@gmail.com").setFirstName("Vicky").setPhoneNo(839453262).build());
        ManagerModel manager = ManagerModel.builder().setUserName("manager").setPassword("rfsfljw").setEmailId("mandy@gmail.com").setFirstName("Mandy").setPhoneNo(999453264).build();
        db.addManager(manager);
        db.addSalesExecutive(SalesExecutiveModel.builder().setUserName("se").setPassword("xj").setEmailId("sandy@gmail.com").setFirstName("Sandy").setPhoneNo(932432364).build());
        db.addMBike(MBikeModel.builder().setBikeModel("FZS").setPrice(142000).setTopSpeed(110).setBodyType("Sports Bike").setEngineType("4-Stroke,2-Value").setDisplacement("149 cc").setMileage(45).setMaxTorque(133).setNoOfCylinders(1).setCoolingSystem("Air Cooled").setGearBox("5 Speed").setInstrumentConsole("Digital").setSeatType("Single").build(), manager);
        db.addMBike(MBikeModel.builder().setBikeModel("Dio").setPrice(110000).setTopSpeed(90).setBodyType("Commercial Bike").setEngineType("4-Stroke,2-Value").setDisplacement("90 cc").setMaxTorque(100).setMileage(55).setNoOfCylinders(1).setCoolingSystem("Air Cooled").setGearBox("Automatic").setInstrumentConsole("Analog").setSeatType("Single").build(), manager);
        db.addMBike(MBikeModel.builder().setBikeModel("MT-15").setPrice(200000).setTopSpeed(140).setBodyType("Sports Bike").setEngineType("4-Stroke,2-Value").setDisplacement("150 cc").setMileage(40).setMaxTorque(140).setNoOfCylinders(1).setCoolingSystem("Liquid Cooled").setGearBox("6 Speed").setInstrumentConsole("Digital").setSeatType("Single").build(), manager);
        db.addEBike(EBikeModel.builder().setBikeModel("RV400").setPrice(125000).setTopSpeed(100).setBodyType("Electric Bike").setMaxTorque(170).setInstrumentConsole("Digital").setSeatType("Single").setRangeSport(80).setRangeNormal(100).setRangeEco(150).build(), manager);
        db.addEBike(EBikeModel.builder().setBikeModel("RV200").setPrice(100000).setTopSpeed(90).setBodyType("Electric Bike").setMaxTorque(160).setInstrumentConsole("Digital").setSeatType("Split").setRangeSport(70).setRangeNormal(90).setRangeEco(120).build(), manager);
        db.addEBike(EBikeModel.builder().setBikeModel("RV100").setPrice(90000).setTopSpeed(80).setBodyType("Electric Bike").setMaxTorque(150).setInstrumentConsole("Digital").setSeatType("Single").setRangeSport(60).setRangeNormal(80).setRangeEco(110).build(), manager);
    }


    private void mainLoop() {
        try {
            InstanceGetter instanceGetter = InstanceGetter.receiveInstance();
            Scanner sc = instanceGetter.getScannerInstance();
            System.out.println("1.Owner\n2.Manager\n3.Sales Executive\n4.Customer\n5.Exit Console");
            System.out.println("Enter number :");
            switch (sc.nextLine()) {
                case "1":
                    instanceGetter.getOwnerController().ownerPortal();
                    break;
                case "2":
                    instanceGetter.getManagerController().managerPortal();
                    break;
                case "3":
                    instanceGetter.getSalesExecutiveController().salesExecutivePortal();
                    break;
                case "4":
                    instanceGetter.getCustomerController().customerPortal();
                    break;
                case "5":
                    System.out.println("Console Closing !!!");
                    return;
                default:
                    System.out.println("Enter valid Number");
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        mainLoop();
    }

    public static void main(String[] args) {
        BikeBookingManagement bikeBookingManagement = new BikeBookingManagement();
        try {
            bikeBookingManagement.mainLoop();
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    }
}