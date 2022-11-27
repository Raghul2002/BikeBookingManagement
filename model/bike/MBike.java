package bbm.model.bike;

public class MBike extends Bike {
    private final int mileage, noOfCylinders;
    private final String engineType, displacement, coolingSystem, fuelSupply, gearBox;

    public MBike(Builder builder) {
        super(builder);
        this.mileage = builder.mileage;
        this.noOfCylinders = builder.noOfCylinders;
        this.engineType = builder.engineType;
        this.displacement = builder.displacement;
        this.coolingSystem = builder.coolingSystem;
        this.fuelSupply = builder.fuelSupply;
        this.gearBox = builder.gearBox;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Bike.Builder<Builder> {
        private int mileage, noOfCylinders;
        private String engineType, displacement, coolingSystem, fuelSupply, gearBox;

        Builder() {}

        public Builder setMileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        public Builder setNoOfCylinders(int noOfCylinders) {
            this.noOfCylinders = noOfCylinders;
            return this;
        }

        public Builder setEngineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        public Builder setDisplacement(String displacement) {
            this.displacement = displacement;
            return this;
        }

        public Builder setCoolingSystem(String coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }

        public Builder setFuelSupply(String fuelSupply) {
            this.fuelSupply = fuelSupply;
            return this;
        }

        public Builder setGearBox(String gearBox) {
            this.gearBox = gearBox;
            return this;
        }

        public MBike build() {
            return new MBike(this);
        }
    }

    public int getMileage() {
        return mileage;
    }

    public int getNoOfCylinders() {
        return noOfCylinders;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getCoolingSystem() {
        return coolingSystem;
    }

    public String getFuelSupply() {
        return fuelSupply;
    }

    public String getGearBox() {
        return gearBox;
    }

}
