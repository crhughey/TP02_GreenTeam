package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    @FXML
    Button btnNewStudent;
    @FXML
    TextField txtStudentName;
    @FXML
    TextField txtStudentUsername;
    @FXML
    PasswordField pwfStudentPassword;
    @FXML
    TextField txtStudentUsernameAttempt;
    @FXML
    PasswordField pwfStudentPasswordAttempt;
    @FXML
    Button btnStudentLoginAttempt;
    @FXML
    TextField txtProfessorUsernameAttempt;
    @FXML
    PasswordField pwfProfessorPasswordAttempt;
    @FXML
    Button btnProfessorSignInAttempt;
    @FXML
    TextField txtAddProfessorName;
    @FXML
    PasswordField pwfAddProfessorPassword;
    @FXML
    TextField txtAddProfessorUsername;
    @FXML
    Label lblGreetStudent;
    @FXML
    Label lblGreetProfessor;


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

    //This is where we would need the file writer to add new students
    public void btnAddStudent(){
        //These are the text fields and password fields for the student sign up
        //txtStudentName
        //txtStudentUsername
        //pwfStudentPassword
    }

    //This method is used when a student attempts to login
    public void studentLoginAttempt(){
        // txtStudentUsernameAttempt
        // pwfStudentPasswordAttempt
        // btnStudentLoginAttempt, I'm not sure if you'll need this but here it is
        // lblGreetStudent (This is to display the student's name when taken to the new screen, if it's successful)
    }

    //This method is for when a professor attempts to login
    public void professorSignInAttempt() {
        // txtProfessorUsernameAttempt
        // pwfProfessorPasswordAttempt
        // btnProfessorSignInAttempt  (This one starts this method)
        // lblGreetProfessor (This is to display the professor's name when taken to the new screen, if it's successful)
    }

    public void addProfessor(){
        // txtAddProfessorUsername
        // txtAddProfessorName
        // pwfAddProfessorPassword
    }
}
