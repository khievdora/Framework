package main.dbsub;
import main.model.FRReservationModel;
import main.model.Reservation;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gebre on 4/21/2017.
 */
public class ReservationImpl implements IReservation {
    private IDatabase iDatabase = null;

    public ReservationImpl() {
        iDatabase = Database.getInstance();
    }
    @Override
    public int saveReservation(FRReservationModel reservation) {
        int reservationId = 0;
        try{

            String query = "INSERT INTO reservation(checkInDate, CheckOutDate, bookedDate, idGuest, idRoom,reservationStatus) " +
                    "VALUES(" +
                    "'"+reservation.getCheckInDate()+"'," +
                    "'"+reservation.getCheckOut()+"'," +
                    "'"+reservation.getBookedDate()+"'," +
                    ""+reservation.getGuest().getCode()+"," +
                    ""+reservation.getRoom().getCode()+"," +
                    "'"+reservation.getRegistrationStatus()+"')";
            reservationId = iDatabase.executeUpdate(query);
            reservation.setCode(reservationId);
            if (reservationId != 0) {
                reservation.setCode(reservationId);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }
        return reservationId;
    }

    @Override
    public int updateReservation(FRReservationModel reservation) {
        int result = 0;
        try{

            String query ="UPDATE reservation SET " +
                    "checkInDate='"+reservation.getCheckInDate()+"', " +
                    "CheckOutDate='"+reservation.getCheckOut()+"'," +
                    "bookedDate='"+reservation.getBookedDate()+"', " +
                    "idGuest="+reservation.getGuest().getCode()+"," +
                    "idRoom="+reservation.getRoom().getCode()+"," +
                    "reservationStatus= '"+reservation.getRegistrationStatus()+"'" +
                    " WHERE idReservation="+reservation.getCode()+"";
            System.out.println(query);
            result = iDatabase.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }
        return result;
    }

    @Override
    public int deleteReservationById(int idReservation) {
        int result = 0;
        try{
            String query = "DELETE FROM reservation WHERE idReservation="+idReservation;
            result = iDatabase.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }
        return result;
    }

    @Override
    public int deleteAllReservation() {
        int result = 0;
        try{
            String query = "DELETE FROM reservation";
            result = iDatabase.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }
        return result;
    }
    @Override
    public List<FRReservationModel> getAllReservation() {
        String query = "SELECT * FROM reservation";
        List<FRReservationModel> reservations = new ArrayList<>();
        try{
            ResultSet rs = iDatabase.executeQuery(query);
            while (rs.next()){
                Reservation reservation=new Reservation();
                reservation.setCode(rs.getInt("idReservation"));
                reservation.setCheckInDate(rs.getDate(2));
                reservation.setCheckOut(rs.getDate(3));
                reservation.setBookedDate(rs.getDate(4));
//                reservation.setCheckInDate(rs.getDate(2));
//                reservation.setCheckOut(rs.getDate(3));
//                reservation.setBookedDate(rs.getDate(4));
                reservation.setGuest(new GuestImpl().getGuestById(rs.getInt(5)));
                reservation.setRoom(new RoomImpl().getRoomById(rs.getInt(6)));
                reservation.setRegistrationStatus(rs.getString(7));

                reservations.add(reservation);
            }

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }
        return reservations;
    }

    @Override
    public FRReservationModel getReservatinById(int idReservation) {
        String query = "SELECT * FROM reservation WHERE idReservation="+idReservation;
        Reservation reservation=new Reservation();
        try{
            ResultSet rs = iDatabase.executeQuery(query);
            while (rs.next()){
                reservation.setCode(rs.getInt(1));
                reservation.setCheckInDate(rs.getDate(2));
                reservation.setCheckOut(rs.getDate(3));
                reservation.setBookedDate(rs.getDate(4));
                reservation.setGuest(new GuestImpl().getGuestById(rs.getInt(5)));
                reservation.setRoom(new RoomImpl().getRoomById(rs.getInt(6)));
                reservation.setRegistrationStatus(rs.getString(7));
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }
        return reservation;
    }

}
