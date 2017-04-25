package main.model;

import javafx.beans.property.*;

import java.sql.Date;

/**
 * Created by Gize on 4/19/2017.
 */
public class Reservation implements FRReservationModel {
    private IntegerProperty code;
    private Date checkInDate;
    private Date checkOut;
    private Date bookedDate;
    private ObjectProperty<FRCustomerModel> guest;
    private ObjectProperty<FRProductModel> room;
    private StringProperty registrationStatus;

    public Reservation() {
        this.code = new SimpleIntegerProperty();
        this.guest = new SimpleObjectProperty<>();
        this.room = new SimpleObjectProperty<>();
        this.registrationStatus = new SimpleStringProperty();
    }

    public Reservation(int code, Date checkInDate, Date bookedDate, Date checkOutDate, FRCustomerModel guest, FRProductModel room,
                       String registrationStatus) {
        this.code = new SimpleIntegerProperty(code);
        this.checkInDate = checkInDate;
        this.bookedDate = bookedDate;
        this.checkOut = checkOutDate;
        this.guest = new SimpleObjectProperty<>(guest);
        this.room = new SimpleObjectProperty<>(room);
        this.registrationStatus = new SimpleStringProperty(registrationStatus);
    }

    public int getCode() {
        return code.get();
    }

    public IntegerProperty codeProperty() {
        return code;
    }

    public void setCode(int code) {
        this.code.set(code);
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Date getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(Date bookedDate) {
        this.bookedDate = bookedDate;
    }

    public FRCustomerModel getGuest() {
        return guest.get();
    }

    @Override
    public void setGuest(FRCustomerModel FRCustomerModel) {
        this.guest.set(FRCustomerModel);
    }

    public ObjectProperty<FRCustomerModel> guestProperty() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest.set(guest);
    }

    public FRProductModel getRoom() {
        return room.get();
    }

    public ObjectProperty<FRProductModel> roomProperty() {
        return room;
    }

    public void setRoom(FRProductModel room) {
        this.room.set(room);
    }

    public String getRegistrationStatus() {
        return registrationStatus.get();
    }

    public StringProperty registrationStatusProperty() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus.set(registrationStatus);
    }
}
