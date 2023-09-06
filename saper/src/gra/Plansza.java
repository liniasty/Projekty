package gra;

import java.util.Random;

public class Plansza {
public Pole[][] plansza;

public Plansza() {
	
	Pole[][] a = new Pole[8][8];
	
	for(int i=0; i<8 ;i++) {
		for(int j=0; j<8;j++) {
			a[j][i]=new Pole();
		}
	}
	
	Random rand = new Random();
	for(int i=0;i<6;i++) {
		int c=rand.nextInt(5+1);
		int b=rand.nextInt(5+1);
		a[b][c].czyBomba=true;
		try {
			Thread.sleep(85);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	 for(int i = 0; i < 7; i++) {
         for(int j = 0; j < 7; j++) {
             if(a[j][i].czyBomba == true) {
                 if(j+1 < 8) {
                     a[j+1][i].iloscBomb += 1;
                     if(i+1 < 8) {
                         a[j+1][i+1].iloscBomb += 1;
                     }
                     if(i-1 >= 0) {
                         a[j+1][i-1].iloscBomb += 1;
                     }
                 }
                 if(j-1 >= 0) {
                     a[j-1][i].iloscBomb += 1;
                     if(i+1 < 8) {
                         a[j-1][i+1].iloscBomb += 1;
                     }
                     if(i-1 >= 0) {
                         a[j-1][i-1].iloscBomb += 1;
                     }
                 }
                 if(i+1 < 8) {
                     a[j][i+1].iloscBomb += 1;
                 }
                 if(i-1 >= 0) {
                     a[j][i-1].iloscBomb += 1;
                 }
             }
         }
	 }
	plansza = a;
}
public void wypiszPlansze() {
	System.out.println("  1 2 3 4 5 6 7 8 x");
	for (int i = 0;i<8;i++) {
		System.out.print(i+1);
		for(int j=0;j<8;j++) {
			System.out.print(" "+plansza[j][i].pokazPole());
		}
		System.out.print("\n");
	}
	System.out.println("y");
}
public void ruch(int i, int j) {
	if(plansza[i][j].ruch()==0){
		if(j+1<8) {
			this.proRuch(i,j+1);
		}
		if(j+1<8&&i+1<8) {
			this.proRuch(i+1, j+1);
		}
		if(j+1<8&&i-1>=0) {
			this.proRuch(i-1,j+1);
		}
		if(j-1>=0&&i+1<8) {
			this.proRuch(i+1, j-1);
		}
		if(j-1>=0&&i-1>=0) {
			this.proRuch(i-1, j-1);
		}
		if(j-1>=0) {
			this.proRuch(i,j-1);
		}
		if(i+1<8) {
			this.proRuch(i+1,j);
		}
		if(i-1>=0) {
			this.proRuch(i-1,j);
		}
	}
}
public void proRuch(int i, int j) {
	if(plansza[i][j].proRuch()==0){
		if(j+1<8) {
			this.proRuch(i,j+1);
		}
		if(j-1>=0) {
			this.proRuch(i,j-1);
		}
		if(i+1<8) {
			this.proRuch(i+1,j);
		}
		if(i-1>=0) {
			this.proRuch(i-1,j);
		}
		if(j+1<8&&i+1<8) {
			this.proRuch(i+1, j+1);
		}
		if(j+1<8&&i-1>=0) {
			this.proRuch(i-1,j+1);
		}
		if(j-1>=0&&i+1<8) {
			this.proRuch(i+1, j-1);
		}
		if(j-1>=0&&i-1>=0) {
			this.proRuch(i-1, j-1);
		}
	}
}
public boolean czyWygrales() {
	for(int i=0;i<8;i++) {
		for(int j=0;j<8;j++) {
			if(plansza[i][j].czyBomba||plansza[i][j].widoczny) {
				
			}else {
				return false;
			}
		}
		
	}
	System.out.println("Wygrałeś!!!");
	return true;
}
public void koncowaPlansza() {
	System.out.println("  1 2 3 4 5 6 7 8 x");
	for (int i = 0;i<8;i++) {
		System.out.print(i+1);
		for(int j=0;j<8;j++) {
			System.out.print(" "+plansza[j][i].pokazPoleKoncowe());
		}
		System.out.print("\n");
	}
	System.out.println("y");
}
}
