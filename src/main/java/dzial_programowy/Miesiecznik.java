package dzial_programowy;

import exceptions.CzyPoprawnyStringException;
import exceptions.UjemnaWartoscException;

public class Miesiecznik extends Czasopismo{
	private static int nr;
	
	public Miesiecznik(Autor a, String _tytul, double _cena) throws CzyPoprawnyStringException, UjemnaWartoscException {
		super(a, _tytul, ++nr, _cena);
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public String toString() {
		return this.getRodzaj() + ", tytul: '" + this.getTytul() + "', nr: "+this.getNrWydania();
	}
}
