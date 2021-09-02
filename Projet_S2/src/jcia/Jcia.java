package jcia;

import java.util.Optional;
import java.util.Random;

import fenetres.FenAccueil;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
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
import jcj.Verification;
import test_image.JetonCouleur;

public class Jcia extends Stage{
	
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
    
    private int pointJ1 = 0;
    private int pointJ2 = 0;
    
    private int con = 0;
    
    private ImageView P1; // jeton joueur1
    private ImageView P2; // jeton joueur2
    private ImageView P; // jeton haut

    private Image imgTour = new Image(Jcia.class.getResourceAsStream("/assets/confirm_tour.png"));
    private ImageView idtour; // indicateur tour
	
    private Image grille = new Image(Jcia.class.getResourceAsStream("/assets/Grille_Puissance4_final.png")); //676*611

	Label	j1	= new Label("Joueur");
	Label	j2	= new Label("IA");
	
    final int[][] tab = new int[7][7];
    private Scene maScene;
    private Group racine;
    int i = 0;
    int j = 0;
    private int colonne = 0;
    private int ligne;
    private boolean victoire = false;
    private int tour = 1;
    private int temp;
    private String couleur = "rouge";
    private boolean placer = false;
    private boolean speciale;
    private int tourMax = 41;

    public Jcia(boolean spe) {
        this.setTitle("Puissance 4");
        this.setResizable(false);
        this.speciale = spe;
        tab[i][j] = 1;
        
        maScene = new Scene(creerContenu(),1280,720);
        this.setScene(maScene);

        maScene.setOnKeyPressed(this::deplacerPion);
    }
    
    private void IA() {
    	if (VerificationIA.danger) {
    		temp = colonne;
    		colonne = VerificationIA.posC;
    		while (ligne == 0 && tab[colonne][ligne + 1] != 0) {
    			Random random = new Random();
    			colonne = random.nextInt(7);
    		}
    	}
    	else {
    		temp = colonne;
            Random random = new Random();
            colonne = random.nextInt(7);
            while (ligne == 0 && tab[colonne][ligne + 1] != 0) {
    			random = new Random();
    			colonne = random.nextInt(7);
    		}
    	}
    	
        espace();
        if (jt.getCouleur()==couleurJetonJ2 && !victoire && tour%2==0) {
        	if (colonne >= 0 && colonne <= 6 && tab[colonne][1] != 0) {
            	espace();
        	}
        }
    }
    
