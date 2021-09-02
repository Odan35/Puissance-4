package test_image;

import javafx.application.Application;
import javafx.stage.Stage;
	
public class main_test_image extends Application{
	//creation de la scene
	public void start(Stage primaryStage){
		primaryStage = new maFenetre();
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
