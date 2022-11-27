package bbm.model.bike;

public class Bike {
    private static int id = 1;
    private final int bikeId = id;
    private int topSpeed,groundClearance,wheelBase,maxTorque,price ;
    private String bikeModel,bodyType,instrumentConsole,seatType,availabilityStatus;
    Bike(Builder builder) {
        id++;
        this.bikeModel = builder.bikeModel;
        this.topSpeed = builder.topSpeed;
        this.groundClearance = builder.groundClearance;
        this.wheelBase = builder.wheelBase;
        this.maxTorque =builder. maxTorque;
        this.price = builder.price;
        this.bodyType = builder.bodyType;
        this.instrumentConsole = builder.instrumentConsole;
        this.seatType = builder.seatType;
        this.availabilityStatus = builder.availabilityStatus;
    }
    public static Builder builder() {
        return new Builder();
    }
    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
    public static class Builder<b extends Builder> {

        private int topSpeed,groundClearance,wheelBase,maxTorque,price ;
        private String bikeModel,bodyType,instrumentConsole,seatType,availabilityStatus = String.valueOf(BikeStatus.AVAILABLE);
        Builder() {}

        public b setTopSpeed(int id)
        {
            this.topSpeed = id;
            return (b) this;
        }
        public b setGroundClearance(int groundClearance)
        {
            this.groundClearance = groundClearance;
            return(b) this;
        }
        public b setWheelBase(int wheelBase)
        {
            this.wheelBase = wheelBase;
            return(b) this;
        }
        public b setMaxTorque(int maxTorque)
        {
            this.maxTorque = maxTorque;
            return(b) this;
        }
        public b setPrice(int price)
        {
            this.price = price;
            return(b) this;
        }
        public b setBikeModel(String bikeModel)
        {
            this.bikeModel = bikeModel;
            return(b) this;
        }
        public b setBodyType(String bodyType)
        {
            this.bodyType = bodyType;
            return(b) this;
        }
        public b setInstrumentConsole(String instrumentConsole)
        {
            this.instrumentConsole = instrumentConsole;
            return(b) this;
        }
        public b setSeatType(String seatType)
        {
            this.seatType = seatType;
            return(b) this;
        }
    }
    //Getter
    public int getTopSpeed() {
        return topSpeed;
    }

    public int getGroundClearance() {
        return groundClearance;
    }

    public int getWheelBase() {
        return wheelBase;
    }

    public int getMaxTorque() {
        return maxTorque;
    }

    public int getPrice() {
        return price;
    }
    public int getBikeId() {
        return bikeId;
    }
    public String getBikeModel() {
        return bikeModel;
    }
    public String getBodyType() {
        return bodyType;
    }
    public String getInstrumentConsole() {
        return instrumentConsole;
    }
    public String getSeatType() {
        return seatType;
    }
    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public static void setId(int id) {
        Bike.id = id;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setGroundClearance(int groundClearance) {
        this.groundClearance = groundClearance;
    }

    public void setWheelBase(int wheelBase) {
        this.wheelBase = wheelBase;
    }

    public void setMaxTorque(int maxTorque) {
        this.maxTorque = maxTorque;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public void setInstrumentConsole(String instrumentConsole) {
        this.instrumentConsole = instrumentConsole;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }
}

