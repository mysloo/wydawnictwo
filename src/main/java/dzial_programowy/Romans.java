package dzial_programowy;

import exceptions.CzyPoprawnyStringException;
import exceptions.UjemnaWartoscException;

public class Romans extends Ksiazka{
	public Romans(Autor a, String _tytul, double _cena) throws CzyPoprawnyStringException, UjemnaWartoscException{
		super(a, _tytul, _cena);
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public String toString() {
		return this.getRodzaj() + ", tytul: '" + this.getTytul();
	}
}
