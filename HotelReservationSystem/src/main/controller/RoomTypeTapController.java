package main.controller;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Shared.WindowNavigation;
import main.dbsub.DBFacadeImpl;
import main.dbsub.DBService;
import main.model.FRProductTypeModel;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by gebre on 4/23/2017.
 */
public class RoomTypeTapController implements Initializable, RoomTypeController.RoomTypeControllerListener {

    @FXML
    private TableView tblRoomType;
    @FXML
    private TableColumn<FRProductTypeModel, Void> num;
    @FXML
    private TableColumn<FRProductTypeModel, String> idRoomType;
    @FXML
    private TableColumn<FRProductTypeModel, String> description;
    @FXML
    private TableColumn<FRProductTypeModel, Integer> maxCapacity;
    @FXML
    private TextField txtRoomTypeSearch;
    @FXML
    private Button btnRoomTypeSearch;
    @FXML
    private Button btnRoomTypeAdd;
    @FXML
    private Button btnRoomTypeRefresh;
    @FXML
    private Button btnRoomTypeEdit;
    @FXML
    private Button btnRoomTypeDelete;


    private DBService dbService;
    private ObservableList<FRProductTypeModel> originalRoomTypeList = FXCollections.observableArrayList();
    private ObservableList<FRProductTypeModel> modifiedRoomTypeList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbService = new DBFacadeImpl();

        // Load FRProductTypeModel list from Database
        originalRoomTypeList = FXCollections.observableArrayList(dbService.getAllRoomType());

        // Init Table view and load data
        loadRoomTypeListIntoView();

    }

    @Override
    public void onSaveSuccess(FRProductTypeModel roomType) {
        originalRoomTypeList.add(roomType);
        onBtnRoomTypeRefreshClicked();
    }

    @Override
    public void onUpdateSuccess(FRProductTypeModel roomType) {
        //onBtnRoomTypeRefreshClicked();
        //tblRoomType.notifyAll();
        originalRoomTypeList.notify();
    }

    @Override
    public void onSaveFail(String errMessage) {
        // Alert message box to inform user.

    }

    public void loadRoomTypeListIntoView() {
        num = new TableColumn<>("No");
        idRoomType = new TableColumn<>("Id");
        description = new TableColumn<>("Description");
        maxCapacity = new TableColumn<>("Capacity");

        num.setCellFactory(col -> {
            TableCell<FRProductTypeModel, Void> cell = new TableCell<>();
            cell.textProperty().bind(Bindings.createStringBinding(() -> {
                if (cell.isEmpty()) {
                    return null;
                } else {
                    return Integer.toString(cell.getIndex());
                }
            }, cell.emptyProperty(), cell.indexProperty()));
            return cell;
        });
        idRoomType.setCellValueFactory(new PropertyValueFactory<>("code"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        maxCapacity.setCellValueFactory(new PropertyValueFactory<>("maxCapacity"));

        //tblRoomType.getItems().setAll(originalRoomTypeList);
        tblRoomType.setItems(originalRoomTypeList);
        tblRoomType.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tblRoomType.getColumns().addAll(num, idRoomType, description, maxCapacity);
    }

    public void onTxtRoomTypeSearch(){

    }
    public void onBtnRoomTypeSearchClicked() {
        String textSearch = txtRoomTypeSearch.getText();
        if (!textSearch.isEmpty()) {
            searchRoomType(textSearch);
        }
    }
    public void onBtnRoomTypeAddClicked(){
        RoomTypeController roomTypeController = (RoomTypeController) new WindowNavigation().navigateToWindow("Add Room Type",
                "../../resource/view/FRProductTypeModel.fxml");
        roomTypeController.setRoomTypeControllerListener(this);

    }
    public void onBtnRoomTypeRefreshClicked(){
        tblRoomType.setItems(originalRoomTypeList);
    }

    public void onBtnRoomTypeEditClicked(){
        FRProductTypeModel roomTypeToEdit = (FRProductTypeModel) tblRoomType.getSelectionModel().getSelectedItem();
        if (roomTypeToEdit != null) {
            RoomTypeController roomTypeController = (RoomTypeController) new WindowNavigation().navigateToWindow("Edit Room Type",
                    "../../resource/view/FRProductTypeModel.fxml");
            roomTypeController.setEditedRoomType((FRProductTypeModel) tblRoomType.getSelectionModel().getSelectedItem());
            //roomTypeController.setEditWindow(true);
            roomTypeController.setRoomTypeControllerListener(this);
        } else {
            JOptionPane.showMessageDialog(null, "Please select record to update!");
        }
    }
    public void onBtnRoomTypeDeleteClicked(){
        FRProductTypeModel selectedRoomType = (FRProductTypeModel) tblRoomType.getSelectionModel().getSelectedItem();
        int result = this.dbService.deleteRoomType(selectedRoomType);
        // Display confirm message to delete item.
        if (result != 0) {
            // Delete success
            originalRoomTypeList.remove(selectedRoomType);
            onBtnRoomTypeRefreshClicked();
        } else {
            // Delete false;
        }
    }

    public void searchRoomType(String value) {
        modifiedRoomTypeList = originalRoomTypeList.stream()
                .filter(r -> r.getDescription().toLowerCase().contains(value.toLowerCase()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        tblRoomType.setItems(modifiedRoomTypeList);
    }
}
