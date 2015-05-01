package ca.centennial.practice;
// single stage example

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class JavaFX1 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// crate a scene and place a button in the scene
		primaryStage.setTitle("My Java FX");
		Button btnOk = new Button("OK");
		Scene scene = new Scene(btnOk, 200, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		//launch(args);
		launch("", "");
	}
	
	class Handler implements EventHandler<Event>{

		@Override
		public void handle(Event event) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
