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
    @FXML
    Button btnStudentSignUp;
    @FXML
    Button btnProfessorSignUp;
    @FXML
    Button btnCancel;


    //Navigation Buttons
    //This button takes the user from the startup screen to the student Sign In page
    public void studentSignInPressed() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StudentSignIn.fxml"));
        Stage window = (Stage) btnStudentSignIn.getScene().getWindow();
        window.setScene(new Scene(root, 600, 600));
    }

    //This button take the user from startup to the student sign up page
    public void studentSignUpPressed() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StudentSignUp.fxml"));
        Stage window = (Stage) btnStudentSignUp.getScene().getWindow();
        window.setScene(new Scene(root, 600, 600));
    }

    //This button take the user from startup to the professor sign in page
    public void professorSignInPressed() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProfessorSignIn.fxml"));
        Stage window = (Stage) btnProfessorSignIn.getScene().getWindow();
        window.setScene(new Scene(root, 600, 600));
    }

    //This button takes the user from startup to the professor sign up page
    public void professorSignUpPressed () throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ProfessorSignUp.fxml"));
        Stage window = (Stage) btnProfessorSignUp.getScene().getWindow();
        window.setScene(new Scene(root, 600, 600));
    }

    //This button takes the user back to the startup page from any of the sign in, or sign up pages
    public void cancelButtonPressed() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = (Stage) btnCancel.getScene().getWindow();
        window.setScene(new Scene(root, 600, 600));
    }

}
