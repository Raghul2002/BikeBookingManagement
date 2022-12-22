package bbm.owner;

import bbm.database.Database;
import bbm.model.bike.BikeStatus;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;


public class BikeAdministrator {
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

    public void printMBike(MBike mBike) {
        System.out.printf("|%7d |%15s |%15d |%20s |%15d |%15d |%15d |%15s |%20s |%15s |%15d |%15d |%16s |%15s |%15s |%15s |%15s |%15s |\n", mBike.getBikeId(), mBike.getBikeModel(), mBike.getTopSpeed(), mBike.getGroundClearance(), mBike.getWheelBase(), mBike.getMaxTorque(), mBike.getPrice(), mBike.getBodyType(), mBike.getInstrumentConsole(), mBike.getSeatType(), mBike.getMileage(), mBike.getNoOfCylinders(), mBike.getEngineType(), mBike.getDisplacement(), mBike.getCoolingSystem(), mBike.getFuelSupply(), mBike.getGearBox(), mBike.getAvailabilityStatus());
    }

    public void printEBike(EBike eBike) {
        System.out.printf("|%7d |%15s |%15d |%20s |%15d |%15d |%15d |%15s |%20s |%15s |%15d |%15d |%15d |%15d |%15s |%15s |\n", eBike.getBikeId(), eBike.getBikeModel(), eBike.getTopSpeed(), eBike.getGroundClearance(), eBike.getWheelBase(), eBike.getMaxTorque(), eBike.getPrice(), eBike.getBodyType(), eBike.getInstrumentConsole(), eBike.getSeatType(), eBike.getRangeEco(), eBike.getRangeNormal(), eBike.getRangeSport(), eBike.getMotorPower(), eBike.getChargeTime(), eBike.getAvailabilityStatus());
    }
    Database db = Database.getInstance();
    private void showBike(String bikeStatus){
        boolean flag = false;
        List <MBike> mBikeList = db.getMBikeList();
        List <EBike> eBikeList = db.getEBikeList();
        if (!mBikeList.isEmpty()) {
            System.out.println("Mechanical Bike :");
            mBikeHeader();
            for (MBike i : mBikeList) {
                if (i.getAvailabilityStatus().equals(bikeStatus))
                    printMBike(i);
            }
            mBikeDivider();
            flag = true;
        }
        if (!eBikeList.isEmpty()) {
            System.out.println("\nElectric Bike :");
            eBikeHeader();
            for (EBike i : eBikeList) {
                if (i.getAvailabilityStatus().equals(bikeStatus))
                    printEBike(i);
            }
            eBikeDivider();
            flag = true;
        }
        if (!flag)
            System.out.println("Sorry Currently no bikes available");
    }
    public void showBike() {
        String bikeStatus = BikeStatus.AVAILABLE.toString();
        showBike(bikeStatus);
    }
    protected void showSoldBikes() {
        String bikeStatus = BikeStatus.SOLD.toString();
        showBike(bikeStatus);

    }
}
