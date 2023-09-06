package gra;

public class Pole {
public boolean widoczny;
public boolean czyBomba;
public int iloscBomb;
static boolean czyGraTrwa=true;
static boolean czyZapisac=true;
public String pokazPole() {
	if(widoczny) {
		String b = String.valueOf(iloscBomb);
		return b;
	}
	return " ";
}
public int ruch() {
if(!czyBomba) {
	if(!widoczny) {
		widoczny=true;
		return iloscBomb;
	}else {
		System.out.println("Pole już jest odkryte.");
		return -1;
	}
}else {
	System.out.println("Bomba wybuchła!");
	czyZapisac=false;
	czyGraTrwa=false;
	return -1;
}
}
public int proRuch() {
	if(!widoczny) {
		widoczny=true;
		return iloscBomb;
	}else {
		return -1;
	}
}
public String pokazPoleKoncowe() {
	if(czyBomba) {
		return "x";
	}
	return String.valueOf(iloscBomb);
}
}