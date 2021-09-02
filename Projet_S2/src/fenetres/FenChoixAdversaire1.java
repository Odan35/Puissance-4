package fenetres;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import jcia.Jcia;
import jcj.Jcj;

public class FenChoixAdversaire1 extends Stage {

	Stop[] 			stops 	= new Stop[] { new Stop(0, Color.web("#0000FF")), new Stop(1, Color.web("#000000"))};  //degrade #0000FF to #000000
    LinearGradient 	lg1 	= new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops); 
	
	Label	titre		= new Label("Choix\nadversaire");
	Label	Joueur2		= new Label("Joueur 2");	
	Label	Ordinateur	= new Label("Ordinateur");
	
	VBox	VBox1	= new VBox();
	VBox	VBox2	= new VBox();
	Button	Jouer1	= new Button("Jouer");
	Button	Jouer2	= new Button("Jouer");
	Button	Retour	= new Button("Retour");
	
	public FenChoixAdversaire1() {
		this.setTitle("Puissance 4: Choix nadversaire");
		
		Scene scene = new Scene(this.creerContenu(), 1280, 720);
		this.setScene(scene);
		this.setResizable(false);
		
		Retour.setOnAction(e -> retour());
		Jouer1.setOnAction(e -> jouer1());
		Jouer2.setOnAction(e -> jouer2());
	}
	
	private void retour() {
		FenModeDeJeu fenModeDeJeu = new FenModeDeJeu();
		this.close();
		fenModeDeJeu.show();
	}

	private void jouer1() {
		Jcj puissance4 = new Jcj(true);
        this.close();
        puissance4.show();
	}
	private void jouer2() {
		Jcia puissance4 = new Jcia(true);
	    this.close();
	    puissance4.show();
	}
	
	private AnchorPane creerContenu() {
		AnchorPane root = new AnchorPane();
		
		titre.setFont(new Font("Arial", 50));
		titre.setTextFill(Color.WHITE);
		titre.setTextAlignment(TextAlignment.CENTER);
		titre.setAlignment(Pos.CENTER);
		
		AnchorPane.setTopAnchor(titre, 100.0);
		AnchorPane.setLeftAnchor(titre, 300.0);
		AnchorPane.setRightAnchor(titre, 300.0);

		Font font = Font.font("Arial", 30);
		Joueur2.setTextFill(Color.WHITE);
		Joueur2.setTextAlignment(TextAlignment.CENTER);
		Ordinateur.setTextFill(Color.WHITE);
		Ordinateur.setTextAlignment(TextAlignment.CENTER);
		Joueur2.setFont(font);
		Ordinateur.setFont(font);
		Jouer1.setFont(font);
		Jouer2.setFont(font);
		Retour.setFont(font);
		
		VBox1.setSpacing(10);
		VBox1.setAlignment(Pos.CENTER);
		VBox1.getChildren().add(Joueur2);
		VBox1.getChildren().add(Jouer1);

		VBox2.setSpacing(10);
		VBox2.setAlignment(Pos.CENTER);
		VBox2.getChildren().add(Ordinateur);
		VBox2.getChildren().add(Jouer2);
		
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