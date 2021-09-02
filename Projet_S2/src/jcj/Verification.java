package jcj;

public class Verification {
	private static int jeton,compteurJeton,compteurLigne,i,colonne,ligne,nbAligne;
	
	public static int verifColonne(int numJoueur, int[][] grille) {
		compteurLigne=0;
		if(numJoueur==1) jeton=1;
		else jeton=2;
		for(i=0;i<7;i++) {
			ligne=1;
			compteurJeton=0;
			while(ligne<7 && compteurJeton<4) {
				if(grille[i][ligne]==jeton) {
					compteurJeton++;
					if(compteurJeton==4) compteurLigne++;
				} else compteurJeton=0;
				ligne++;
			}
		}
		return compteurLigne;
	}
	
	public static int verifLigne(int numJoueur, int[][] grille) {
		compteurLigne=0;
		if(numJoueur==1) jeton=1;
		else jeton=2;
		for(i=1;i<7;i++) {
			colonne=0;
			compteurJeton=0;
			while(colonne<7 && compteurJeton<4) {
				if(grille[colonne][i]==jeton) {
					compteurJeton++;
					if(compteurJeton==4) compteurLigne++;
				} else compteurJeton=0;
				colonne++;
			}
		}
		return compteurLigne;
	}
	
	public static int verifDiagonaleGauche(int numJoueur, int[][] grille) {
		compteurLigne=0;
		if(numJoueur==1) jeton=1;
		else jeton=2;
		for(i=1;i<4;i++) {
			colonne=1;
			ligne=i;
			compteurJeton=0;
			while(colonne<7 && ligne<7 && compteurJeton<4) {
				if(grille[colonne][ligne]==jeton) {
					compteurJeton++;
					if(compteurJeton==4) compteurLigne++;
				} else compteurJeton=0;
				colonne++;
				ligne++;
			}
		}
		for(i=1;i<4;i++) {
			colonne=i;
			ligne=0;
			compteurJeton=0;
			while(colonne<7 && ligne<7 && compteurJeton<4) {
				if(grille[colonne][ligne]==jeton) {
					compteurJeton++;
					if(compteurJeton==4) compteurLigne++;
				} else compteurJeton=0;
				colonne++;
				ligne++;
			}
		}
		return compteurLigne;
	}
	
	public static int verifDiagonaleDroite(int numJoueur, int[][] grille) {
		compteurLigne=0;
		if(numJoueur==1) jeton=1;
		else jeton=2;
		for(i=1;i<4;i++) {
			colonne=6;
			ligne=i;
			compteurJeton=0;
			while(colonne>0 && ligne <7 && compteurJeton<4) {
				if(grille[colonne][ligne]==jeton) {
					compteurJeton++;
					if(compteurJeton==4) compteurLigne++;
				} else compteurJeton=0;
				colonne--;
				ligne++;
			}
		}
		for(i=5;i>2;i--) {
			colonne=i;
			ligne=1;
			compteurJeton=0;
			while(colonne>=0 && ligne<7 && compteurJeton<4) {
				if(grille[colonne][ligne]==jeton) {
					compteurJeton++;
					if(compteurJeton==4) compteurLigne++;
				} else compteurJeton=0;
				ligne++;
				colonne--;
			}
		}
		return compteurLigne;
	}
	
	public static int verifGenerale(int numJoueur, int[][] grille) {
		nbAligne=0;
		nbAligne=nbAligne+verifColonne(numJoueur, grille);
		nbAligne=nbAligne+verifLigne(numJoueur, grille);
		nbAligne=nbAligne+verifDiagonaleGauche(numJoueur, grille);
		nbAligne=nbAligne+verifDiagonaleDroite(numJoueur, grille);
		
		return nbAligne;
	}
}
