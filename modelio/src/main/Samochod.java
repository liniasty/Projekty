package main;

public class Samochod {
public Silnik silnik;
public RodzajNadwozia nadwozie;
public Silnik getSilnik() {
	return silnik;
}
public RodzajNadwozia getNadwozie() {
	return nadwozie;
}
 public Samochod(Silnik silnik,RodzajNadwozia nadwozie) {
	 this.silnik=silnik;
	 this.nadwozie=nadwozie;
 }
}
