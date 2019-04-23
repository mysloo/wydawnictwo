package dzial_handlowy;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import exceptions.*;

import dzial_programowy.*;
import java.util.Set;
public class Magazyn {
	private List<Pozycja> PozycjeWmagazynie = new ArrayList<Pozycja>();
	public List<Pozycja> getPozycjeWmagazynie(){
		return PozycjeWmagazynie;
	}
	public void dodajPozycje(Pozycja p) {
		PozycjeWmagazynie.add(p);
	}
	public void usunPozycje(Pozycja p, int ile) throws WydawnictwoException{
		p.zmniejszIlosc(ile);
	}	
	public String wypiszZawartoscMagazynu() {
		String info = "";
		for(Pozycja p : PozycjeWmagazynie) {
			info += (p + ", ilosc: " + p.getIlosc()+"\n");
		}
		return info;
	}
	public int sprawdzStan(String _tytul) {
		for(Pozycja p : PozycjeWmagazynie) {
			if(p.getTytul().equals(_tytul)) {
				return p.getIlosc();
			}
		}
		return 0;
	}

}


