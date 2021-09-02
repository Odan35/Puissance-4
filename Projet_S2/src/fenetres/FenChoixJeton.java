	package fenetres;

	import jcia.Jcia;
	import jcj.Jcj;
import javafx.geometry.Pos;
	import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
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
	import test_image.maFenetre;

	public class FenChoixJeton extends Stage {

		Stop[] 			stops 	= new Stop[] { new Stop(0, Color.web("#0000FF")), new Stop(1, Color.web("#000000"))};  //degrade #0000FF to #000000
	    LinearGradient 	lg1 	= new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops); 
		
		Label	titre		= new Label("Choix\njeton");
		Label 	erreur		= new Label("Veuillez changer la couleur du jeton d'un des joueurs !");
		Label	ChoixDuJoueur1	= new Label("Jeton du joueur 1");	
		Label	ChoixDuJoueur2	= new Label("Jeton du joueur 2");
		
		VBox	VBox1	= new VBox();
		VBox	VBox2	= new VBox();

		Image 		jetJaune1 = new Image(maFenetre.class.getResourceAsStream("/assets/jeton(8).png"));
		Image 		jetRouge1 = new Image(maFenetre.class.getResourceAsStream("/assets/jeton(4).png"));
		Image 		jetJaune2 = new Image(maFenetre.class.getResourceAsStream("/assets/jeton(8).png"));
		Image 		jetRouge2 = new Image(maFenetre.class.getResourceAsStream("/assets/jeton(4).png"));
		Image 		jetVert1  = new Image(maFenetre.class.getResourceAsStream("/assets/jeton(5).png"));
		Image 		jetVert2  = new Image(maFenetre.class.getResourceAsStream("/assets/jeton(5).png"));
		Image 		jetCyan1  = new Image(maFenetre.class.getResourceAsStream("/assets/jeton(7).png"));
		Image 		jetCyan2  = new Image(maFenetre.class.getResourceAsStream("/assets/jeton(7).png"));
		Image 		jetOrange1  = new Image(maFenetre.class.getResourceAsStream("/assets/jeton(3).png"));
		Image 		jetOrange2  = new Image(maFenetre.class.getResourceAsStream("/assets/jeton(3).png"));
		Image 		jetViolet1  = new Image(maFenetre.class.getResourceAsStream("/assets/jeton(6).png"));
		Image 		jetViolet2  = new Image(maFenetre.class.getResourceAsStream("/assets/jeton(6).png"));
		Image 		jetMorCer1  = new Image(maFenetre.class.getResourceAsStream("/assets/jeton(1).png"));
		Image 		jetMorCer2  = new Image(maFenetre.class.getResourceAsStream("/assets/jeton(1).png"));
		Image 		jetMorCro1  = new Image(maFenetre.class.getResourceAsStream("/assets/jeton(2).png"));
		Image 		jetMorCro2  = new Image(maFenetre.class.getResourceAsStream("/assets/jeton(2).png"));
        ImageView 	imageJetJaune1 = new ImageView(jetJaune1);
        ImageView 	imageJetRouge1 = new ImageView(jetRouge1);
        ImageView 	imageJetJaune2 = new ImageView(jetJaune2);
        ImageView 	imageJetRouge2 = new ImageView(jetRouge2);
        ImageView 	imageJetVert1 = new ImageView(jetVert1);
        ImageView 	imageJetVert2 = new ImageView(jetVert2);
        ImageView 	imageJetCyan1 = new ImageView(jetCyan1);
        ImageView 	imageJetCyan2 = new ImageView(jetCyan2);
        ImageView 	imageJetOrange1 = new ImageView(jetOrange1);
        ImageView 	imageJetOrange2 = new ImageView(jetOrange2);
        ImageView 	imagejetViolet1 = new ImageView(jetViolet1);
        ImageView 	imagejetViolet2 = new ImageView(jetViolet2);
        ImageView 	imagejetMorCer1 = new ImageView(jetMorCer1);
        ImageView 	imagejetMorCer2 = new ImageView(jetMorCer2);
        ImageView 	imagejetMorCro1 = new ImageView(jetMorCro1);
        ImageView 	imagejetMorCro2 = new ImageView(jetMorCro2);

		Button	jetonJaune1	= new Button("", imageJetJaune1);
		Button	jetonRouge1	= new Button("", imageJetRouge1);
		Button	jetonVert1	= new Button("", imageJetVert1);
		Button	jetonCyan1	= new Button("", imageJetCyan1);
		Button	jetonOrange1	= new Button("", imageJetOrange1);
		Button	jetonViolet1	= new Button("", imagejetViolet1);
		Button	jetonMorCer1	= new Button("", imagejetMorCer1);
		Button	jetonMorCro1	= new Button("", imagejetMorCro1);
		
		Button	jetonJaune2	= new Button("", imageJetJaune2);
		Button	jetonRouge2	= new Button("", imageJetRouge2);
		Button	jetonVert2	= new Button("", imageJetVert2);
		Button	jetonCyan2	= new Button("", imageJetCyan2);
		Button	jetonOrange2	= new Button("", imageJetOrange2);
		Button	jetonViolet2	= new Button("", imagejetViolet2);
		Button	jetonMorCer2	= new Button("", imagejetMorCer2);
		Button	jetonMorCro2	= new Button("", imagejetMorCro2);
		
		Button	Retour	= new Button("Retour");
		
		public FenChoixJeton() {
			this.setTitle("Puissance 4: Choix des jetons");
			
			Scene scene = new Scene(this.creerContenu(), 1280, 720);
			this.setScene(scene);
			this.setResizable(false);

			jetonJaune1.setOnAction(e -> jJaune1());
			jetonRouge1.setOnAction(e -> jRouge1());
			jetonVert1.setOnAction(e -> jVert1());
			jetonCyan1.setOnAction(e -> jCyan1());
			jetonOrange1.setOnAction(e -> jOrange1());
			jetonViolet1.setOnAction(e -> jViolet1());
			jetonMorCer1.setOnAction(e -> jMorCer1());
			jetonMorCro1.setOnAction(e -> jMorCro1());
			
			jetonJaune2.setOnAction(e -> jJaune2());
			jetonRouge2.setOnAction(e -> jRouge2());
			jetonVert2.setOnAction(e -> jVert2());
			jetonCyan2.setOnAction(e -> jCyan2());
			jetonOrange2.setOnAction(e -> jOrange2());
			jetonViolet2.setOnAction(e -> jViolet2());
			jetonMorCer2.setOnAction(e -> jMorCer2());
			jetonMorCro2.setOnAction(e -> jMorCro2());
			
			Retour.setOnAction(e -> retour());
		}
		
		private void jJaune1() {
	        Jcj.changeCouleurJetonJ1("jaune");
	        Jcia.changeCouleurJetonJ1("jaune");
			if (Jcj.getCouleurJeton1() == Jcj.getCouleurJeton2()) {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Attention !");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Joueur 1 et joueur 2 ont la meme couleur de jeton \nVeuillez changer la couleur du jeton d'un des joueurs !");
		        alertjetonchange.showAndWait();
		        Retour.setDisable(true);
		        erreur.setOpacity(100);
			}
			else {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Confirmation");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Jeton de couleur pour joueur 1 devient de couleur " + Jcj.getCouleurJeton1());
		        alertjetonchange.showAndWait();
		        Retour.setDisable(false);
		        erreur.setOpacity(0);
			}
		}

		private void jRouge1() {
			Jcj.changeCouleurJetonJ1("rouge");
			Jcia.changeCouleurJetonJ1("rouge");
			if (Jcj.getCouleurJeton1() == Jcj.getCouleurJeton2()) {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Attention !");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Joueur 1 et joueur 2 ont la meme couleur de jeton \nVeuillez changer la couleur du jeton d'un des joueurs !");
		        alertjetonchange.showAndWait();
		        Retour.setDisable(true);
		        erreur.setOpacity(100);
			}
			else {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Confirmation");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Jeton de couleur pour joueur 1 devient de couleur " + Jcj.getCouleurJeton1());
		        alertjetonchange.showAndWait();
		        Retour.setDisable(false);
		        erreur.setOpacity(0);
			}
		}
		private void jVert1() {
			Jcj.changeCouleurJetonJ1("vert");
			Jcia.changeCouleurJetonJ1("vert");
			if (Jcj.getCouleurJeton1() == Jcj.getCouleurJeton2()) {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Attention !");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Joueur 1 et joueur 2 ont la meme couleur de jeton \nVeuillez changer la couleur du jeton d'un des joueurs !");
		        alertjetonchange.showAndWait();
		        Retour.setDisable(true);
		        erreur.setOpacity(100);
			}
			else {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Confirmation");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Jeton de couleur pour joueur 1 devient de couleur " + Jcj.getCouleurJeton1());
		        alertjetonchange.showAndWait();
		        Retour.setDisable(false);
		        erreur.setOpacity(0);
			}
		}
		private void jCyan1() {
			Jcj.changeCouleurJetonJ1("cyan");
			Jcia.changeCouleurJetonJ1("cyan");
			if (Jcj.getCouleurJeton1() == Jcj.getCouleurJeton2()) {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Attention !");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Joueur 1 et joueur 2 ont la meme couleur de jeton \nVeuillez changer la couleur du jeton d'un des joueurs !");
		        alertjetonchange.showAndWait();
		        Retour.setDisable(true);
		        erreur.setOpacity(100);
			}
			else {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Confirmation");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Jeton de couleur pour joueur 1 devient de couleur " + Jcj.getCouleurJeton1());
		        alertjetonchange.showAndWait();
		        Retour.setDisable(false);
		        erreur.setOpacity(0);
			}
		}
		private void jOrange1() {
			Jcj.changeCouleurJetonJ1("orange");
			Jcia.changeCouleurJetonJ1("orange");
			if (Jcj.getCouleurJeton1() == Jcj.getCouleurJeton2()) {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Attention !");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Joueur 1 et joueur 2 ont la meme couleur de jeton \nVeuillez changer la couleur du jeton d'un des joueurs !");
		        alertjetonchange.showAndWait();
		        Retour.setDisable(true);
		        erreur.setOpacity(100);
			}
			else {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Confirmation");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Jeton de couleur pour joueur 1 devient de couleur " + Jcj.getCouleurJeton1());
		        alertjetonchange.showAndWait();
		        Retour.setDisable(false);
		        erreur.setOpacity(0);
			}
		}
		private void jViolet1() {
			Jcj.changeCouleurJetonJ1("violet");
			Jcia.changeCouleurJetonJ1("violet");
			if (Jcj.getCouleurJeton1() == Jcj.getCouleurJeton2()) {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Attention !");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Joueur 1 et joueur 2 ont la meme couleur de jeton \nVeuillez changer la couleur du jeton d'un des joueurs !");
		        alertjetonchange.showAndWait();
		        Retour.setDisable(true);
		        erreur.setOpacity(100);
			}
			else {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Confirmation");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Jeton de couleur pour joueur 1 devient de couleur " + Jcj.getCouleurJeton1());
		        alertjetonchange.showAndWait();
		        Retour.setDisable(false);
		        erreur.setOpacity(0);
			}
		}
		private void jMorCer1() {
			Jcj.changeCouleurJetonJ1("cercle");
			Jcia.changeCouleurJetonJ1("cercle");
			if (Jcj.getCouleurJeton1() == Jcj.getCouleurJeton2()) {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Attention !");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Joueur 1 et joueur 2 ont la meme couleur de jeton \nVeuillez changer la couleur du jeton d'un des joueurs !");
		        alertjetonchange.showAndWait();
		        Retour.setDisable(true);
		        erreur.setOpacity(100);
			}
			else {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Confirmation");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Jeton de couleur pour joueur 1 devient de couleur " + Jcj.getCouleurJeton1());
		        alertjetonchange.showAndWait();
		        Retour.setDisable(false);
		        erreur.setOpacity(0);
			}
		}
		private void jMorCro1() {
			Jcj.changeCouleurJetonJ1("croix");
			Jcia.changeCouleurJetonJ1("croix");
			if (Jcj.getCouleurJeton1() == Jcj.getCouleurJeton2()) {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Attention !");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Joueur 1 et joueur 2 ont la meme couleur de jeton \nVeuillez changer la couleur du jeton d'un des joueurs !");
		        alertjetonchange.showAndWait();
		        Retour.setDisable(true);
		        erreur.setOpacity(100);
			}
			else {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Confirmation");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Jeton de couleur pour joueur 1 devient de couleur " + Jcj.getCouleurJeton1());
		        alertjetonchange.showAndWait();
		        Retour.setDisable(false);
		        erreur.setOpacity(0);
			}
		}
		
		private void jJaune2() {
			Jcj.changeCouleurJetonJ2("jaune");
			Jcia.changeCouleurJetonJ2("jaune");
			if (Jcj.getCouleurJeton1() == Jcj.getCouleurJeton2()) {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Attention !");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Joueur 1 et joueur 2 ont la meme couleur de jeton \nVeuillez changer la couleur du jeton d'un des joueurs !");
		        alertjetonchange.showAndWait();
		        Retour.setDisable(true);
		        erreur.setOpacity(100);
			}
			else {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Confirmation");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Jeton de couleur pour joueur 2 devient de couleur " + Jcj.getCouleurJeton2());
		        alertjetonchange.showAndWait();
		        Retour.setDisable(false);
		        erreur.setOpacity(0);
			}
		}
		
		private void jRouge2() {
			Jcj.changeCouleurJetonJ2("rouge");
			Jcia.changeCouleurJetonJ2("rouge");
			if (Jcj.getCouleurJeton1() == Jcj.getCouleurJeton2()) {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Attention !");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Joueur 1 et joueur 2 ont la meme couleur de jeton \nVeuillez changer la couleur du jeton d'un des joueurs !");
		        alertjetonchange.showAndWait();
		        Retour.setDisable(true);
		        erreur.setOpacity(100);
			}
			else {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Confirmation");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Jeton de couleur pour joueur 2 devient de couleur " + Jcj.getCouleurJeton2());
		        alertjetonchange.showAndWait();
		        Retour.setDisable(false);
		        erreur.setOpacity(0);
			}
		}
		private void jVert2() {
			Jcj.changeCouleurJetonJ2("vert");
			Jcia.changeCouleurJetonJ2("vert");
			if (Jcj.getCouleurJeton1() == Jcj.getCouleurJeton2()) {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Attention !");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Joueur 1 et joueur 2 ont la meme couleur de jeton \nVeuillez changer la couleur du jeton d'un des joueurs !");
		        alertjetonchange.showAndWait();
		        Retour.setDisable(true);
		        erreur.setOpacity(100);
			}
			else {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Confirmation");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Jeton de couleur pour joueur 2 devient de couleur " + Jcj.getCouleurJeton2());
		        alertjetonchange.showAndWait();
		        Retour.setDisable(false);
		        erreur.setOpacity(0);
			}
		}
		private void jCyan2() {
			Jcj.changeCouleurJetonJ2("cyan");
			Jcia.changeCouleurJetonJ2("cyan");
			if (Jcj.getCouleurJeton1() == Jcj.getCouleurJeton2()) {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Attention !");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Joueur 1 et joueur 2 ont la meme couleur de jeton \nVeuillez changer la couleur du jeton d'un des joueurs !");
		        alertjetonchange.showAndWait();
		        Retour.setDisable(true);
		        erreur.setOpacity(100);
			}
			else {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Confirmation");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Jeton de couleur pour joueur 2 devient de couleur " + Jcj.getCouleurJeton2());
		        alertjetonchange.showAndWait();
		        Retour.setDisable(false);
		        erreur.setOpacity(0);
				}
			}
		private void jOrange2() {
			Jcj.changeCouleurJetonJ2("orange");
			Jcia.changeCouleurJetonJ2("orange");
			if (Jcj.getCouleurJeton1() == Jcj.getCouleurJeton2()) {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Attention !");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Joueur 1 et joueur 2 ont la meme couleur de jeton \nVeuillez changer la couleur du jeton d'un des joueurs !");
		        alertjetonchange.showAndWait();
		        Retour.setDisable(true);
		        erreur.setOpacity(100);
			}
			else {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Confirmation");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Jeton de couleur pour joueur 2 devient de couleur " + Jcj.getCouleurJeton2());
		        alertjetonchange.showAndWait();
		        Retour.setDisable(false);
		        erreur.setOpacity(0);
			}
		}
		private void jViolet2() {
			Jcj.changeCouleurJetonJ2("violet");
			Jcia.changeCouleurJetonJ2("violet");
			if (Jcj.getCouleurJeton1() == Jcj.getCouleurJeton2()) {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Attention !");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Joueur 1 et joueur 2 ont la meme couleur de jeton \nVeuillez changer la couleur du jeton d'un des joueurs !");
		        alertjetonchange.showAndWait();
		        Retour.setDisable(true);
		        erreur.setOpacity(100);
			}
			else {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Confirmation");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Jeton de couleur pour joueur 2 devient de couleur " + Jcj.getCouleurJeton2());
		        alertjetonchange.showAndWait();
		        Retour.setDisable(false);
		        erreur.setOpacity(0);
			}
		}
		private void jMorCer2() {
			Jcj.changeCouleurJetonJ2("cercle");
			Jcia.changeCouleurJetonJ2("cercle");
			if (Jcj.getCouleurJeton1() == Jcj.getCouleurJeton2()) {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Attention !");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Joueur 1 et joueur 2 ont la meme couleur de jeton \nVeuillez changer la couleur du jeton d'un des joueurs !");
		        alertjetonchange.showAndWait();
		        Retour.setDisable(true);
		        erreur.setOpacity(100);
			}
			else {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Confirmation");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Jeton de couleur pour joueur 2 devient de couleur " + Jcj.getCouleurJeton2());
		        alertjetonchange.showAndWait();
		        Retour.setDisable(false);
		        erreur.setOpacity(0);
			}
		}
		private void jMorCro2() {
			Jcj.changeCouleurJetonJ2("croix");
			Jcia.changeCouleurJetonJ2("croix");
			if (Jcj.getCouleurJeton1() == Jcj.getCouleurJeton2()) {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Attention !");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Joueur 1 et joueur 2 ont la meme couleur de jeton \nVeuillez changer la couleur du jeton d'un des joueurs !");
		        alertjetonchange.showAndWait();
		        Retour.setDisable(true);
		        erreur.setOpacity(100);
			}
			else {
				Alert alertjetonchange = new Alert(AlertType.NONE);
		        alertjetonchange.setTitle("Confirmation");
		        alertjetonchange.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        alertjetonchange.setContentText("Jeton de couleur pour joueur 2 devient de couleur " + Jcj.getCouleurJeton2());
		        alertjetonchange.showAndWait();
		        Retour.setDisable(false);
		        erreur.setOpacity(0);
			}
		}
		
		private void retour() {
			FenAccueil fenAccueil = new FenAccueil();
			this.close();
			fenAccueil.show();
		}
		
		private AnchorPane creerContenu() {
			AnchorPane root = new AnchorPane();
			
			titre.setFont(new Font("Arial", 50));
			titre.setTextFill(Color.WHITE);
			titre.setTextAlignment(TextAlignment.CENTER);
			titre.setAlignment(Pos.CENTER);
			
			erreur.setFont(new Font("Arial", 20));
			erreur.setTextFill(Color.RED);
			erreur.setTextAlignment(TextAlignment.CENTER);
			erreur.setAlignment(Pos.CENTER);
			
			AnchorPane.setTopAnchor(titre, 50.0);
			AnchorPane.setLeftAnchor(titre, 300.0);
			AnchorPane.setRightAnchor(titre, 300.0);
			
			AnchorPane.setTopAnchor(erreur, 200.0);
			AnchorPane.setLeftAnchor(erreur, 300.0);
			AnchorPane.setRightAnchor(erreur, 300.0);
			
			erreur.setOpacity(0);

			Font font = Font.font("Arial", 30);
			ChoixDuJoueur1.setTextFill(Color.WHITE);
			ChoixDuJoueur1.setTextAlignment(TextAlignment.CENTER);
			ChoixDuJoueur2.setTextFill(Color.WHITE);
			ChoixDuJoueur2.setTextAlignment(TextAlignment.CENTER);
			ChoixDuJoueur1.setFont(font);
			ChoixDuJoueur2.setFont(font);

			jetonJaune1.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
			jetonRouge1.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
			jetonVert1.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
			jetonCyan1.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
			jetonOrange1.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
			jetonViolet1.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
			jetonMorCer1.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
			jetonMorCro1.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
			
			jetonJaune2.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
			jetonRouge2.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
			jetonVert2.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
			jetonCyan2.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
			jetonOrange2.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
			jetonViolet2.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
			jetonMorCer2.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
			jetonMorCro2.setStyle("-fx-background-color: rgba(0,0,0,0.0);");
			
			Retour.setFont(font);
			
			VBox1.setSpacing(10);
			VBox1.setAlignment(Pos.CENTER);
			VBox1.getChildren().add(ChoixDuJoueur1);
			VBox1.getChildren().add(jetonJaune1);
			VBox1.getChildren().add(jetonRouge1);
			VBox1.getChildren().add(jetonVert1);
			VBox1.getChildren().add(jetonCyan1);
			VBox1.getChildren().add(jetonOrange1);
			VBox1.getChildren().add(jetonViolet1);
			VBox1.getChildren().add(jetonMorCer1);
			VBox1.getChildren().add(jetonMorCro1);
			
			VBox2.setSpacing(10);
			VBox2.setAlignment(Pos.CENTER);
			VBox2.getChildren().add(ChoixDuJoueur2);
			VBox2.getChildren().add(jetonJaune2);
			VBox2.getChildren().add(jetonRouge2);
			VBox2.getChildren().add(jetonVert2);
			VBox2.getChildren().add(jetonCyan2);
			VBox2.getChildren().add(jetonOrange2);
			VBox2.getChildren().add(jetonViolet2);
			VBox2.getChildren().add(jetonMorCer2);
			VBox2.getChildren().add(jetonMorCro2);

			AnchorPane.setTopAnchor(VBox1, 250.0);
			AnchorPane.setLeftAnchor(VBox1, 300.0);
			AnchorPane.setRightAnchor(VBox1, 700.0);
			
			AnchorPane.setTopAnchor(VBox2, 250.0);
			AnchorPane.setLeftAnchor(VBox2, 700.0);
			AnchorPane.setRightAnchor(VBox2, 300.0);
			
			AnchorPane.setTopAnchor(Retour, 600.0);
			AnchorPane.setLeftAnchor(Retour, 500.0);
			AnchorPane.setRightAnchor(Retour, 500.0);

			Rectangle fond = new Rectangle(0, 0, 1280, 720);
	        fond.setFill(lg1);
			root.getChildren().addAll(fond);

			root.getChildren().addAll(titre);
			root.getChildren().addAll(erreur);
			root.getChildren().addAll(VBox1);
			root.getChildren().addAll(VBox2);
			root.getChildren().addAll(Retour);
			return root;
		}
	}
