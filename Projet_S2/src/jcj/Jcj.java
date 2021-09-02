package jcj;

import java.util.Optional;

import fenetres.FenAccueil;
import fenetres.Stat;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import test_image.JetonCouleur;

public class Jcj extends Stage{
	
	Stop[] 			stops 	= new Stop[] { new Stop(0, Color.web("#FFFFFF")), new Stop(1, Color.web("#777777"))};  //degrade #0000FF to #000000
    LinearGradient 	lg1 	= new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops); 
    
	//Button	quitter	= new Button("Quitter");

	private static String couleurJetonJ1 = "rouge"; // pour creation de jeton
	private static String couleurJetonJ2 = "jaune";
	
	private JetonCouleur jt; //78 taille
    private JetonCouleur jt1; // jeton joueur1
    private JetonCouleur jt2; // jeton joueur2
	
    private ButtonType quitter = new ButtonType("Quitter");
    private ButtonType rejouer = new ButtonType("Rejouer");
    
    private ImageView P1; // jeton joueur1
    private ImageView P2; // jeton joueur2
    private ImageView P; // jeton haut

    private Image imgTour = new Image(Jcj.class.getResourceAsStream("/assets/confirm_tour.png"));
    private ImageView idtour; // indicateur tour
	
    private Image grille = new Image(Jcj.class.getResourceAsStream("/assets/Grille_Puissance4_final.png")); //676*611

	Label	j1	= new Label("Joueur 1");
	Label	j2	= new Label("Joueur 2");
	
	private int pointJ1 = 0;
	private int pointJ2 = 0;
	
    final int[][] tab = new int[7][7];
    final Scene maScene;
    private Group racine;
    int i = 0;
    int j = 0;
    int colonne = 0;
    private int ligne = 0, joueur;
    private String couleur = "rouge";
    private boolean placer = false;
    private boolean victoire = false;
    private int tour = 0;
    private Stat stat = new Stat();
    private boolean speciale;

    public Jcj(boolean spe) {
        this.setTitle("Puissance 4");
        this.setResizable(false);
        this.speciale = spe;
        tab[i][j] = 1;

		maScene = new Scene(creerContenu(),1280,720);
        this.setScene(maScene);

        /*quitter.setOnMousePressed( e -> quitter());*/
        maScene.setOnKeyPressed(this::deplacerPion);
    }
    
	/*private void quitter() {
		System.exit(0);
	}*/
	
    private void deplacerPion(KeyEvent e) {
        if (e.getCode()==KeyCode.RIGHT) {
            if (P.getTranslateX()<546) {
            	P.setTranslateX(P.getTranslateX()+91);
                colonne++;
                tab[i+1][j] = 1;
                tab[i][j] = 0;
                i++;
                for(int col=0;col<7;col++) {
                    for (int lig=0;lig<7;lig++) {
                        System.out.print(tab[lig][col]);
                    }
                    System.out.print("\n");
                }
                System.out.println("Colonne : " + colonne);
            }
        }
        else if (e.getCode()==KeyCode.LEFT) {
            if (P.getTranslateX()>0) {
            	P.setTranslateX(P.getTranslateX()-91);
                colonne--;
                tab[i-1][j] = 1;
                tab[i][j] = 0;
                i--;
                for(int col=0;col<7;col++) {
                    for (int lig=0;lig<7;lig++) {
                        System.out.print(tab[lig][col]);
                    }
                    System.out.print("\n");
                }
                System.out.println("Colonne : " + colonne);
            }
        }
        else if (e.getCode()==KeyCode.SPACE) {
            while(ligne<7 && !placer) {
            	if (ligne == 0 && tab[colonne][ligne + 1] != 0) {
            		placer = true;
            	}
            	else if (ligne == 6) {
            		 if (couleur == couleurJetonJ1) {
            			 joueur=1;
            			 tab[colonne][ligne] = 1;
            			 if (Verification.verifGenerale(joueur, tab)>=1 && speciale == false) {
            				 System.out.println("Le joueur rouge à gagné !");
            				 Alert alert = new Alert(AlertType.NONE, "Le joueur 1 à gagné !");
            				 alert.setHeaderText(null);
            	             alert.setTitle("Fin de partie !");
            	             alert.getButtonTypes().clear();
            	             alert.getButtonTypes().addAll(rejouer,quitter);
            	             Optional<ButtonType> option = alert.showAndWait();
            	             if (option.get()==quitter) {
            	            	FenAccueil page1 = new FenAccueil();
            	             	page1.show();
            	             	this.hide();
            	             }
            	             else if (option.get()==rejouer) {
            	            	 this.hide();
            	            	 Jcj jeu = new Jcj(false);
            	            	 jeu.show();
            	             }
            	             
            				 stat.jouer_g(1);
            				 stat.jouer_p(2);
            				 stat.match_jouer();
            				 victoire = true;
            			 }	 
                     }
                     else {
                    	 joueur=2;
                    	 tab[colonne][ligne] = 2;
                    	 if (Verification.verifGenerale(joueur, tab)>=1 && speciale == false) {
            				 System.out.println("Le joueur jaune à gagné !");
            				 Alert alert = new Alert(AlertType.NONE, "Le joueur 2 à gagné !");
            				 alert.setHeaderText(null);
            	             alert.setTitle("Fin de partie !");
            	             alert.getButtonTypes().clear();
            	             alert.getButtonTypes().addAll(rejouer,quitter);
            	             Optional<ButtonType> option = alert.showAndWait();
            	             if (option.get()==quitter) {
            	            	FenAccueil page1 = new FenAccueil();
            	             	page1.show();
            	             	this.close();
            	             }
            	             else if (option.get()==rejouer) {
            	            	 this.close();
            	            	 Jcj jeu = new Jcj(false);
            	            	 jeu.show();
            	             }
            	             
            				 stat.jouer_g(2);
            				 stat.jouer_p(1);
            				 stat.match_jouer();
            				 victoire = true;
            			 }
                     }
            		placer = true; 
                    JetonCouleur PTa = new JetonCouleur(couleur);
                    ImageView PT;
                    if (couleur == couleurJetonJ1) {
                    	joueur=1;
                    	PT = PTa.changeCouleurJeton(couleur);
                    	System.out.println(Verification.verifGenerale(joueur, tab));
                    	couleur = couleurJetonJ2;
                    	idtour.setTranslateX(idtour.getTranslateX()+970);
                    	jt.aled(this.couleur);
                    	P = jt.getImageView();
                    }
                    else {
                    	joueur=2;
                    	PT = PTa.changeCouleurJeton(couleur);
                        System.out.println(Verification.verifGenerale(joueur, tab));
                    	couleur = couleurJetonJ1;
                    	idtour.setTranslateX(idtour.getTranslateX()-970);
                    	jt.aled(this.couleur);
                    	P = jt.getImageView();
                    }
                    PT.setX(302+26 + (colonne*91));
                    PT.setY(13 + (ligne*91));
                    racine.getChildren().add(PT);
                }
            	else if (tab[colonne][ligne + 1] != 0) {
            		if (couleur == couleurJetonJ1) {
            			joueur=1;
            			tab[colonne][ligne] = 1;
           			 	if (Verification.verifGenerale(joueur, tab)>=1 && speciale == false) {
           			 		System.out.println("Le joueur rouge à gagné !");
           			 		Alert alert = new Alert(AlertType.NONE, "Le joueur 1 à gagné !");
           			 		alert.setHeaderText(null);
           			 		alert.setTitle("Fin de partie !");
           			 		alert.getButtonTypes().clear();
           			 		alert.getButtonTypes().addAll(rejouer,quitter);
           			 		Optional<ButtonType> option = alert.showAndWait();
           			 		if (option.get()==quitter) {
           			 			FenAccueil page1 = new FenAccueil();
           			 			page1.show();
           			 			this.close();
		       	            }
		       	            else if (option.get()==rejouer) {
		       	            	this.close();
		       	            	Jcj jeu = new Jcj(false);
		       	            	jeu.show();
		       	            }
           			 		
           			 		stat.jouer_g(1);
           			 		stat.jouer_p(2);
           			 		stat.match_jouer();
           			 		victoire = true;
           			 	}
                    }
                    else {
                    	joueur=2;
                    	tab[colonne][ligne] = 2;
                   	 	if (Verification.verifGenerale(joueur, tab)>=1 && speciale == false) {
                   	 		System.out.println("Le joueur jaune à gagné !");
                   	 		Alert alert = new Alert(AlertType.NONE, "Le joueur 2 à gagné !");
                   	 		alert.setHeaderText(null);
                   	 		alert.setTitle("Fin de partie !");
                   	 		alert.getButtonTypes().clear();
                   	 		alert.getButtonTypes().addAll(rejouer,quitter);
                   	 		Optional<ButtonType> option = alert.showAndWait();
                   	 		if (option.get()==quitter) {
                   	 			FenAccueil page1 = new FenAccueil();
                   	 			page1.show();
                   	 			this.close();
                   	 		}
                   	 		else if (option.get()==rejouer) {
                   	 			this.close();
                   	 			Jcj jeu = new Jcj(false);
                   	 			jeu.show();
                   	 		}
                   	 		
                   	 		stat.jouer_g(2);
                   	 		stat.jouer_p(1);
                   	 		stat.match_jouer();
                   	 		victoire = true;
                   	 	}
                    }
            		placer = true;
            		JetonCouleur PTa = new JetonCouleur(couleur);
                    ImageView PT;
                    if (couleur == couleurJetonJ1) {
                    	joueur=1;
                    	PT = PTa.changeCouleurJeton(couleur);
                        System.out.println(Verification.verifGenerale(joueur, tab));
                    	couleur = couleurJetonJ2;
                    	idtour.setTranslateX(idtour.getTranslateX()+970);
                    	jt.aled(this.couleur);
                    	P = jt.getImageView();
                    }
                    else {
                    	joueur=2;
                    	PT = PTa.changeCouleurJeton(couleur);
                        System.out.println(Verification.verifGenerale(joueur, tab));
                    	couleur = couleurJetonJ1;
                    	idtour.setTranslateX(idtour.getTranslateX()-970);
                    	jt.aled(this.couleur);
                    	P = jt.getImageView();
                    }
                    PT.setX(302+26 + (colonne*91));
                    PT.setY(13 + (ligne*91));
                    racine.getChildren().add(PT);
                }
                ligne++;
            }
            tour++;
            placer = false;
            ligne = 0;
            for(int col=0;col<7;col++) {
                for (int lig=0;lig<7;lig++) {
                    System.out.print(tab[lig][col]);
                }
                System.out.print("\n");
            }
            System.out.println("Colonne : " + colonne);
            if (!victoire && tour >= 42 && speciale == false) {
            	Alert alert = new Alert(AlertType.NONE, "Egalité, pas de gagnant !");
            	alert.setHeaderText(null);
            	alert.setTitle("Fin de partie !");
            	alert.getButtonTypes().clear();
	            alert.getButtonTypes().addAll(rejouer,quitter);
	            Optional<ButtonType> option = alert.showAndWait();
	            if (option.get()==quitter) {
	            	FenAccueil page1 = new FenAccueil();
	             	page1.show();
	             	this.close();
	            }
	            else if (option.get()==rejouer) {
	            	 this.close();
	            	 Jcj jeu = new Jcj(false);
	            	 jeu.show();
	            }
        		stat.match_nul();
        	}
            if (tour >= 42 && speciale == true) {
            	pointJ1 = Verification.verifGenerale(1, tab);
            	pointJ2 = Verification.verifGenerale(2, tab);
            	if (pointJ1 > pointJ2) {
            		System.out.println("Le joueur rouge à gagné !");
   				 	Alert alert = new Alert(AlertType.NONE, "Nombre de puissance 4 joueur 1 : " + pointJ1 + "\nNombre de puissance 4 joueur 2 : " + pointJ2 + "\nLe joueur 1 à gagné !");
   				 	alert.setHeaderText(null);
   				 	alert.setTitle("Fin de partie !");
   				 	alert.getButtonTypes().clear();
   				 	alert.getButtonTypes().addAll(rejouer,quitter);
   				 	Optional<ButtonType> option = alert.showAndWait();
   				 	if (option.get()==quitter) {
   				 		FenAccueil page1 = new FenAccueil();
   				 		page1.show();
   				 		this.close();
   				 	}
   				 	else if (option.get()==rejouer) {
   				 		this.close();
   				 		Jcj jeu = new Jcj(true);
   				 		jeu.show();
   				 	}
   	             
   				 	stat.jouer_g(1);
   				 	stat.jouer_p(2);
   				 	stat.match_jouer();
   				 	victoire = true;
            	}
            	else if (pointJ2 > pointJ1) {
            		System.out.println("Le joueur jaune à gagné !");
            		Alert alert = new Alert(AlertType.NONE, "Nombre de puissance 4 joueur 1 : " + pointJ1 + "\nNombre de puissance 4 joueur 2 : " + pointJ2 + "\nLe joueur 2 à gagné !");
   				 	alert.setHeaderText(null);
   				 	alert.setTitle("Fin de partie !");
   				 	alert.getButtonTypes().clear();
   				 	alert.getButtonTypes().addAll(rejouer,quitter);
   				 	Optional<ButtonType> option = alert.showAndWait();
   				 	if (option.get()==quitter) {
   				 		FenAccueil page1 = new FenAccueil();
   				 		page1.show();
   				 		this.close();
   				 	}
   				 	else if (option.get()==rejouer) {
   				 		this.close();
   				 		Jcj jeu = new Jcj(true);
   				 		jeu.show();
   				 	}
   	             
   				 	stat.jouer_g(2);
   				 	stat.jouer_p(1);
   				 	stat.match_jouer();
   				 	victoire = true;
            	}
            	else {
            		Alert alert = new Alert(AlertType.NONE, "Nombre de puissance 4 joueur 1 : " + pointJ1 + "\nNombre de puissance 4 joueur 2 : " + pointJ2 + "\nEgalité, pas de gagnant !");
                	alert.setHeaderText(null);
                	alert.setTitle("Fin de partie !");
                	alert.getButtonTypes().clear();
    	            alert.getButtonTypes().addAll(rejouer,quitter);
    	            Optional<ButtonType> option = alert.showAndWait();
    	            if (option.get()==quitter) {
    	            	FenAccueil page1 = new FenAccueil();
    	             	page1.show();
    	             	this.close();
    	            }
    	            else if (option.get()==rejouer) {
    	            	 this.close();
    	            	 Jcj jeu = new Jcj(true);
    	            	 jeu.show();
    	            }
            		stat.match_nul();
            	}
            }
        }
    }

    Parent creerContenu(){

        racine = new Group();
        
        couleur = couleurJetonJ1;
        
        jt = new JetonCouleur(couleur);
    	P = jt.creerJeton();
    	P.setX(302+26);
    	
		Font font = Font.font("Arial", 30);
        /*
		quitter.setFont(font);
		quitter.setStyle("-fx-background-color: #EEEEEE; ");
		quitter.setLayoutX(1080);
		quitter.setLayoutY(600);*/

		j1.setFont(font);
    	j1.setLayoutX(100);
    	j1.setLayoutY(100);
    	
		j2.setFont(font);
    	j2.setLayoutX(1070);
    	j2.setLayoutY(100);
		

        jt1 = new JetonCouleur(couleurJetonJ1);
    	P1 = jt1.creerJeton();
    	P1.setX(100+26);
    	P1.setY(150);
    	

        jt2 = new JetonCouleur(couleurJetonJ2);
    	P2 = jt2.creerJeton();
    	P2.setX(1070+26);
    	P2.setY(150);

        idtour = new ImageView(imgTour);
    	idtour.setX(115);
    	idtour.setY(139);
    	
		ImageView imageGrille = new ImageView(grille);
		imageGrille.setY(78);
		imageGrille.setX(302);
		
		Rectangle fond = new Rectangle(0, 0, 1280, 720);
        fond.setFill(lg1);
		racine.getChildren().addAll(fond);

        racine.getChildren().add(imageGrille);
        /*racine.getChildren().add(quitter);*/ //çaaaaaaaaaa bugggggggg ,  haaaaaaaaaaaaaaaaaaaaa
        racine.getChildren().add(P);
        racine.getChildren().add(j1);
        racine.getChildren().add(j2);
        racine.getChildren().add(P1);
        racine.getChildren().add(P2);
        racine.getChildren().add(idtour);

        return racine;
    }

    public static void changeCouleurJetonJ1(String c) {
    	couleurJetonJ1 = c ;
    }
    public static void changeCouleurJetonJ2(String c) {
    	couleurJetonJ2 = c ;
    }

	public static String getCouleurJeton1() {
		return couleurJetonJ1;
	}
	public static String getCouleurJeton2() {
		return couleurJetonJ2;
	}
}
