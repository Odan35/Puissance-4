package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Page4 extends Stage {
	
	Label titre = new Label("Choix \n adversaire");
	Label Joueur2 = new Label("Joueur 2");	
	Label Ordinateur = new Label("Ordinateur");
	
	VBox VBox1 = new VBox();
	VBox VBox2 = new VBox();
	Button Jouer1 = new Button("Jouer");
	Button Jouer2 = new Button("Jouer");
	Button Retour = new Button("Retour");
	
	public Page4() {
		this.setTitle("Mode de jeu");
		
		Scene scene = new Scene(this.creerContenu(), 500, 500);
		this.setScene(scene);
		this.setResizable(false);
		
		Retour.setOnAction(e -> retour());
		
	/*
		Jouer1.setOnAction(e -> jouer());
	
	*/
	}
	
	private void retour() {
		Page3 page3 = new Page3();
		this.hide();
		page3.show();
	}
	
	/*
	private void jouer() {
		Page5 page5 = new Page5();
		this.hide();
		page5.show();
	}
	*/
	private AnchorPane creerContenu() {
		AnchorPane root = new AnchorPane();
		
		
		
		titre.setFont(new Font("Arial", 30));
		
		VBox1.getChildren().add(Joueur2);
		VBox1.getChildren().add(Jouer1);
		VBox2.getChildren().add(Ordinateur);
		VBox2.getChildren().add(Jouer2);


		
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