package dzial_programowy;

import exceptions.UjemnaWartoscException;

public class Umowa_o_prace extends Umowa{
	private int okres;
	public Umowa_o_prace(Autor a, double _wynagrodzenie, int _okres) throws UjemnaWartoscException{
		super(a, _wynagrodzenie,"Umowa o prace");
		if(_okres < 0){
			throw new UjemnaWartoscException("Okres zatrudnienia nie moze byc wartoscia ujemna!",_okres);
		}
		okres = _okres;
	}
	public Pozycja getPozycja() {
		return null;
	}
	public int getOkres() {
		return okres;
	}
	public String toString() {
		return this.getRodzajUmowy()+", autor: "+this.getAutor()+", pensja: "+this.getWynagrodzenie()+", okres: " + okres;
	}
}
