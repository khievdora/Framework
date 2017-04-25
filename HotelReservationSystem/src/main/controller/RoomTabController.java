package main.controller;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Shared.WindowNavigation;
import main.dbsub.DBFacadeImpl;
import main.dbsub.DBService;
import main.model.FRProductModel;
import main.model.FRProductTypeModel;
import main.model.Room;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by gebre on 4/23/2017.
 */
public class RoomTabController implements Initializable, RoomRegistrationController.RoomControllerListener {
    @FXML
    private TableColumn<FRProductModel, IntegerProperty> code;
    @FXML
    private TableColumn<FRProductModel, StringProperty> roomName;
    @FXML
    private TableColumn<FRProductModel, IntegerProperty> roomNumber;
    @FXML
    private TableColumn<FRProductModel, StringProperty> roomStatus;
    @FXML
    private TableColumn<FRProductModel, IntegerProperty> floor;
    @FXML
    private TableColumn<FRProductModel, StringProperty> description;
    @FXML
    private TableColumn<FRProductModel, FRProductTypeModel> roomType;
    @FXML
    private TableColumn<FRProductModel, IntegerProperty> maxQuest;
    @FXML
    private TableColumn<FRProductModel, StringProperty> status;
    @FXML
    private TableColumn<FRProductModel, FloatProperty> price;


    @FXML
    private TableView tblVWRoom;
    private List<FRProductModel> lstRooms;

    private DBService dbService;
    private ObservableList<FRProductModel> originalRoomList = FXCollections.observableArrayList();
    private ObservableList<FRProductModel> modifiedRoomList = FXCollections.observableArrayList();





    public RoomTabController(){}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Initialize Database service
        this.dbService = new DBFacadeImpl();

        //get all room lists
        originalRoomList = FXCollections.observableArrayList(dbService.getAllRoom());

        //Initialize FRProductModel TableView
        loadRoomListIntoView();


    }

    private void loadRoomListIntoView() {
        code = new TableColumn<>("Id");
        roomName = new TableColumn<>("FRProductModel Name");
        roomNumber = new TableColumn<>("Rooom No");
        roomStatus = new TableColumn<>("FRProductModel Status");
        floor = new TableColumn<>("Floor");
        description = new TableColumn<>("Description");
        roomType = new TableColumn<>("FRProductModel Type");
        maxQuest = new TableColumn<>("Mam Capacity");
        status = new TableColumn<>("Status");
        price = new TableColumn<>("Price");


        code.setCellValueFactory(new PropertyValueFactory<>("code"));
        roomName.setCellValueFactory(new PropertyValueFactory<>("roomName"));
        roomNumber.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        roomStatus.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
        floor.setCellValueFactory(new PropertyValueFactory<>("floor"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        roomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));

        maxQuest.setCellValueFactory(new PropertyValueFactory<>("maxQuest"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        tblVWRoom.getItems().setAll(parseRoomLists());
        tblVWRoom.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tblVWRoom.getColumns().addAll(code, roomName, roomNumber, roomStatus, floor, description, roomType,maxQuest,status,price);

    }

    private List<FRProductModel> parseRoomLists() {
        lstRooms = this.dbService.getAllRoom();
        List<FRProductModel> rooms = new ArrayList<>();
        for(FRProductModel rm:lstRooms){
            int rmcode = rm.getCode();
            String rmName = rm.getRoomName();
            int rmNumber = rm.getRoomNumber();
            String rmStatus =rm.getStatus();
            int rmFloor = rm.getFloor();
            String rmDescription = rm.getDescription();
            FRProductTypeModel rmRoomType = rm.getRoomType();
            int rmMaxCapacity = rm.getMaxQuest();
            String Status = rm.getStatus();
            Float rmPrice = rm.getPrice();
            FRProductModel room = new Room(rmcode,rmName,rmNumber,rmStatus,rmFloor,rmDescription,rmRoomType,rmMaxCapacity,Status,rmPrice);
            rooms.add(room);


        }
        final ObservableList<FRProductModel> list = FXCollections.observableArrayList();
        list.addAll(rooms);
        return list;
    }




    public void onTxtRoomSearch(){

    }
    public void onBtnRoomSearchClicked(){

    }
    public void onBtnRoomAddClicked(){
        System.out.println("Button save clicked!!");
        RoomRegistrationController roomTypeController = (RoomRegistrationController) new WindowNavigation().navigateToWindow("Add FRProductModel",
                "../../resource/view/RoomRegistrationForm.fxml");
        roomTypeController.setRoomControllerListener(this);
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../resource/view/RoomRegistrationForm.fxml"));
//            Parent root1 = fxmlLoader.load();
//            Stage stage = new Stage();
//            RoomRegistrationController roomRegistrationController = fxmlLoader.getController();
//            roomRegistrationController.setRoomControllerListener(this);
//
//            stage.setScene(new Scene(root1));
//            stage.show();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }

    }

    public void onBtnRoomRefreshClicked(){
        tblVWRoom.setItems(originalRoomList);

    }
    public void onBtnRoomEditClicked(){
        RoomRegistrationController roomRegisterController = (RoomRegistrationController) new WindowNavigation().navigateToWindow("Edit FRProductModel Type",
                "../../resource/view/RoomRegistrationForm.fxml");
        roomRegisterController.setEditedRoomType((FRProductModel) tblVWRoom.getSelectionModel().getSelectedItem());
        roomRegisterController.setEditWindow(true);
        roomRegisterController.setRoomControllerListener(this);

    }
    public void onBtnRoomDeleteClicked(){
        FRProductModel selectedRoom = (FRProductModel) tblVWRoom.getSelectionModel().getSelectedItem();
        int result = this.dbService.deleteRoom(selectedRoom);
        // Display confirm message to delete item.
        if (result != 0) {
            // Delete success
            originalRoomList.remove(selectedRoom);
            onBtnRoomRefreshClicked();
        } else {
            // Delete false;
        }
    }

    @Override
    public void onSaveRoomSuccess(FRProductModel room) {
        originalRoomList.add(room);
        onBtnRoomRefreshClicked();
    }

    @Override
    public void onUpdateRoomSuccess(FRProductModel room) {
        tblVWRoom.notifyAll();
    }

    @Override
    public void onSaveRoomFail(String errMessage) {

    }
}
