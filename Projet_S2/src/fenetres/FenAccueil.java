package fenetres;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FenAccueil extends Stage {
	
	Stop[] 			stops 	= new Stop[] { new Stop(0, Color.web("#0000FF")), new Stop(1, Color.web("#000000"))};  //degrade #0000FF to #000000
    LinearGradient 	lg1 	= new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops); 
	
	Label	titre	= new Label("Puissance 4");
	Button	jouer	= new Button("Jouer");
	Button	stats	= new Button("Stats");
	Button	quitter	= new Button("Quitter");
	Button	assets	= new Button("Jetons");
	
	public FenAccueil() {
		this.setTitle("Puissance 4: Page d'accueil");
	
		Scene scene = new Scene(this.creerContenu(), 1280, 720);
		this.setScene(scene);
		this.setResizable(false);
		
		jouer.setOnAction(e -> jouer());
		stats.setOnAction(e -> stats());
		quitter.setOnAction(e -> quitter());
		assets.setOnAction(e -> assets());
	}
	
	private void quitter() {
		System.exit(0);
	}
	
	private void jouer() {
		FenModeDeJeu fenModeDeJeu = new FenModeDeJeu();
		this.close();
		fenModeDeJeu.show();
	}
	
	private void stats() {
		FenStats fenStats = new FenStats();
		this.close();
		fenStats.show();
	}

	private void assets() {
		FenChoixJeton fenChoixJeton = new FenChoixJeton();
		this.close();
		fenChoixJeton.show();
	}
	
	private AnchorPane creerContenu() {
		AnchorPane root = new AnchorPane();
		titre.setFont(new Font("Arial", 50));
		titre.setTextFill(Color.WHITE);
		titre.setAlignment(Pos.CENTER);
		
		AnchorPane.setTopAnchor(titre, 100.0);
		AnchorPane.setLeftAnchor(titre, 300.0);
		AnchorPane.setRightAnchor(titre, 300.0);

		jouer.setStyle("-fx-background-color: #EEEEEE; ");		
		stats.setStyle("-fx-background-color: #EEEEEE; ");		
		quitter.setStyle("-fx-background-color: #EEEEEE; ");
		assets.setStyle("-fx-background-color: #EEEEEE; ");
		
		Font font = Font.font("Arial", 30);
		jouer.setFont(font);
		stats.setFont(font);
		quitter.setFont(font);
		assets.setFont(font);
		
		AnchorPane.setTopAnchor(jouer, 300.0);
		AnchorPane.setLeftAnchor(jouer, 300.0);
		AnchorPane.setRightAnchor(jouer, 300.0);
		
		AnchorPane.setTopAnchor(stats, 400.0);
		AnchorPane.setLeftAnchor(stats, 300.0);
		AnchorPane.setRightAnchor(stats, 300.0);
		
		AnchorPane.setTopAnchor(quitter, 600.0);
		AnchorPane.setLeftAnchor(quitter, 300.0);
		AnchorPane.setRightAnchor(quitter, 700.0);

		AnchorPane.setTopAnchor(assets, 600.0);
		AnchorPane.setLeftAnchor(assets, 700.0);
		AnchorPane.setRightAnchor(assets, 300.0);
		
		
		Rectangle fond = new Rectangle(0, 0, 1280, 720);
        fond.setFill(lg1);
		root.getChildren().addAll(fond);
		
		root.getChildren().addAll(titre);
		root.getChildren().addAll(jouer);
		root.getChildren().addAll(stats);
		root.getChildren().addAll(quitter);
		root.getChildren().addAll(assets);
		return root;
	}
}