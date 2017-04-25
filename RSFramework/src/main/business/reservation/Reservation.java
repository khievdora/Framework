package main.business.reservation;

import main.db.IDatabase;
import main.model.FRReservationModel;

import java.util.List;

/**
 * Created by Gize on 4/25/2017.
 */
public abstract class Reservation {
    protected IReservation iReservation;

    public Reservation(IReservation iReservation) {
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
            result = this.iReservation.updateReservation(reservationModel);
        } else {
            result = this.iReservation.saveReservation(reservationModel);
        }
        return result;
    }

    public int saveResrvation(FRReservationModel rModel) {
        if (!validateReservation(rModel)) {
            return 0;
        }
        return this.iReservation.saveReservation(rModel);
    }

    public int updateReservation(FRReservationModel rModel) {
        if (!validateReservation(rModel)) {
            return 0;
        }
        return this.iReservation.updateReservation(rModel);
    }

    public int deleteReservation(FRReservationModel rModel) {
        if (!validateReservation(rModel)) {
            return 0;
        }
        return this.iReservation.deleteReservationById(rModel.getCode());
    }

    protected abstract boolean validateReservation(FRReservationModel rModel);

    protected abstract void pay(FRReservationModel rModel);

    protected abstract void returnProduct();

    protected abstract void updateReservationStatus(FRReservationModel rModel);


}
