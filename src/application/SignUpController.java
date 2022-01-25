package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class SignUpController {

    @FXML
    private TextField SignUpUsername;

    @FXML
    private ComboBox <String> SignUpSecurityQuestions;
    
    //ObservableList<String> list = FXCollections.observableArrayList("What is you home country name?", "What is the name of your favorite childhood teacher?");

    @FXML
    private TextField SignUpPassword;

    @FXML
    private TextField SignUpSecurityAnswer;
    
    @FXML
    private AnchorPane mainPane;


    /*
   	Method: storeLoginInfo
   	Description: stores the Sign Up username and password information to be used for Login
   	Parameters: event
   	Return: none
   	*/

    public void storeLoginInfo(ActionEvent event) throws IOException {
        File inFile = new File("LoginInfo.properties");
        if (!(inFile.exists())) {
            inFile.createNewFile();
        }

        String username = SignUpUsername.getText().toString();
        String password = SignUpPassword.getText().toString();

        HashMap < String, String > loginInfo = new HashMap < String, String > ();
        Properties properties = new Properties();
        loginInfo.put(username, password);


        properties.putAll(loginInfo);

        File outFile = new File("LoginInfo.properties");
        FileOutputStream writer = new FileOutputStream(outFile, true);
        properties.store(writer, null);

        SignUpUsername.clear();
        SignUpPassword.clear();
        SignUpSecurityAnswer.clear();

        changeSceneToWelcomePage(event);
        signUpSuccessfulMessage();

    }

    //Displaying Messages to User
    
    /*
   	Method: signUpSuccessfulMessage
   	Description: Pops up a confirmation message if sign up was successful 
   	Parameters: none
   	Return: none
   	*/
    
    public void signUpSuccessfulMessage() {
        Alert a = new Alert(AlertType.NONE);
        a.setAlertType(AlertType.CONFIRMATION);
        a.setContentText("Signup was successful!");
        a.show();
    }


    //Changing Scene
    
    /*
   	Method: changeSceneToWelcomePage
   	Description: changes scenes from SignUpPage.fxml back to WelcomePage.fxml
   	Parameters: event
   	Return: none
   	*/
    
    @FXML
    void changeSceneToWelcomePage(ActionEvent event) throws IOException {

        mainPane = FXMLLoader.load(getClass().getResource("WelcomePage.fxml")); 
        Scene LoginScene = new Scene(mainPane);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(LoginScene);
        window.show();
        //mainPane.setBackground(new Background(new BackgroundFill(Color.rgb(228, 251, 255, 1), null, null)));
    }




}