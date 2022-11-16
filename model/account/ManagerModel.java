package bbm.model.account;

import bbm.model.Database;
import bbm.model.bike.EBikeModel;
import bbm.model.bike.MBikeModel;

public class ManagerModel extends AccountModel {
    private static int mId = 1;
    private final int managerId = mId;

    public ManagerModel(Builder builder) {
        super(builder);
        mId++;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends AccountModel.Builder<Builder> {
        Builder() {
        }

        public ManagerModel build() {
            return new ManagerModel(this);
        }
    }

    public int getManagerId() {
        return managerId;
    }
    Database db = Database.getInstance();

    public void addMBike(MBikeModel mBike, ManagerModel account) {
            db.addMBike(mBike,account);
    }

    public void addEBike(EBikeModel eBike, ManagerModel account) {
            db.addEBike(eBike,account);
    }

    public boolean removeMBike(int id, ManagerModel account) {
            return db.removeMBike(id,account);
    }

    public boolean removeEBike(int id, ManagerModel account) {
            return db.removeEBike(id,account);
    }
}