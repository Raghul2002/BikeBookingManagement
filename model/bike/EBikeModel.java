package bbm.model.bike;

public class EBikeModel extends BikeModel {
    private final int rangeEco, rangeNormal, rangeSport, motorPower, chargeTime;

    public EBikeModel(Builder builder) {
        super(builder);
        this.rangeEco = builder.rangeEco;
        this.rangeNormal = builder.rangeNormal;
        this.rangeSport = builder.rangeSport;
        this.motorPower = builder.motorPower;
        this.chargeTime = builder.chargeTime;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BikeModel.Builder<Builder> {
        private int rangeEco, rangeNormal, rangeSport, motorPower, chargeTime;

        Builder() {
        }

        public Builder setRangeEco(int rangeEco) {
            this.rangeEco = rangeEco;
            return this;
        }

        public Builder setRangeNormal(int rangeNormal) {
            this.rangeNormal = rangeNormal;
            return this;
        }

        public Builder setRangeSport(int rangeSport) {
            this.rangeSport = rangeSport;
            return this;
        }

        public Builder setMotorPower(int motorPower) {
            this.motorPower = motorPower;
            return this;
        }

        public Builder setChargeTime(int chargeTime) {
            this.chargeTime = chargeTime;
            return this;
        }

        public EBikeModel build() {
            return new EBikeModel(this);
        }
    }

    public int getRangeEco() {
        return rangeEco;
    }

    public int getRangeNormal() {
        return rangeNormal;
    }

    public int getRangeSport() {
        return rangeSport;
    }

    public int getMotorPower() {
        return motorPower;
    }

    public int getChargeTime() {
        return chargeTime;
    }

}
