package gra;
import java.sql.SQLException;
import java.util.Scanner;

import baza.polaczenie;
public class Rozgrywka {

	@SuppressWarnings("resource")
	public static void main(String[] args)
	
	{while(true){
		Scanner scan = new Scanner(System.in);
		System.out.println("1.Gra \n2.Rangink \n3.Exit");
		int tryb;
		try {
		tryb = scan.nextInt();
		}
		catch(Exception e) {
			System.out.println("Podaj prawidłową liczbe");
			continue;
		}
		if(tryb==1) {
		Plansza plansza = new Plansza();
		long start = System.currentTimeMillis();
		while(gra.Pole.czyGraTrwa) {
			plansza.wypiszPlansze();
			System.out.println("Podaj koordynaty x: ");
			int x = scan.nextInt();
			System.out.println("Podaj koordynaty y: ");
			int y = scan.nextInt();
			if(sprawdzZakres(x,y)) {
				System.out.println("Podaj prawidłowy zakres.");
				continue;
			}
			plansza.ruch(x-1,y-1);
			if(plansza.czyWygrales()) {
				gra.Pole.czyGraTrwa=false;
			}
			
		}
		long koniec = System.currentTimeMillis();
		long czas = koniec-start;
		System.out.println("Zakonczyles gre w "+czas/1000+" sekund.");
		plansza.koncowaPlansza();
		if(gra.Pole.czyZapisac) {
		System.out.println("Podaj swój nickname: ");
		String nick = scan.next();
		try {
			polaczenie.przesli(nick,(int)czas/1000);
		} catch (SQLException e) {
			e.getMessage();
		}
		}
		return ;
		
	}
	if(tryb==2) {
	try {
		polaczenie.wyswietl();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.getMessage();
	}	
	}
	if(tryb==3) {
		break;
	}
	if(tryb<0 || tryb>3) {
	System.out.println("Podaj prawidłową liczbee");
	}
	}
	}
	public static boolean sprawdzZakres(int x,int y) {
		if(x>0&&x<9) {
			if(y>0&&y<9) {
				return false;
			}
		}
		return true;
	}
}
