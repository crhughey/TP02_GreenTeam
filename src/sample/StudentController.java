package sample;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    @FXML TableView<StudentClass> tblClassInfo;
    @FXML TableColumn<StudentClass, String> colClassName;
    @FXML TableColumn<StudentClass, String> colClassroom;
    @FXML TableColumn<StudentClass, String> colProfessor;
    @FXML TableColumn<StudentClass, String> colClassDay;
    @FXML TextField txtClassName;
    @FXML TextField txtClassroom;
    @FXML TextField txtProfessor;
    @FXML TextField txtClassDay;
    @FXML Button btnAdd;
    @FXML Button btnUpdate;
    @FXML Button btnDelete;
    @FXML Button btnCancel;
    @FXML Label lblGreetStudent;

    StudentClass selectedClass = new StudentClass();
    ObservableList<StudentClass> studentClasses = StudentClass.loadDummyData();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //lblGreetStudent.setText("Hello " + Student.getName());

        colClassName.setCellValueFactory(new PropertyValueFactory<StudentClass, String>("studentClassName"));
        colClassroom.setCellValueFactory(new PropertyValueFactory<StudentClass, String>("studentClassroom"));
        colProfessor.setCellValueFactory(new PropertyValueFactory<StudentClass, String>("studentProfessor"));
        colClassDay.setCellValueFactory(new PropertyValueFactory<StudentClass, String>("studentClassDay"));

        tblClassInfo.setItems(studentClasses);

        TableView.TableViewSelectionModel<StudentClass> selectionModel = tblClassInfo.getSelectionModel();

        ObservableList<StudentClass> selectedItems = selectionModel.getSelectedItems();

        selectedItems.addListener(new ListChangeListener<StudentClass>() {
            @Override
            public void onChanged(Change<? extends StudentClass> change) {
                System.out.println("Selection changed: " + change.getList());
                selectedClass = change.getList().get(0);

                txtClassName.setText(selectedClass.getStudentClassName());
                txtClassName.setText(selectedClass.getStudentClassroom());
                txtClassName.setText(selectedClass.getStudentProfessor());
                txtClassName.setText(selectedClass.getStudentClassDay());
            }
        });
    }

    public void Add(ActionEvent actionEvent) {
        StudentClass newStudentClass = new StudentClass(txtClassName.getText(), txtClassroom.getText(), txtClassDay.getText(), txtProfessor.getText());

        studentClasses.add(newStudentClass);

        tblClassInfo.refresh();
    }

    public void Update(ActionEvent actionEvent) {
        int index = studentClasses.indexOf(selectedClass);
        StudentClass studentClass = (StudentClass)(studentClasses.get(index));

        studentClass.setStudentClassName(txtClassName.getText());
        studentClass.setStudentClassroom(txtClassroom.getText());
        studentClass.setStudentClassDay(txtClassDay.getText());
        studentClass.setStudentProfessor(txtProfessor.getText());

        tblClassInfo.refresh();
    }

    public void Delete(ActionEvent actionEvent) {
        studentClasses.remove(selectedClass);
    }

    public void Cancel(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = (Stage) btnCancel.getScene().getWindow();
        window.setScene(new Scene(root, 600, 600));
    }
}
