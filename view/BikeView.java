package bbm.view;

import bbm.model.account.*;
import bbm.model.account.OwnerModel;
import bbm.model.bike.BikeStatus;
import bbm.model.bike.EBikeModel;
import bbm.model.bike.MBikeModel;

import java.util.List;

public class BikeView {
    public void mBikeHeader() {
        mBikeDivider();
        System.out.printf("|%7s |%15s |%15s |%20s |%15s |%15s |%15s |%15s |%20s |%15s |%15s |%15s |%16s |%15s |%15s |%15s |%15s |%15s |\n", "Bike Id", "BIke Model", "TopSpeed", "Ground Clearance", " WheelBase ", "MaxTorque", "Price", "Body Type", "Instrument_Console", "Seat Type", "mileage", "noOfCylinders", "Engine Type", "Displacement", "Cooling System", "Fuel Supply", "Gear Box", "Availability");
        mBikeDivider();
    }

    public void eBikeHeader() {
        eBikeDivider();
        System.out.printf("|%7s |%15s |%15s |%20s |%15s |%15s |%15s |%15s |%20s |%15s |%15s |%15s |%15s |%15s |%15s |%15s |\n", "Bike Id", "BIke Model", "TopSpeed", "Ground_Clearance", " WheelBase ", "MaxTorque", "Price", "Body Type", "Instrument_Console", "Seat Type", "rangeEco", "rangeNormal", "rangeSport", "motorPower", "chargeTime", "Availability");
        eBikeDivider();
    }

    public void mBikeDivider() {
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

    public void eBikeDivider() {
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

    public void printMBike(MBikeModel mBike) {
        System.out.printf("|%7d |%15s |%15d |%20s |%15d |%15d |%15d |%15s |%20s |%15s |%15d |%15d |%16s |%15s |%15s |%15s |%15s |%15s |\n", mBike.getBikeId(), mBike.getBikeModel(), mBike.getTopSpeed(), mBike.getGroundClearance(), mBike.getWheelBase(), mBike.getMaxTorque(), mBike.getPrice(), mBike.getBodyType(), mBike.getInstrumentConsole(), mBike.getSeatType(), mBike.getMileage(), mBike.getNoOfCylinders(), mBike.getEngineType(), mBike.getDisplacement(), mBike.getCoolingSystem(), mBike.getFuelSupply(), mBike.getGearBox(), mBike.getAvailabilityStatus());
    }

    public void printEBike(EBikeModel eBike) {
        System.out.printf("|%7d |%15s |%15d |%20s |%15d |%15d |%15d |%15s |%20s |%15s |%15d |%15d |%15d |%15d |%15s |%15s |\n", eBike.getBikeId(), eBike.getBikeModel(), eBike.getTopSpeed(), eBike.getGroundClearance(), eBike.getWheelBase(), eBike.getMaxTorque(), eBike.getPrice(), eBike.getBodyType(), eBike.getInstrumentConsole(), eBike.getSeatType(), eBike.getRangeEco(), eBike.getRangeNormal(), eBike.getRangeSport(), eBike.getMotorPower(), eBike.getChargeTime(), eBike.getAvailabilityStatus());
    }

    public void showBikeDetails() {
        boolean flag = false;
        List<MBikeModel> mBikeList = OwnerModel.getMBikeList();
        List<EBikeModel> eBikeList = OwnerModel.getEBikeList();
        if (!mBikeList.isEmpty()) {
            System.out.println("Bike Details :-");
            System.out.println("Mechanical Bike :");
            mBikeHeader();
            for (MBikeModel i : mBikeList) {
                if (i.getAvailabilityStatus().equals(BikeStatus.AVAILABLE.toString()))
                    printMBike(i);
            }
            mBikeDivider();
            flag = true;
        }
        if (!eBikeList.isEmpty()) {
            System.out.println("\nElectric Bike :");
            eBikeHeader();
            for (EBikeModel i : eBikeList) {
                if (i.getAvailabilityStatus().equals(BikeStatus.AVAILABLE.toString()))
                    printEBike(i);
            }
            eBikeDivider();
            flag = true;
        }
        if (!flag)
            System.out.println("Sorry Currently no bikes available");

    }

    public void showReservedBikeDetails(AccountModel account) {
        if (account instanceof OwnerModel || account instanceof SalesExecutiveModel) {
            boolean flag = false;
            List<MBikeModel> mBikeList = OwnerModel.getMBikeList();
            List<EBikeModel> eBikeList = OwnerModel.getEBikeList();
            if (!mBikeList.isEmpty()) {
                System.out.println("Mechanical Bike :");
                mBikeHeader();
                for (MBikeModel i : mBikeList) {
                    if (i.getAvailabilityStatus().equals(BikeStatus.RESERVED.toString()))
                        printMBike(i);
                }
                mBikeDivider();
                flag = true;
            }
            if (!eBikeList.isEmpty()) {
                System.out.println("\nElectric Bike :");
                eBikeHeader();
                for (EBikeModel i : eBikeList) {
                    if (i.getAvailabilityStatus().equals(BikeStatus.RESERVED.toString()))
                        printEBike(i);
                }
                eBikeDivider();
                flag = true;
            }
            if (!flag)
                System.out.println("Sorry Currently no bikes available");
        }
    }

    public void showSoldBikeDetails(OwnerModel account) {
        boolean flag = false;
        List<MBikeModel> mBikeList = OwnerModel.getMBikeList();
        List<EBikeModel> eBikeList = OwnerModel.getEBikeList();
        if (!mBikeList.isEmpty()) {
            System.out.println("Mechanical Bike :");
            mBikeHeader();
            for (MBikeModel i : mBikeList) {
                if (i.getAvailabilityStatus().equals(BikeStatus.SOLD.toString()))
                    printMBike(i);
            }
            mBikeDivider();
            flag = true;
        }
        if (!eBikeList.isEmpty()) {
            System.out.println("\nElectric Bike :");
            eBikeHeader();
            for (EBikeModel i : eBikeList) {
                if (i.getAvailabilityStatus().equals(BikeStatus.SOLD.toString()))
                    printEBike(i);
            }
            eBikeDivider();
            flag = true;
        }
        if (!flag)
            System.out.println("Sorry Currently no bikes available");
    }

}