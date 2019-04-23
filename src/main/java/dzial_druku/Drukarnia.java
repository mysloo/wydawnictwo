package dzial_druku;

public class Drukarnia {
	private int nr_drukarni;
	public Drukarnia(int nr){
		nr_drukarni = nr;
	}
	
	public int getNr_drukarni() {
		return nr_drukarni;
	}
	public String drukuj(Zlecenie z) {
		return "Wydrukowano";
	}
	public String toString() {
		return "Drukarnia nr." + nr_drukarni;
	}
}
