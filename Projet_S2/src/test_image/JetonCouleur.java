package test_image;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class JetonCouleur {
	
	private String couleur;
	private Image image;
	private ImageView imageView;
	
    public JetonCouleur(String i_couleur) {
    	this.couleur = i_couleur;
    	this.image = this.creerImageJeton();
    }
    
    public ImageView creerJeton() {
    	imageView = new ImageView(creerImageJeton());
    	return imageView;
    }
    public ImageView changeCouleurJeton(String i_couleur) {
    	this.couleur = i_couleur;
    	imageView = new ImageView(creerImageJeton());
    	return imageView;
    }
    public void aled(String i_couleur) {
    	this.couleur = i_couleur;
    	imageView.setImage(creerImageJeton());
    }
    
    public Image creerImageJeton() {
    	if (this.couleur == "rouge") {
    		image = new Image(maFenetre.class.getResourceAsStream("/assets/jeton_rouge.png"));
    	}
    	if (this.couleur == "jaune") {
    		image = new Image(maFenetre.class.getResourceAsStream("/assets/jeton_jaune.png"));
    	}
    	if (this.couleur == "vert") {
    		image = new Image(maFenetre.class.getResourceAsStream("/assets/jeton_vert.png"));
    	}
    	if (this.couleur == "cyan") {
    		image = new Image(maFenetre.class.getResourceAsStream("/assets/jeton_cyan.png"));
    	}
    	if (this.couleur == "orange") {
    		image = new Image(maFenetre.class.getResourceAsStream("/assets/jeton_orange.png"));
    	}
    	if (this.couleur == "violet") {
    		image = new Image(maFenetre.class.getResourceAsStream("/assets/jeton_violet.png"));
    	}
    	if (this.couleur == "cercle") {
    		image = new Image(maFenetre.class.getResourceAsStream("/assets/jeton_morpion_cercle.png"));
    	}
    	if (this.couleur == "croix") {
    		image = new Image(maFenetre.class.getResourceAsStream("/assets/jeton_morpion_croix.png"));
    	}
		return image;
    }
    
    
    
    public String getCouleur() {
    	return this.couleur;
    }
    public Image getImg() {
    	return this.image;
    }
    public ImageView getImageView() {
    	return this.imageView;
    }
    
	

}
