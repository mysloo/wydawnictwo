package dzial_programowy;

import exceptions.CzyPoprawnyStringException;
import exceptions.UjemnaWartoscException;

public abstract class Ksiazka extends Pozycja{

	public Ksiazka(Autor a, String _tytul, double _cena) throws CzyPoprawnyStringException, UjemnaWartoscException {
		super(a, _tytul, _cena);
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
