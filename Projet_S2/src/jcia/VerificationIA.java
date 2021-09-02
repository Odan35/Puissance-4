package jcia;

import java.util.Random;

public class VerificationIA {
	public static boolean danger;
	public static int posC;
	private static boolean trouve;
	private static int compteur,i,l,c;
	public static boolean verifColonne(int colonne, String couleur, int[][] grille) {
		trouve=false;
		compteur=0;
		i=1;
		if(couleur==Jcia.getCouleurJeton1()) {
			while(i<7 && trouve==false) {
				if(grille[colonne][i]==1) {
					compteur++;
					if(compteur==4) trouve=true;
					if(compteur==3) {
						danger=true;
						posC = colonne;
					}
				} else compteur=0;
				i++;
			}
		}
		else {
			while(i<7 && trouve==false) {
				if(grille[colonne][i]==2) {
					compteur++;
					if(compteur==4) trouve=true;
				} else compteur=0;
				i++;
			}
		}
		return trouve;
	}
	
	public static boolean verifLigne(int ligne, String couleur, int[][] grille) {
		trouve=false;
		compteur=0;
		i=0;
		if(couleur==Jcia.getCouleurJeton1()) {
			while(i<7 && trouve==false) {
				if(grille[i][ligne]==1) {
					compteur++;
					if(compteur==4) {
						trouve=true;
					}
					if(compteur==3) {
						danger=true;
						if (i==2) {
							posC = i + 1;
						}
						else if (i==6) {
							posC = i - 3;
						}
						else if (i>2 && grille[i-3][ligne]==2 && grille[i+1][ligne]==0) {
							posC = i + 1;
						}
						else if (i<6 && grille[i-3][ligne]==0 && grille[i+1][ligne]==2) {
							posC = i - 3;
						}
						else {
							Random random = new Random();
							int temp = random.nextInt(2);
							if (temp == 1) {
								posC = i + 1;
							}
							else {
								posC = i - 3;
							}
						}
					}
					if (compteur==2){
						if (i<5) {
							if (grille[i+1][ligne]==0 && grille[i+2][ligne]==1) {
								danger = true;
								posC = i + 1;
							}
							if (ligne<=4 && grille[i+1][ligne+1]==1 && grille[i+2][ligne+2]==1) {
								danger = true;
								posC = i - 1;
							}
						}
						if (i>2) {
							if (ligne<=4 && grille[i-2][ligne+1]==1 && grille[i-3][ligne+2]==1) {
								posC = i;
							}
						}
						
					}
					if (compteur==1) {
						if (i<4) {
							if (grille[i+1][ligne]==0 && grille[i+2][ligne]==1 && grille[i+3][ligne]==1) {
								danger = true;
								posC = i + 1;
							}
						}
					}
				} 
				else {
					compteur=0;
				}
				i++;
			}
		}
		else {
			while(i<7 && trouve==false) {
				if(grille[i][ligne]==2) {
					compteur++;
					if(compteur==4) trouve=true;
					if(compteur==3) {
						danger=true;
						if (i==2) {
							posC = i + 1;
						}
						else if (i==6) {
							posC = i - 3;
						}
						else if (i>2 && grille[i-3][ligne]==2 && grille[i+1][ligne]==0) {
							posC = i + 1;
						}
						else if (i<6 && grille[i-3][ligne]==0 && grille[i+1][ligne]==2) {
							posC = i - 3;
						}
						else {
							Random random = new Random();
							int temp = random.nextInt(2);
							if (temp == 1) {
								posC = i + 1;
							}
							else {
								posC = i - 3;
							}
						}
					}
					if (compteur==2){
						if (i<5) {
							if (grille[i+1][ligne]==0 && grille[i+2][ligne]==1) {
								danger = true;
								posC = i + 1;
							}
							if (ligne<=4 && grille[i+1][ligne+1]==1 && grille[i+2][ligne+2]==1) {
								danger = true;
								posC = i - 1;
							}
						}
						
					}
					if (compteur==1) {
						if (i<4) {
							if (grille[i+1][ligne]==0 && grille[i+2][ligne]==1 && grille[i+3][ligne]==1) {
								danger = true;
								posC = i + 1;
							}
						}
					}
				} else compteur=0;
				i++;
			}
		}
		return trouve;
	}
	
