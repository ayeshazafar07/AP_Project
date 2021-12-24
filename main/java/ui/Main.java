package ui;
	

import java.sql.Date;
import java.sql.Time;

import businessLogic.Available_Slot;
import javafx.application.Application;
import javafx.stage.Stage;
import services.DbHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	@SuppressWarnings("exports")
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("OrphanageMainMenu.fxml"));
			Scene scene = new Scene(root,721,531);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Orphanage Login");
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		/*Date dateOfEntry = Date.valueOf("2001-5-21");
      Time timeOfMeet = Time.valueOf("05:32:00");
      Available_Slot slot = new Available_Slot(dateOfEntry, timeOfMeet);
		DbHandler db=new DbHandler();
		db.insertAvailableSlot(slot);
		dateOfEntry = Date.valueOf("2001-5-23");
	     timeOfMeet = Time.valueOf("05:35:00");
	      Available_Slot slot1 = new Available_Slot(dateOfEntry, timeOfMeet);
	      db.insertAvailableSlot(slot);*/
		launch(args);
	}
}
