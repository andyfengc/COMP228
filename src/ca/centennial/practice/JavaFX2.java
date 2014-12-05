package ca.centennial.practice;

// multiple stage example
// javafx.jar 7 location: c:/program files(x86)/java/jre7/lib/jfxrt.jar
// javafx.jar 8 location: c:/program files(x86)/java/jre8/lib/ext/jfxrt.jar
// a stage include a scene, a scene can include multiple controls
// tutorial: https://docs.oracle.com/javafx/2/get_started/hello_world.htm

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class JavaFX2 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// create a scene & place a button
		Scene scene = new Scene(new Button("OK"), 200, 250);
		// primary stage
		primaryStage.setTitle("Primary stage");
		primaryStage.setScene(scene);
		primaryStage.show();

		// create a new stage
		Stage stage = new Stage();
		// set the stage title
		stage.setTitle("second stage");
		stage.setScene(new Scene(new Button("new button"), 100, 100));
		stage.show();
	}
	public static void main(String[] args){
		launch(args);
	}
}
