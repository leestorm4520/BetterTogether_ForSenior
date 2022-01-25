package application;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController extends Model implements Initializable {

   
    User user=new User();
    String string="Welcome back, "+user.getId();
       
    @FXML
    private Label introUser=new Label(string);
    
    @FXML
    void logOut(ActionEvent event) throws IOException{
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
    void createPost(ActionEvent event) throws IOException{
    	 try {
      		  FXMLLoader loader=new FXMLLoader(getClass().getResource("CreatePost.fxml"));
      		  Stage stage=new Stage(StageStyle.DECORATED);
      		  stage.setScene(new Scene(loader.load()));
      		  CreatePostController controller=new CreatePostController();
      		  controller.user.setId(user.getId());
      		  stage.show();
      	  }
      	  catch(IOException e) {
      	  e.printStackTrace();
      	  }
    }
    
    @FXML void reactPost(ActionEvent event) {
    	 try {
      		  FXMLLoader loader=new FXMLLoader(getClass().getResource("ReactPost.fxml"));
      		  Stage stage=new Stage(StageStyle.DECORATED);
      		  stage.setScene(new Scene(loader.load()));
      		  stage.show();
      	  }
      	  catch(IOException e) {
      	  e.printStackTrace();
      	  }
    }
    
		

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		Random rand=new Random();
		try {
			HashMap<String,String> messageMap=new HashMap<String,String>();
			Properties MessageP=new Properties();     // create property object
			File messageF=new File("Messages.properties");   // file object
			FileInputStream fileM=new FileInputStream(messageF);  
			MessageP.load(fileM);  // load the info into the object
			
			for(String key:MessageP.stringPropertyNames()) {  // put the info into the hashmap
				String quote=MessageP.getProperty(key);
				messageMap.put(key,quote);
			}
			
			int ranKey=rand.nextInt(29)+1;   // get random values from 1-30
			String ranKeystr=Integer.toString(ranKey);
			String display=messageMap.get(ranKeystr);  // get the string to display
			Labeled messageD = null;
			messageD.setText(display);   // display the string on the interface
			long end=System.nanoTime();   //whenever the interface if opened, get the value of current time
			long time=end-Main.begin;   // end time minus start time
			long timesec=time/1000000000;   // divide to get the unit in second
			long timemin=timesec/60;    // divide to get the unit in minute
			Labeled timeD = null;
			timeD.setText("App use time: "+timemin+" minutes");   // display time in minutes
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}
	
	
}
