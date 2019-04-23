package dzial_handlowy;
import dzial_programowy.Pozycja;

public class Zamowienie {
	private int nr_zamowienia, ilosc;
	private Pozycja zamowionaPozycja;
	private String dataZamowienia;
	private Klient zleceniodawca;
	
	public Zamowienie(int nr, Klient _zleceniodawca, Pozycja _p, int ile, String data) {
		nr_zamowienia = nr;
		ilosc = ile;
		zamowionaPozycja = _p;
		dataZamowienia = data;
		zleceniodawca = _zleceniodawca;
	}
	
	public int getNr_zamowienia() {
		return nr_zamowienia;
	}
	public int getIlosc() {
		return ilosc;
	}
	public Pozycja getZamowionaPozycja() {
		return zamowionaPozycja;
	}
	public String getDataZamowienia() {
		return dataZamowienia;
	}
	public Klient getZleceniodawca() {
		return zleceniodawca;
	}
	
	public String toString() {
		return nr_zamowienia + " " + dataZamowienia + " " + zamowionaPozycja + " " + ilosc + " " + zleceniodawca;
	}
}
