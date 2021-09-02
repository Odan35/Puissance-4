package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Page1 extends Stage {
	
	Label titre = new Label("Puissance 4");
	Button jouer = new Button("Jouer");
	Button stats = new Button("Stats");
	Button quitter = new Button("Quitter");
	public Page1() {
		this.setTitle("Page d'accueil");
	
		
		Scene scene = new Scene(this.creerContenu(), 500, 500);
		this.setScene(scene);
		this.setResizable(false);
		jouer.setOnAction(e -> jouer());
		stats.setOnAction(e -> stats());
		quitter.setOnAction(e -> quitter());
		

	}
	
	private void quitter() {
		System.exit(0);
	}
	
	private void jouer() {
		Page3 page3 = new Page3();
		this.hide();
		page3.show();
	}
	
	private void stats() {
		Page2 page2 = new Page2();
		this.hide();
		page2.show();
	}
	
	private AnchorPane creerContenu() {
		AnchorPane root = new AnchorPane();
		

		
		titre.setFont(new Font("Arial", 30));
		

		
		AnchorPane.setTopAnchor(titre, 20.0);
		AnchorPane.setLeftAnchor(titre, 170.0);
		AnchorPane.setRightAnchor(titre, 150.0);
		
		AnchorPane.setTopAnchor(jouer, 160.0);
		AnchorPane.setLeftAnchor(jouer, 150.0);
		AnchorPane.setRightAnchor(jouer, 150.0);
		
		AnchorPane.setTopAnchor(stats, 220.0);
		AnchorPane.setLeftAnchor(stats, 150.0);
		AnchorPane.setRightAnchor(stats, 150.0);
		
		AnchorPane.setTopAnchor(quitter, 280.0);
		AnchorPane.setLeftAnchor(quitter, 150.0);
		AnchorPane.setRightAnchor(quitter, 150.0);
		
		root.getChildren().addAll(titre);
		root.getChildren().addAll(jouer);
		root.getChildren().addAll(stats);
		root.getChildren().addAll(quitter);
		return root;
	}
}