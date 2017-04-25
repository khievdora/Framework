package main.business.reservation;


import main.model.FRReservationModel;

import java.util.List;

/**
 * Created by Dora on 4/24/2017.
 */
public interface IReservation {
    public int saveReservation(FRReservationModel reservationModel);
    public int updateReservation(FRReservationModel reservationModel);
    public List<Reservation> getAllReservation();
    public Reservation getReservatinById(int idReservation);
    public int deleteAllReservation();
    public int deleteReservationById(int idReservation);
}

