

package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
// import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class Main extends Application {
	public static long begin;



	@Override
	public void start(Stage stage) {
		try {
			AnchorPane main = (AnchorPane)FXMLLoader.load(getClass().getResource("LogInEntrance.fxml")); //create a FXMLLoader instance called main
			Scene scene1 = new Scene(main,400,400); //create a new scene with predetermined dimensions
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			stage.setScene(scene1);
			stage.setTitle("WeShare"); //set the scene title
			stage.show(); //show the scene
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
		
	
	}
}


