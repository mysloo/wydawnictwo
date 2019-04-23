package dzial_programowy;

import exceptions.UjemnaWartoscException;

public abstract class Umowa {
	private Autor autor;
	private double wynagrodzenie = 0;
	private String rodzajUmowy;


	public Umowa(Autor a, double _wynagrodzenie, String _rodzajUmowy) throws UjemnaWartoscException{
		rodzajUmowy = _rodzajUmowy;
		autor = a;
		if(_wynagrodzenie <0) {
			throw new UjemnaWartoscException("Wynagrodzenie nie moze byc ujemne!", _wynagrodzenie);
		}
		wynagrodzenie = _wynagrodzenie;
	}
	public abstract int getOkres();
	public abstract Pozycja getPozycja();
	public String getRodzajUmowy() {
		return rodzajUmowy;
	}
	public Autor getAutor() {
		return autor;
	}
	public double getWynagrodzenie() {
		return wynagrodzenie;
	}
}
