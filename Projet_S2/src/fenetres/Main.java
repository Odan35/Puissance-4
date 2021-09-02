package fenetres;

import javafx.application.Application;
import javafx.stage.Stage;
	
public class Main extends Application{
	//creation de la scene
	public void start(Stage primaryStage){
		primaryStage = new FenAccueil();
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}