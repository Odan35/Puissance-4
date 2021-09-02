package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Page2 extends Stage {
	
	Label titre = new Label("Statistiques");
	Label Joueur1 = new Label("Joueur 1");
	Label Joueur2 = new Label("Joueur 2");	
	Label victoire = new Label("Victoire(s)");
	Label defaite = new Label("Défaite(s)");
	Label matchNul = new Label("Match nul(s)");
	Label ratio = new Label("Ratio(V/D)");
	Label victoire2 = new Label("Victoire(s)");
	Label defaite2 = new Label("Défaite(s)");
	Label matchNul2 = new Label("Match nul(s)");
	Label ratio2 = new Label("Ratio(V/D)");
	VBox VBox1 = new VBox();
	VBox VBox2 = new VBox();
	Button Retour = new Button("Retour");
	
	public Page2() {
		this.setTitle("Statistiques");
		
		Scene scene = new Scene(this.creerContenu(), 500, 500);
		this.setScene(scene);
		this.setResizable(false);
		Retour.setOnAction(e -> retour());
	}
	
	private void retour() {
		Page1 page1 = new Page1();
		this.hide();
		page1.show();
	}
	
	private AnchorPane creerContenu() {
		AnchorPane root = new AnchorPane();
		
		
		
		
		
		titre.setFont(new Font("Arial", 30));
		
		VBox1.getChildren().add(Joueur1);
		VBox1.getChildren().add(victoire);
		VBox1.getChildren().add(defaite);
		VBox1.getChildren().add(matchNul);
		VBox1.getChildren().add(ratio);
		
		VBox2.getChildren().add(Joueur2);
		VBox2.getChildren().add(victoire2);
		VBox2.getChildren().add(defaite2);
		VBox2.getChildren().add(matchNul2);
		VBox2.getChildren().add(ratio2);
		
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