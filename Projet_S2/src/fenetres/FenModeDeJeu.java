package fenetres;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class FenModeDeJeu extends Stage {

	Stop[] 			stops 	= new Stop[] { new Stop(0, Color.web("#0000FF")), new Stop(1, Color.web("#000000"))};  //degrade #0000FF to #000000
    LinearGradient 	lg1 	= new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops); 
	
	Label	titre		= new Label("Mode de jeu");
	Label	PuissanceX	= new Label("Puissance 4 X" + "\n" + "(spécial)");	
	Label	Puissance4	= new Label("Puissance 4" + "\n" + "(classique)");
	
	VBox	VBox1	= new VBox();
	VBox	VBox2	= new VBox();
	Button	Jouer1	= new Button("Jouer");
	Button	Regles1	= new Button("Règles");
	Button	Jouer2	= new Button("Jouer");
	Button	Regles2	= new Button("Règles");
	Button	Retour	= new Button("Retour");
	
	public FenModeDeJeu() {
		this.setTitle("Puissance 4: Mode de jeu");
		
		Scene scene = new Scene(this.creerContenu(), 1280, 720);
		this.setScene(scene);
		this.setResizable(false);

		Jouer1.setOnAction(e -> jouer1());
		Jouer2.setOnAction(e -> jouer2());
		Retour.setOnAction(e -> retour());
		Regles1.setOnAction(e -> info1());
		Regles2.setOnAction(e -> info2());
		
	}
	private void jouer1() {
		FenChoixAdversaire1 fenChoixAdversaire1 = new FenChoixAdversaire1();
		this.close();
		fenChoixAdversaire1.show();
	}
	private void jouer2() {
		FenChoixAdversaire2 fenChoixAdversaire2 = new FenChoixAdversaire2();
		this.close();
		fenChoixAdversaire2.show();
	}
	
	private void retour() {
		FenAccueil fenAccueil = new FenAccueil();
		this.close();
		fenAccueil.show();
	}
	
	private void info1() {
        Alert alert = new Alert(AlertType.NONE);
        alert.setTitle("Règles puissance 4 spécial");
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        alert.setContentText("Pour jouer une partie de Puissance X, le joueur concerné par le tour doit poser un jeton"
        		+ "\r\n"
        		+ "\r\n"
        		+ "Pour gagner une partie de puissance X, il faut être celui qui à aligné le plus de fois 4 jetons de sa couleur horizontalement, verticalement ou diagonalement, plus de fois que son adversaire."
        		+ "\r\n"
        		+ "Si lors d’une partie, tous les jetons sont joués sans qu’il y est d’alignement de jetons, la partie est déclaré nulle.");
 
        alert.showAndWait();
    }
	
	private void info2() {
        Alert alert = new Alert(AlertType.NONE);
        alert.setTitle("Règles puissance 4 classique");
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
 
        alert.setContentText("Pour jouer une partie de Puissance 4, le joueur concerné par le tour doit poser un jeton"
        		+ "\r\n"
        		+ "\r\n"
        		+ "Pour gagner une partie de puissance 4, il faut être le premier à aligner 4 jetons de sa couleur horizontalement, verticalement ou diagonalement."
        		+ "\r\n"
        		+ "Si lors d’une partie, tous les jetons sont joués sans qu’il y est d’alignement de jetons, la partie est déclaré nulle.");
 
        alert.showAndWait();
    }
	
	private AnchorPane creerContenu() {
		AnchorPane root = new AnchorPane();
		
		titre.setFont(new Font("Arial", 50));
		titre.setTextFill(Color.WHITE);
		titre.setAlignment(Pos.CENTER);
		
		AnchorPane.setTopAnchor(titre, 100.0);
		AnchorPane.setLeftAnchor(titre, 300.0);
		AnchorPane.setRightAnchor(titre, 300.0);

		Font font = Font.font("Arial", 30);
		Font font2 = Font.font("Arial", 15);
		PuissanceX.setTextFill(Color.WHITE);
		PuissanceX.setTextAlignment(TextAlignment.CENTER);
		Puissance4.setTextFill(Color.WHITE);
		Puissance4.setTextAlignment(TextAlignment.CENTER);
		PuissanceX.setFont(font);
		Puissance4.setFont(font);
		Jouer1.setFont(font);
		Regles1.setFont(font2);
		Jouer2.setFont(font);
		Regles2.setFont(font2);
		Retour.setFont(font);
		
		VBox1.setSpacing(10);
		VBox1.setAlignment(Pos.CENTER);
		VBox1.getChildren().add(PuissanceX);
		VBox1.getChildren().add(Jouer1);
		VBox1.getChildren().add(Regles1);

		VBox2.setSpacing(10);
		VBox2.setAlignment(Pos.CENTER);
		VBox2.getChildren().add(Puissance4);
		VBox2.getChildren().add(Jouer2);
		VBox2.getChildren().add(Regles2);
		
		AnchorPane.setTopAnchor(VBox1, 250.0);
		AnchorPane.setLeftAnchor(VBox1, 300.0);
		AnchorPane.setRightAnchor(VBox1, 700.0);
		
		AnchorPane.setTopAnchor(VBox2, 250.0);
		AnchorPane.setLeftAnchor(VBox2, 700.0);
		AnchorPane.setRightAnchor(VBox2, 300.0);
		
		AnchorPane.setTopAnchor(Retour, 600.0);
		AnchorPane.setLeftAnchor(Retour, 300.0);
		AnchorPane.setRightAnchor(Retour, 300.0);

		Rectangle fond = new Rectangle(0, 0, 1280, 720);
        fond.setFill(lg1);
		root.getChildren().addAll(fond);

		root.getChildren().addAll(titre);
		root.getChildren().addAll(VBox1);
		root.getChildren().addAll(VBox2);
		root.getChildren().addAll(Retour);
		return root;
	}
}