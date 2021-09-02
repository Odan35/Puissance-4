package fenetres;

public class Stat {
	static float gagnej1=0;
	static float perduj1=0;
	static int nulej1=0;
	static int nbpartiej1=0;
	static float gagnej2=0;
	static float perduj2=0;
	static int nulej2=0;
	static int nbpartiej2=0;
	
	public void jouer_g(int i) {
		if(i == 1) {
			gagnej1++;
		}
		if (i == 2) {
			gagnej2++;
		}
	}
		
	public void jouer_p(int j) {
		if(j == 1) {
			perduj1++;
		}
		if (j == 2) {
			perduj2++;
		}
		
	}
	
	public void match_nul() {
		nulej1++;
		nulej2++;
	}
	
	public void match_jouer() {
		nbpartiej1++;
		nbpartiej2++;
	}
			
	
}


