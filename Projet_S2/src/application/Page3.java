package application;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Page3 extends Stage {
	
	Label titre = new Label("Mode de jeu");
	Label PuissanceX = new Label("Puissance 4 X \n(spécial)");	
	Label Puissance4 = new Label("Puissance 4 \n(classique)");
	
	VBox VBox1 = new VBox();
	VBox VBox2 = new VBox();
	Button Jouer1 = new Button("Jouer");
	Button Regles1 = new Button("Règles");
	Button Jouer2 = new Button("Jouer");
	Button Regles2 = new Button("Règles");
	Button Retour = new Button("Retour");
	
	public Page3() {
		this.setTitle("Mode de jeu");
		
		Scene scene = new Scene(this.creerContenu(), 500, 500);
		this.setScene(scene);
		this.setResizable(false);
		Retour.setOnAction(e -> retour());
		Regles1.setOnAction(e -> info1());
		Regles2.setOnAction(e -> info2());
		
	}
	
	private void retour() {
		Page1 page1 = new Page1();
		this.hide();
		page1.show();
	}
	
	private void info1() {
        Alert alert = new Alert(AlertType.NONE);
        alert.setTitle("Règles puissance 4 spécial");
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        alert.setContentText("Salut mon pote");
 
        alert.showAndWait();
    }
	
	private void info2() {
        Alert alert = new Alert(AlertType.NONE);
        alert.setTitle("Règles puissance 4 classique");
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
 
        alert.setContentText("Salut mon pote");
 
        alert.showAndWait();
    }
	
	private AnchorPane creerContenu() {
		AnchorPane root = new AnchorPane();
		
		
		
		titre.setFont(new Font("Arial", 30));
		
		VBox1.getChildren().add(PuissanceX);
		VBox1.getChildren().add(Jouer1);
		VBox1.getChildren().add(Regles1);
		
		VBox2.getChildren().add(Puissance4);
		VBox2.getChildren().add(Jouer2);
		VBox2.getChildren().add(Regles2);

		
		AnchorPane.setTopAnchor(titre, 20.0);
		AnchorPane.setLeftAnchor(titre, 170.0);
		AnchorPane.setRightAnchor(titre, 150.0);
		
		AnchorPane.setTopAnchor(VBox1, 200.0);
		AnchorPane.setLeftAnchor(VBox1, 130.0);
		AnchorPane.setRightAnchor(VBox1, 150.0);
		
		AnchorPane.setTopAnchor(VBox2, 200.0);
		AnchorPane.setLeftAnchor(VBox2, 300.0);
		AnchorPane.setRightAnchor(VBox2, 100.0);
		
		AnchorPane.setBottomAnchor(Retour, 20.0);
		AnchorPane.setLeftAnchor(Retour, 230.0);
		
		root.getChildren().addAll(titre);
		root.getChildren().addAll(VBox1);
		root.getChildren().addAll(VBox2);
		root.getChildren().addAll(Retour);
		return root;
	}
}