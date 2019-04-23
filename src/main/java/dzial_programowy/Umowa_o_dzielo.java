package dzial_programowy;

import exceptions.UjemnaWartoscException;

public class Umowa_o_dzielo extends Umowa{
	private Pozycja pozycja;
	public Umowa_o_dzielo(Autor a, double _wynagrodzenie, Pozycja p) throws UjemnaWartoscException{
		super(a,_wynagrodzenie, "Umowa o dzielo");
		pozycja = p; 
	}
	public Pozycja getPozycja() {
		return pozycja;
	}
	public int getOkres() {
		return -1;
	}
	public String toString() {
		return this.getRodzajUmowy()+", autor: "+this.getAutor()+", pensja: "+this.getWynagrodzenie()+",pozycja: " + pozycja;

	}
}