    private void espace() {
    	while(ligne<7 && !placer) {
        	if (ligne == 0 && tab[colonne][ligne + 1] != 0) {
        		placer = true;
        	}
        	else if (ligne == 6) {
        		 if (couleur == couleurJetonJ1) {
        			 tab[colonne][ligne] = 1;
        			 if (VerificationIA.verifGenerale(ligne, colonne, couleur, tab)==true && speciale == false) {
        				 System.out.println("Le joueur rouge à gagné !");
        				 Alert alert1 = new Alert(AlertType.NONE, "Le joueur 1 à gagné !");
        				 alert1.setHeaderText(null);
        	             alert1.setTitle("Fin de partie !");
        	             alert1.getButtonTypes().clear();
        	             alert1.getButtonTypes().addAll(rejouer,quitter);
        	             Optional<ButtonType> option = alert1.showAndWait();
        	             if (option.get()==quitter) {
        	            	FenAccueil page1 = new FenAccueil();
        	             	page1.show();
        	             	this.close();
        	             }
        	             else if (option.get()==rejouer) {
        	            	 this.close();
        	            	 Jcia jeu = new Jcia(false);
        	            	 jeu.show();
        	             }
        				 victoire = true;
        			 }
                 }
                 else {
                	 tab[colonne][ligne] = 2;
                	 if (VerificationIA.verifGenerale(ligne, colonne, couleur, tab)==true && speciale == false) {
        				 System.out.println("L'ordinateur à gagné !");
        				 Alert alert2 = new Alert(AlertType.NONE, "L'ordinateur à gagné !");
        				 alert2.setHeaderText(null);
        	             alert2.setTitle("Fin de partie !");
        	             alert2.getButtonTypes().clear();
        	             alert2.getButtonTypes().addAll(rejouer,quitter);
        	             Optional<ButtonType> option = alert2.showAndWait();
        	             if (option.get()==quitter) {
        	            	FenAccueil page1 = new FenAccueil();
        	             	page1.show();
        	             	this.close();
        	             }
        	             else if (option.get()==rejouer) {
        	            	 this.close();
        	            	 Jcia jeu = new Jcia(false);
        	            	 jeu.show();
        	             }
        				 victoire = true;
        			 }
                 }
        		placer = true; 
        		JetonCouleur PTa = new JetonCouleur(couleur);
                ImageView PT;
                if (couleur == couleurJetonJ1) {
                	PT = PTa.changeCouleurJeton(couleur);
                	couleur = couleurJetonJ2;
                	idtour.setTranslateX(idtour.getTranslateX()+970);
                	jt.aled(this.couleur);
                	P = jt.getImageView();
                }
                else {
                	PT = PTa.changeCouleurJeton(couleur);
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
        		if (couleur == couleurJetonJ1)  {
       			 	tab[colonne][ligne] = 1;
       			 	if (VerificationIA.verifGenerale(ligne, colonne, couleur, tab)==true && speciale == false) {
       			 		System.out.println("Le joueur rouge à gagné !");
       			 		Alert alert3 = new Alert(AlertType.NONE, "Le joueur 1 à gagné !");
       			 		alert3.setHeaderText(null);
       			 		alert3.setTitle("Fin de partie !");
       			 		alert3.getButtonTypes().clear();
       			 		alert3.getButtonTypes().addAll(rejouer,quitter);
       			 		Optional<ButtonType> option = alert3.showAndWait();
       			 		if (option.get()==quitter) {
       			 			FenAccueil page1 = new FenAccueil();
       			 			page1.show();
       			 			this.close();
       			 		}
       			 		else if (option.get()==rejouer) {
       			 			this.close();
       			 			Jcia jeu = new Jcia(false);
       			 			jeu.show();
       			 		}
       			 		victoire = true;
       			 	}
                }
                else {
               	 	tab[colonne][ligne] = 2;
               	 	if (VerificationIA.verifGenerale(ligne, colonne, couleur, tab)==true && speciale == false) {
               	 		System.out.println("L'ordinateur à gagné !");
               	 		Alert alert4 = new Alert(AlertType.NONE, "L'ordinateur à gagné !");
               	 		alert4.setHeaderText(null);
               	 		alert4.setTitle("Fin de partie !");
               	 		alert4.getButtonTypes().clear();
               	 		alert4.getButtonTypes().addAll(rejouer,quitter);
               	 		Optional<ButtonType> option = alert4.showAndWait();
               	 		if (option.get()==quitter) {
               	 			FenAccueil page1 = new FenAccueil();
               	 			page1.show();
               	 			this.close();
               	 		}
               	 		else if (option.get()==rejouer) {
               	 			this.close();
               	 			Jcia jeu = new Jcia(false);
               	 			jeu.show();
               	 		}
               	 		victoire = true;
               	 	}
                }
        		placer = true;
        		JetonCouleur PTa = new JetonCouleur(couleur);
                ImageView PT;
                if (couleur == "rouge") {
                	PT = PTa.changeCouleurJeton(couleur);
                	couleur = couleurJetonJ2;
                	idtour.setTranslateX(idtour.getTranslateX()+970);
                	jt.aled(this.couleur);
                	P = jt.getImageView();
                }
                else {
                	PT = PTa.changeCouleurJeton(couleur);
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
        System.out.println("\nTour IA");
        System.out.println("Colonne : " + colonne);
        if (!victoire) {
        	if (tour%2==0 && couleur==couleurJetonJ2) {
             	IA();
             	colonne = temp;
            }
        }
        if (!victoire && tour >= tourMax && speciale == false) {
        	Alert alert5 = new Alert(AlertType.NONE, "Egalité, pas de gagnant !");
        	alert5.setHeaderText(null);
        	alert5.setTitle("Fin de partie !");
        	alert5.getButtonTypes().clear();
            alert5.getButtonTypes().addAll(rejouer,quitter);
            Optional<ButtonType> option = alert5.showAndWait();
            if (option.get()==quitter) {
             	this.close();
            	FenAccueil page1 = new FenAccueil();
             	page1.show();
            }
            else if (option.get()==rejouer) {
            	 this.close();
            	 Jcia jeu = new Jcia(false);
            	 jeu.show();
            }
    	}
        if (tour > tourMax && speciale == true) {
        	pointJ1 = Verification.verifGenerale(1, tab);
        	pointJ2 = Verification.verifGenerale(2, tab);
        	if (pointJ1 > pointJ2) {
        			System.out.println("Le joueur rouge à gagné !");
        			if (con == 0) {
        				Alert alert6 = new Alert(AlertType.NONE, "Nombre de puissance 4 joueur 1 : " + pointJ1 + "\nNombre de puissance 4 ordinateur : " + pointJ2 + "\nLe joueur 1 à gagné !");
    				 	alert6.setHeaderText(null);
    				 	alert6.setTitle("Fin de partie !");
    				 	alert6.getButtonTypes().clear();
    				 	alert6.getButtonTypes().addAll(rejouer,quitter);
    				 	Optional<ButtonType> option = alert6.showAndWait();
    				 	if (option.get()==quitter) {
    				 		this.close();
    				 		FenAccueil page1 = new FenAccueil();
    				 		page1.show();
    				 		con = 0;
    				 	}
    				 	else if (option.get()==rejouer) {
    				 		this.close();
    				 		Jcia jeu = new Jcia(true);
    				 		jeu.show();
    				 	}
    				 	victoire = true;
    				 	con = 1;
        			}	
        	}
        	else if (pointJ2 > pointJ1) {
        			System.out.println("Le joueur jaune à gagné !");
        			if (con == 0) {
        				Alert alert7 = new Alert(AlertType.NONE, "Nombre de puissance 4 joueur 1 : " + pointJ1 + "\nNombre de puissance 4 ordinateur : " + pointJ2 + "\nL'ordinateur à gagné !");
    				 	alert7.setTitle("Fin de partie !");
    				 	alert7.getButtonTypes().clear();
    				 	alert7.getButtonTypes().addAll(rejouer,quitter);
    				 	Optional<ButtonType> option = alert7.showAndWait();
    				 	if (option.get()==quitter) {
    				 		this.close();
    				 		FenAccueil page1 = new FenAccueil();
    				 		page1.show();
    				 		con = 0;
    				 	}
    				 	else if (option.get()==rejouer) {
    				 		this.close();
    				 		Jcia jeu = new Jcia(true);
    				 		jeu.show();
    				 	}
    				 	victoire = true;
    				 	con = 1;
        			}
        		}
        	else if (pointJ1 == pointJ2) {
        		if (con == 0) {
        			Alert alert8 = new Alert(AlertType.NONE, "Nombre de puissance 4 joueur 1 : " + pointJ1 + "\nNombre de puissance 4 ordinateur : " + pointJ2 + "\nEgalité, pas de gagnant !");
        			alert8.setHeaderText(null);
        			alert8.setTitle("Fin de partie !");
        			alert8.getButtonTypes().clear();
        			alert8.getButtonTypes().addAll(rejouer,quitter);
        			Optional<ButtonType> option = alert8.showAndWait();
        			if (option.get()==quitter) {
        				this.close();
        				FenAccueil page1 = new FenAccueil();
        				page1.show();
        				con = 0;
        			}
        			else if (option.get()==rejouer) {
        				this.close();
        				Jcia jeu = new Jcia(true);
        				jeu.show();
        			}
        			con = 1;
        		}		
        	}
        }
    }
    
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
        	espace();
        }
    }

    Parent creerContenu(){

        racine = new Group();

        couleur = couleurJetonJ1;
        
        jt = new JetonCouleur(couleur);
    	P = jt.creerJeton();
    	P.setX(302+26);
        
    	Font font = Font.font("Arial", 30);
    	
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

        racine.getChildren().add(fond);

        racine.getChildren().add(imageGrille);
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