	public static boolean verifDiagonaleGauche(int ligne, int colonne, String couleur, int[][] grille) {
		trouve=false;
		compteur=0;
		i=0; 
		l=ligne;
		c=colonne;
		
		while(l!=1 && c!=0) {
			l--;
			c--;
		}
		
		if(couleur==Jcia.getCouleurJeton1()) {
			while(c<7 && l<7 && trouve==false) {
				if(grille[c][l]==1) {
					compteur++;
					if(compteur==4) trouve=true;
					if(compteur==3) {
						danger=true;
						if ((l==3 && (c>1 && c<6)) || (c==3 && (l>2 && l<6))){
							posC = c + 1;
						}
						else if (c>2 && grille[c-3][l-3]==0) {
							posC = c - 3;
						}
						else if (c == 6 && l <= 3) {
							posC = c;
						}
						else if (c == 0 && l <= 3) {
							posC = c;
						}
						else {
							Random random = new Random();
							int temp = random.nextInt(2);
							if (temp == 1) {
								posC = c + 1;
							}
							else {
								posC = c - 3;
							}
						}
					}
				} else compteur=0;
				c++;
				l++;
			}
		}
		else {
			while(c<7 && l<7 && trouve==false) {
				if(grille[c][l]==2) {
					compteur++;
					if(compteur==4) trouve=true;
					if(compteur==3) {
						danger=true;
						if ((l==3 && (c>1 && c<6)) || (c==3 && (l>2 && l<6))){
							posC = c + 1;
						}
						else if (c>2 && grille[c-3][l-3]==0) {
							posC = c - 3;
						}
						else {
							Random random = new Random();
							int temp = random.nextInt(2);
							if (temp == 1) {
								posC = c + 1;
							}
							else {
								posC = c - 3;
							}
						}
					}
				} else compteur=0;
				c++;
				l++;
			}
		}
		
		return trouve;
	}
	
	public static boolean verifDiagonaleDroite(int ligne, int colonne, String couleur, int[][] grille) {
		trouve=false;
		compteur=0; 
		l=ligne;
		c=colonne;
		
		while(l!=1 && c!=6) {
			l--;
			c++;
		}
		
		if(couleur==Jcia.getCouleurJeton1()) {
			while(c>0 && l<7 && trouve==false) {
				if(grille[c][l]==1) {
					compteur++;
					if(compteur==4) trouve=true;
					if(compteur==3) {
						danger=true;
						if ((l==3 && (c>0 && c<5)) || (c==3 && (l>2 && l<6))) {
							posC = c - 1;
						}
						else if (c<4 && grille[c+3][l-3]==0) {
							posC = c + 3;
						}
						else if (c == 0 && l <= 3) {
							posC = c;
						}
						else if (c == 6 && l <= 3) {
							posC = c;
						}
						else {
							Random random = new Random();
							int temp = random.nextInt(2);
							if (temp == 1) {
								posC = c - 1;
							}
							else {
								posC = c + 3;
							}
						}
					}
				} else compteur=0;
				c--;
				l++;
			}
		}
		else {
			while(c>0 && l<7 && trouve==false) {
				if(grille[c][l]==2) {
					compteur++;
					if(compteur==4) trouve=true;
					if(compteur==3) {
						danger=true;
						if ((l==3 && (c>0 && c<5)) || (c==3 && (l>2 && l<6))) {
							posC = c - 1;
						}
						else if (c<4 && grille[c+3][l-3]==0) {
							posC = c + 3;
						}
						else {
							Random random = new Random();
							int temp = random.nextInt(2);
							if (temp == 1) {
								posC = c - 1;
							}
							else {
								posC = c + 3;
							}
						}
					}
				} else compteur=0;
				c--;
				l++;
			}
		}
		
		return trouve;
	}
	
	public static boolean verifGenerale(int ligne, int colonne, String couleur, int[][] grille) {
		danger=false;
		trouve=verifColonne(colonne, couleur, grille);
		if(!trouve && !danger) trouve=verifLigne(ligne, couleur, grille);
		if(!trouve && !danger) trouve=verifDiagonaleGauche(ligne, colonne, couleur, grille);
		if(!trouve && !danger) trouve=verifDiagonaleDroite(ligne, colonne, couleur, grille);
		
		return trouve;
	}
}
