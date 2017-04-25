package main.dbsub;

import main.model.FRReservationModel;

import java.util.List;

/**
 * Created by gebre on 4/21/2017.
 */
public interface IReservation {
    public int saveReservation(FRReservationModel reservation);
    public int updateReservation(FRReservationModel reservation);
    public List<FRReservationModel> getAllReservation();
    public FRReservationModel getReservatinById(int idReservation);
    public int deleteAllReservation();
    public int deleteReservationById(int idReservation);
}
