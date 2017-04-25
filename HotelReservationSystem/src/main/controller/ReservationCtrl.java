package main.controller;

/**
 * Created by Gize on 4/20/2017.
 */

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.ReservationSub.command.ReservationSubSystemOperations;
import main.Shared.UrlLoader;
import main.dbconnection.DataAccessFacade;
import main.dbsub.GuestImpl;
import main.dbsub.RoomImpl;
import main.dbsub.*;
import main.model.*;
import main.model.Guest;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class ReservationCtrl implements Initializable {
    @FXML
    private javafx.scene.control.TableView homeTableView;

    @FXML
    private TableColumn<FRReservationModel, String> code;
    @FXML
    private TableColumn<FRReservationModel, String> firstName;
    @FXML
    private TableColumn<FRReservationModel, String> lastName;
    @FXML
    private TableColumn<FRReservationModel, Date> checkInDate;
    @FXML
    private TableColumn<FRReservationModel, Date> bookedDate;
    @FXML
    private TableColumn<FRReservationModel, Date> checkOutDate;
    @FXML
    private TableColumn<FRReservationModel, String> status;
    @FXML
    private ComboBox comboGuest;
    @FXML
    private ComboBox comboSearch;
    @FXML
    private ComboBox comboRoom;
    @FXML
    private ComboBox comboStatus;
    @FXML
    private DatePicker dpCheckIn;
    @FXML
    private DatePicker dpCheckOut;
    @FXML
    private DatePicker dpBooked;
    @FXML
    private TextField txtCode;

    private DBService dbService;

    public ReservationCtrl() {
        this.dbService = new DBFacadeImpl();
    }

    public void initialize(ActionEvent actionEvent) {


    }

    List<FRReservationModel> regList = null;

    private List<FRReservationModel> parseReservationList() {

        regList = this.dbService.getAllReservation();
        List<FRReservationModel> modifiedList = new ArrayList<>();

        for (FRReservationModel reg : regList) {

            int code = reg.getCode();
            FRProductModel room = reg.getRoom();
            Guest guest = (Guest)reg.getGuest();
            Date checkIn = reg.getCheckInDate();
            Date booked = reg.getBookedDate();
            Date checkOut = reg.getCheckOut();
            String status = reg.getRegistrationStatus();
            FRReservationModel acc = new Reservation(code, checkIn, booked, checkOut, guest, room, status);
            modifiedList.add(acc);
        }
        final ObservableList<FRReservationModel> list = FXCollections.observableArrayList();
        list.addAll(modifiedList);
        return list;
    }

    private String getRoom(String sql, String value) {
        DataAccessFacade facade = new DataAccessFacade();
        final ObservableList<FRReservationModel> obserList;
        facade.openConnection();
        List<String> rooms = new ArrayList<>();
        ResultSet result = facade.executeQuery(sql, value);
        try {
            while (result.next()) {
                rooms.add(result.getString("roomNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rooms.size() > 0) {
            return rooms.get(0);
        }
        return null;
    }

    private String getGuest(String value) {
        main.model.Guest guest = (Guest) new GuestImpl().getGuestById(Integer.parseInt(value));
        if (guest != null) {
            return guest.getfName();
        } else {
            return null;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        code = new TableColumn("Id");
        firstName = new TableColumn("FRProductModel");
        lastName = new TableColumn("Guest");
        checkInDate = new TableColumn("CheckIn Date");
        bookedDate = new TableColumn("Booked Date");
        checkOutDate = new TableColumn("Check Out Date");
        status = new TableColumn("Status");

        code.setCellValueFactory(new PropertyValueFactory<>("code"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("room"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("guest"));
        checkInDate.setCellValueFactory(new PropertyValueFactory<>("checkInDate"));
        bookedDate.setCellValueFactory(new PropertyValueFactory<>("bookedDate"));
        checkOutDate.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        status.setCellValueFactory(new PropertyValueFactory<>("registrationStatus"));

        homeTableView.getItems().setAll(parseReservationList());
        homeTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        // homeTableView.getColumns().remove(0);
        // homeTableView.getColumns().remove(0);

        homeTableView.getColumns().addAll(code, firstName, lastName, checkInDate, bookedDate, checkOutDate, status);
        comboRoomlist();
        comboGuestlist();
        comboStatusList();
        dpBooked.setValue(LocalDate.now());
        dpCheckIn.setValue(LocalDate.now());
        dpCheckOut.setValue(LocalDate.now());
    }

    public void refreshHomeTableView() {
        homeTableView.refresh();
        homeTableView.setItems(null);
        regList = null;
        homeTableView.setItems((ObservableList) parseReservationList());
    }

    List<FRProductModel> allRooms = null;
    List<FRCustomerModel> allGuests = null;

    public void comboRoomlist() {

        List<FRProductModel> guests = new RoomImpl().getAllRoom();
        allRooms = new ArrayList<>();
        allRooms = guests;
        List<Integer> rooms = guests.stream().map(rm -> rm.getRoomNumber()).collect(Collectors.toList());
        ObservableList<Integer> data2 = FXCollections.observableArrayList();

        for (int id : rooms) {
            data2.add(id);

        }
        comboRoom.setItems(null);
        comboRoom.setItems(data2);


    }

    public void comboGuestlist() {


        List<FRCustomerModel> guests = new GuestImpl().getAllGuest();
        allGuests = guests;
        List<String> roomNums = guests.stream().map(rm -> rm.getfName()).collect(Collectors.toList());

        ObservableList<String> data2 = FXCollections.observableArrayList();

        for (String id : roomNums) {
            data2.add(id);

        }
        comboGuest.setItems(null);
        comboGuest.setItems(data2);
        comboSearch.setItems(null);
        comboSearch.setItems(data2);
        comboSearch.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
                if (t1 != null) {
                    // ObservableList combox3 = FXCollections.observableArrayList((List) combox3Map.get(t1));

                }
            }
        });

    }

    public void comboStatusList() {
        ObservableList<String> options = FXCollections.observableArrayList(

                "CHECKIN", "CONFIRMED", "WAITING");

        comboStatus.setItems(options);
        comboStatus.getSelectionModel().selectFirst();
    }

    public void saveNew() {

        String code = txtCode.getText().trim();

        FRCustomerModel guest = this.dbService.getGuestById(1);
        FRProductModel room = this.dbService.getRoomById(1);
        Date checkIN = Date.valueOf(dpCheckIn.getValue());
        Date booked = Date.valueOf(dpCheckIn.getValue());
        Date checkOut = Date.valueOf(dpCheckIn.getValue());
        String status = (comboStatus.getValue().toString());
        FRReservationModel resObj = new Reservation(Integer.parseInt(code), checkIN, checkOut, booked, guest, room, status);
        save(resObj);

    }

    public void save(FRReservationModel res) {
        try {
            ReservationSubSystemOperations impl = new ReservationSubSystemOperations();
            boolean isSaved = impl.addReservation(res);
            if (isSaved) {
                JOptionPane.showMessageDialog(null, "Reserved Successfully.!");
            } else {
                JOptionPane.showMessageDialog(null, "There was an error in saving!");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "There was an error in saving!");
            // e.printStackTrace();
        }
    }

    public void makeValidation() {

    }

    public void provideQuarantee() {
        System.out.println("Please provide a quarantine before reserving.");
        return;
    }

    public void checkOut() {
        FRReservationModel person = (FRReservationModel) homeTableView.getSelectionModel().getSelectedItem();
        if (person != null) {
            if (person.getRegistrationStatus().equals("CHECKIN")) {
                Payment payment = new Payment();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(UrlLoader.loadView("Payment.fxml")));
                Stage stage = new Stage();
                try {
                    Parent root = loader.load();
                    stage.setTitle("Payment Form");
                    stage.setScene(new Scene(root));
                    stage.show();

                    // this.window.hide();admin
                } catch (IOException e) {
                    e.printStackTrace();
                }
                person.setRegistrationStatus("CheckedOut");
                //update reservation here

                JOptionPane.showMessageDialog(null, "Successfully check out!");
            } else {
                JOptionPane.showMessageDialog(null, "You can not check out un checked In reservation!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please first select the row to check out!");
        }

    }

    public void cancelReservation() {
        FRReservationModel person = (FRReservationModel) homeTableView.getSelectionModel().getSelectedItem();
        if (person != null) {
            if (person.getRegistrationStatus() != "CANCELLED") {
               // Guest gu = person.getGuest();
               // FRProductModel rm = person.getRoom();
               // person.setGuest((Guest) allGuests.stream().filter(r -> r.getfName().equals(gu.getfName())));
              //  person.setRoom((FRProductModel) allRooms.stream().filter(r -> r.getRoomNumber() == rm.getRoomNumber()));
                person.setRegistrationStatus("CANCELLED");
                //update the registration here
                try {
                    Boolean isUpdated = new ReservationSubSystemOperations().editReservation(person);

                    if (isUpdated) {
                        JOptionPane.showMessageDialog(null, "FRReservationModel cancelled successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "There is an error in cancelling this reservation!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                JOptionPane.showMessageDialog(null, "This reservation is already cancelled!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please first select the row to cancel!");
        }
    }

    public void deleteReservation() {
        FRReservationModel reservation = (FRReservationModel) homeTableView.getSelectionModel().getSelectedItem();
        if (reservation != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Confirmation");
            alert.setHeaderText("Confirmation Delete");
            alert.setContentText("Are you sure you want to delete?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                //delete the selected reservation here.


                boolean isDeleted = new ReservationSubSystemOperations().deleteReservationById(reservation);
//                if (isDeleted) {
//                boolean isDeleted = new ReservationImpl().deleteReservationById(reservation.getCode().toString());
                 //   int isDeleted = this.dbService.deleteReservationById(reservation.getCode());
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(null, "Successfully Deleted!");

                    } else {
                        JOptionPane.showMessageDialog(null, "There is an error in deleting the reservation!");
                    }
                } else {
                    // ... user chose CANCEL or closed the dialog
                }


            } else {
                JOptionPane.showMessageDialog(null, "Please first select the row to delete!");
            }
        }

    }

