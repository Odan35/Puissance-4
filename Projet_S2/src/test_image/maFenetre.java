package test_image;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class maFenetre extends Stage  {
	
	private Image grille = new Image(maFenetre.class.getResourceAsStream("/assets/Grille_Puissance4_final.png"));

	public maFenetre (){
		this.setTitle("implementation image");
		this.setResizable(true);
		
		Scene laScene = new Scene(creerContenu(),260,275);
		this.setScene(laScene);
		this.sizeToScene();
	}
	Parent creerContenu(){
		ImageView imageGrille = new ImageView(grille);
		JetonCouleur imageJeton1 = new JetonCouleur("rouge");
		JetonCouleur imageJeton2 = new JetonCouleur("jaune");
		
		Group root = new Group();
		root.getChildren().addAll(imageGrille, imageJeton1.creerJeton(), imageJeton2.creerJeton());
		return root;
	}
}
