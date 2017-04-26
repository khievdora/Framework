package main.business.reservation;

import main.db.DBFacade;
import main.model.FRReservationModel;

/**
 * Created by Gize on 4/25/2017.
 */
public abstract class Reservation {
    protected DBFacade iReservation;

    public Reservation(DBFacade iReservation) {
        this.iReservation = iReservation;
    }

    public final void checkOut(FRReservationModel rModel) {
        pay(rModel);
        returnProduct();
        updateReservationStatus(rModel);
    }

    public int checkIn(FRReservationModel reservationModel) {
        int result = 0;
        if (iReservation.getReservatinById(reservationModel.getCode()) != null) {
            result = this.iReservation.updateFRReservationModel(reservationModel);
        } else {
            result = this.iReservation.saveFRReservationModel(reservationModel);
        }
        return result;
    }

    public int saveResrvation(FRReservationModel rModel) {
        if (!validateReservation(rModel)) {
            return 0;
        }
        return this.iReservation.saveFRReservationModel(rModel);
    }

    public int updateReservation(FRReservationModel rModel) {
        if (!validateReservation(rModel)) {
            return 0;
        }
        return this.iReservation.updateFRReservationModel(rModel);
    }

    public int deleteReservation(FRReservationModel rModel) {
        if (!validateReservation(rModel)) {
            return 0;
        }
        return this.iReservation.deleteFRReservationModelById(rModel.getCode());
    }

    protected abstract boolean validateReservation(FRReservationModel rModel);

    protected abstract void pay(FRReservationModel rModel);

    protected abstract void returnProduct();

    protected abstract void updateReservationStatus(FRReservationModel rModel);


}
