package application;

import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreatePostController extends Model{
		User user=new User();
		@FXML
	    private HTMLEditor writePost;

	    @FXML
	    private Label introUser=new Label(user.getId());

	

	
	public void homeMenu(ActionEvent event) {
		  try {
			  FXMLLoader loader=new FXMLLoader(getClass().getResource("MenuController"));
			  Stage stage=new Stage(StageStyle.DECORATED);
			  stage.setScene(new Scene(loader.load()));
			  MenuController controller=loader.getController();
			  controller.user.setId(user.getId());
			  stage.show();
		  }
		  catch(IOException e) {
		  e.printStackTrace();
		  }
	}

	//This method takes the user's post and stores it within a hashmap along with their username attached to the post
	public void addPost(ActionEvent event) throws IOException {
		String post = writePost.getHtmlText(); // gathers user input from the post text area
		writePost(user.getId(),post);
		writePost.setHtmlText("");
     
	}
	
	//This populates the usernameTxt textfield with the user name that was givin at the login stage
	public void initialize() {
		
}
}

