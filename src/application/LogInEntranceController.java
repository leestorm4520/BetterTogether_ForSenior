package application;

import java.awt.TextComponent;
import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LogInEntranceController extends Model implements Initializable{
	 @FXML
     private TextField password;

     @FXML
     private Button signIn;

    

     @FXML
     private TextField userID;

     @FXML
     void forgetPassword(ActionEvent event) {
    	 try {
   		  FXMLLoader loader=new FXMLLoader(getClass().getResource("ForgetPassword.fxml"));
   		  Stage stage=new Stage(StageStyle.DECORATED);
   		  stage.setScene(new Scene(loader.load()));
   		  stage.show();
   	  }
   	  catch(IOException e) {
   	  e.printStackTrace();
   	  }

     }

     @FXML
     void signUp(ActionEvent event) {
    	 try {
   		  FXMLLoader loader=new FXMLLoader(getClass().getResource("SignUp.fxml"));
   		  Stage stage=new Stage(StageStyle.DECORATED);
   		  stage.setScene(new Scene(loader.load()));
   		  stage.show();
   	  }
   	  catch(IOException e) {
   	  e.printStackTrace();
   	  }

     }
     
     @FXML 
     void signIn(ActionEvent event) throws IOException{
		 String id=userID.getText();
		 String pw=password.getText();
		 
		 
    	 if(userFormatValidation(id, pw)) {
    		 if(userExistenceValidation(id, pw)) {
    			 switchMenuController(id);
    		 }
    	 }
    	 else {
    		 userID.setText("");
    		 password.setText("");
    	 }
     }
	
  public void switchMenuController(String id) {
	  try {
		  FXMLLoader loader=new FXMLLoader(getClass().getResource("MenuController"));
		  Stage stage=new Stage(StageStyle.DECORATED);
		  stage.setScene(new Scene(loader.load()));
		  MenuController controller=loader.getController();
		  controller.user.setId(id);
		  stage.show();
	  }
	  catch(IOException e) {
	  e.printStackTrace();
	  }
  }
  
  
  
 
  
                            
  

@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	}
}
