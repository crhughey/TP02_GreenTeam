package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    Button btnStudentSignIn;
    @FXML
    Button btnProfessorSignIn;

    public void studentSignInPressed() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StudentSignIn.fxml"));
        Stage window = (Stage) btnStudentSignIn.getScene().getWindow();
        window.setScene(new Scene(root, 600, 600));
    }

    public void professorSignInPressed() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProfessorSignIn.fxml"));
        Stage window = (Stage) btnProfessorSignIn.getScene().getWindow();
        window.setScene(new Scene(root, 600, 600));
    }
}
