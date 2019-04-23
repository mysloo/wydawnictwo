package dzial_programowy;

import exceptions.CzyPoprawnyStringException;
import exceptions.UjemnaWartoscException;

public abstract class Czasopismo extends Pozycja{
	private int nr_wydania;
	
	public Czasopismo(Autor a, String _tytul, int nr, double _cena) throws CzyPoprawnyStringException, UjemnaWartoscException {
		super(a, _tytul, _cena);
		nr_wydania = nr;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public int getNrWydania() {
		return nr_wydania;
	}

	
}
