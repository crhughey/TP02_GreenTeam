package sample;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PfController implements Initializable {
    @FXML
    TableView tableView;
    @FXML
    TableColumn<PfClass, String> classNameColumn;
    @FXML
    TableColumn<PfClass, String> classRoomlumn;
    @FXML
    TableColumn<PfClass, String> classDayColumn;
    @FXML
    TextField txtClassName;
    @FXML
    TextField txtClassRoom;
    @FXML
    TextField txtClassDay;
    @FXML
    Button btnPfStudents;
    @FXML
    Button btnPfClose;

    PfClass selectedPfClass = new PfClass();
    ObservableList<PfClass> psClasses = PfClass.loadDummyData();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        classNameColumn.setCellValueFactory(new PropertyValueFactory<PfClass, String>("pfClassName"));
        classRoomlumn.setCellValueFactory(new PropertyValueFactory<PfClass, String>("pfClassRoom"));
        classDayColumn.setCellValueFactory(new PropertyValueFactory<PfClass, String>("pfClassDay"));

//        psClasses = loadFromFile("psClasses.txt");

        tableView.setItems(psClasses);

        TableView.TableViewSelectionModel<PfClass> selectionModel =
                tableView.getSelectionModel();

        ObservableList<PfClass> selectedItems = selectionModel.getSelectedItems();

        selectedItems.addListener(new ListChangeListener<PfClass>() {
            @Override
            public void onChanged(Change<? extends PfClass> change) {
                System.out.println("Selection Changed: " + change.getList());
                selectedPfClass = change.getList().get(0);

                txtClassName.setText(selectedPfClass.getPfClassName());
                txtClassRoom.setText(selectedPfClass.getPfClassRoom());
                txtClassDay.setText(selectedPfClass.getPfClassDay());
            }
        });

    }

    public void deleteButtonClick(ActionEvent actionEvent) {
        psClasses.remove(selectedPfClass);
//        saveToFile(psClasses);
    }

    public void addButtonClick(ActionEvent actionEvent) {
        PfClass newPfClass = new PfClass(txtClassName.getText(),
                txtClassRoom.getText(),
                txtClassDay.getText());

        psClasses.add(newPfClass);
        // added new Class
        System.out.println("ClassName " + newPfClass.getPfClassName() );
        System.out.println("ClassRoom " + newPfClass.getPfClassRoom() );
        System.out.println("ClassDay " + newPfClass.getPfClassDay() );
//        saveToFile(psClasses);
        tableView.refresh();
    }

    public void saveButtonClick(ActionEvent actionEvent) {
        int index = psClasses.indexOf(selectedPfClass);
        PfClass pfClass = (PfClass)(psClasses.get(index));

        pfClass.setPfClassName(txtClassName.getText());
        pfClass.setPfClassRoom(txtClassRoom.getText());
        pfClass.setPfClassDay(txtClassDay.getText());

        tableView.refresh();
//        saveToFile(psClasses);
    }

    public void closeButtonClick() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = (Stage) btnPfClose.getScene().getWindow();
        window.setScene(new Scene(root, 600, 600));
    }

    public void studentButtonClick(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProfessorStudentScreen.fxml"));
        Stage window = (Stage) btnPfStudents.getScene().getWindow();
        window.setScene(new Scene(root, 600, 600));
        window.setTitle("Students in class ");
    }
}
