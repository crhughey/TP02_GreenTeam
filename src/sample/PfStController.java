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

public class PfStController implements Initializable {
    @FXML
    TableView tableView;
    @FXML
    TableColumn<PfStClass, String> studentFirstNameColumn;
    @FXML
    TableColumn<PfStClass, String> studentLastNameColumn;
    @FXML
    TableColumn<PfStClass, String> studentEMailColumn;
    @FXML
    TextField txtFirstName;
    @FXML
    TextField txtLastName;
    @FXML
    TextField txtEMail;
    @FXML
    Button btnPfStClose;

    PfStClass selectedPfStClass = new PfStClass();
    ObservableList<PfStClass> pfStClasses = PfStClass.loadDummyData();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentFirstNameColumn.setCellValueFactory(new PropertyValueFactory<PfStClass, String>("pfStClassFirstName"));
        studentLastNameColumn.setCellValueFactory(new PropertyValueFactory<PfStClass, String>("pfStClassLastName"));
        studentEMailColumn.setCellValueFactory(new PropertyValueFactory<PfStClass, String>("pfStClassEMail"));

//        pfStClasses = loadFromFile("pfStClasses.txt");

        tableView.setItems(pfStClasses);

        TableView.TableViewSelectionModel<PfStClass> selectionModel =
                tableView.getSelectionModel();

        ObservableList<PfStClass> selectedItems = selectionModel.getSelectedItems();

        selectedItems.addListener(new ListChangeListener<PfStClass>() {
            @Override
            public void onChanged(Change<? extends PfStClass> change) {
                System.out.println("Selection Changed: " + change.getList());
                selectedPfStClass = change.getList().get(0);

                txtFirstName.setText(selectedPfStClass.getPfStClassFirstName());
                txtLastName.setText(selectedPfStClass.getPfStClassLastName());
                txtEMail.setText(selectedPfStClass.getPfStClassEMail());
            }
        });

    }

    public void deleteButtonClick(ActionEvent actionEvent) {
        pfStClasses.remove(selectedPfStClass);
//        saveToFile(pfStClasses);
    }

    public void addButtonClick(ActionEvent actionEvent) {
        PfStClass newPfStClass = new PfStClass(txtFirstName.getText(),
                txtLastName.getText(),
                txtEMail.getText());

        pfStClasses.add(newPfStClass);
        // added new Class
        System.out.println("First Name " + newPfStClass.getPfStClassFirstName() );
        System.out.println("Last Name " + newPfStClass.getPfStClassLastName() );
        System.out.println("EMail " + newPfStClass.getPfStClassEMail() );
//        saveToFile(pfStClasses);
        tableView.refresh();
    }

    public void saveButtonClick(ActionEvent actionEvent) {
        int index = pfStClasses.indexOf(selectedPfStClass);
        PfStClass pfStClass = (PfStClass)(pfStClasses.get(index));

        pfStClass.setPfStClassFirstName(txtFirstName.getText());
        pfStClass.setPfStClassLastName(txtLastName.getText());
        pfStClass.setPfStClassEMail(txtEMail.getText());

        tableView.refresh();
//        saveToFile(pfStClasses);
    }

    public void closeButtonClick() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = (Stage) btnPfStClose.getScene().getWindow();
        window.setScene(new Scene(root, 600, 500));
    }
}