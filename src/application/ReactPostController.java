/*
 * Lisette Isais' assigned part for WeShare Project
 */

package application;

import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class ReactPostController extends Model{
		User user=new User();

	    @FXML
	    private Button Heart;
	    
	    @FXML 
	    private WebView showPost=new WebView();
	    WebEngine webEngine=showPost.getEngine();
	    
	    @FXML
	    private TextArea comment; 

	    @FXML
	    private TextArea writeComment;

	    
	    @FXML
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
	    
		 @FXML
		 void logOut(ActionEvent event) {
		    	 try {
		     		  FXMLLoader loader=new FXMLLoader(getClass().getResource("LogInEntrance.fxml"));
		     		  Stage stage=new Stage(StageStyle.DECORATED);
		     		  stage.setScene(new Scene(loader.load()));
		     		  stage.show();
		     	  }
		     	  catch(IOException e) {
		     	  e.printStackTrace();
		     	  }
		    }
		 
		 @FXML
		 void viewRandomPost(ActionEvent event) throws IOException {
			 user=ranUser();
			 String comments=ranPost(user);
			 String post=getKeyByValue(user.posts, comments);
			 webEngine.loadContent(post, "text/html");
			 String comment=user.getId()+":\t"+writeComment.getText();
			 updateComment(comment, post, user);
			 
			 
		 }
		 

}
