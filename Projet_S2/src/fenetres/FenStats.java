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
import javafx.stage.Stage;

public class FenStats extends Stage {

	Stop[] 			stops 	= new Stop[] { new Stop(0, Color.web("#0000FF")), new Stop(1, Color.web("#000000"))};  //degrade #0000FF to #000000
    LinearGradient 	lg1 	= new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops); 
	
	Label	titre		= new Label("Statistiques");
	Label	Joueur1		= new Label("Joueur 1");
	Label	Joueur2		= new Label("Joueur 2");	
	Label	victoire	= new Label("Victoires : " + (int) Stat.gagnej1);
	Label	defaite		= new Label("Défaites : " + (int) Stat.perduj1);
	Label	matchNul	= new Label("Egalités : " + Stat.nulej1);
	Label	ratio		= new Label("Ratio(V/D) : ");
	Label	victoire2	= new Label("Victoires : " + (int) Stat.gagnej2);
	Label	defaite2	= new Label("Défaites : " + (int) Stat.perduj2);
	Label	matchNul2	= new Label("Egalités : " + Stat.nulej2);
	Label	ratio2		= new Label("Ratio(V/D) : ");
	VBox	VBox1		= new VBox();
	VBox	VBox2		= new VBox();
	Button	Retour		= new Button("Retour");
	
	public FenStats() {
		this.setTitle("Puissance 4: Statistiques");
	
		Scene scene = new Scene(this.creerContenu(), 1280, 720);
		this.setScene(scene);
		this.setResizable(false);
		
		Retour.setOnAction(e -> retour());
	}
	
	private void retour() {
		FenAccueil fenAccueil = new FenAccueil();
		this.close();
		fenAccueil.show();
	}
	
	private AnchorPane creerContenu() {
		AnchorPane root = new AnchorPane();
		
		if (Stat.perduj1 == 0) {
			ratio = new Label("Ratio(V/D) : ");
		}
		else {
			double rat1 = (Stat.gagnej1 / Stat.perduj1);
			ratio = new Label("Ratio(V/D) : " + (double) Math.round(rat1 * 10) / 10);
		}
		
		if (Stat.perduj2 == 0) {
			ratio2 = new Label("Ratio(V/D) : ");
		}
		else {
			double rat2 = (Stat.gagnej2 / Stat.perduj2);
			ratio2 = new Label("Ratio(V/D) : " + (double) Math.round(rat2 * 10) / 10);
		}
		
		titre.setFont(new Font("Arial", 50));
		titre.setTextFill(Color.WHITE);
		titre.setAlignment(Pos.CENTER);
		
		AnchorPane.setTopAnchor(titre, 100.0);
		AnchorPane.setLeftAnchor(titre, 300.0);
		AnchorPane.setRightAnchor(titre, 300.0);
		
		VBox1.setStyle("-fx-background-color: rgba(0,0,0,0.0);"	+ "-fx-border-color: #EEEEEE");
		VBox2.setStyle("-fx-background-color: rgba(0,0,0,0.0);" + "-fx-border-color: #EEEEEE");	
		Retour.setStyle("-fx-background-color: #EEEEEE; ");
		
		Font font = Font.font("Arial", 24);
		Joueur1.setTextFill(Color.WHITE);
		Joueur2.setTextFill(Color.WHITE);
		victoire.setTextFill(Color.WHITE);
		defaite.setTextFill(Color.WHITE);
		matchNul.setTextFill(Color.WHITE);
		ratio.setTextFill(Color.WHITE);
		victoire2.setTextFill(Color.WHITE);
		defaite2.setTextFill(Color.WHITE);
		matchNul2.setTextFill(Color.WHITE);
		ratio2.setTextFill(Color.WHITE);
		Joueur1.setFont(font);
		Joueur2.setFont(font);
		victoire.setFont(font);
		defaite.setFont(font);
		matchNul.setFont(font);
		ratio.setFont(font);
		victoire2.setFont(font);
		defaite2.setFont(font);
		matchNul2.setFont(font);
		ratio2.setFont(font);
		Retour.setFont(font);

		VBox1.setSpacing(10);
		VBox1.setAlignment(Pos.CENTER);
		VBox1.getChildren().add(Joueur1);
		VBox1.getChildren().add(victoire);
		VBox1.getChildren().add(defaite);
		VBox1.getChildren().add(matchNul);
		VBox1.getChildren().add(ratio);

		VBox2.setSpacing(10);
		VBox2.setAlignment(Pos.CENTER);
		VBox2.getChildren().add(Joueur2);
		VBox2.getChildren().add(victoire2);
		VBox2.getChildren().add(defaite2);
		VBox2.getChildren().add(matchNul2);
		VBox2.getChildren().add(ratio2);
		
		AnchorPane.setTopAnchor(VBox1, 250.0);
		AnchorPane.setLeftAnchor(VBox1, 300.0);
		AnchorPane.setRightAnchor(VBox1, 800.0);
		
		AnchorPane.setTopAnchor(VBox2, 250.0);
		AnchorPane.setLeftAnchor(VBox2, 800.0);
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