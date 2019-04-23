package dzial_handlowy;
import dzial_programowy.Pozycja;
import exceptions.UjemnaWartoscException;
import exceptions.WydawnictwoException;

import java.util.List;
import java.util.ArrayList;
public class Dzial_Handlowy {
	private Magazyn magazyn;
	private Sklep sklep;
	private List<Zamowienie> ListaZamowien = new ArrayList<Zamowienie>();
	
	public Dzial_Handlowy(Magazyn m, Sklep s) {
		magazyn = m;
		sklep = new Sklep(s);
	}
	
	public Magazyn getMagazyn() {
		return magazyn;
	}
	public Sklep getSklep() {
		return sklep;
	}
	public List<Zamowienie> getListaZamowien(){
		return ListaZamowien;
	}
	
	public void dodajZamowienie(Zamowienie z) {
		ListaZamowien.add(z);
	}
	public void usunZamowienie(Zamowienie z) {
		ListaZamowien.remove(z);
	}

	public void zaaktualizujMagazyn(Pozycja p) {
		boolean czy = false;
		for(Pozycja poz : magazyn.getPozycjeWmagazynie()) {
			if(poz.getAutor().equals(p.getAutor()) && poz.getRodzaj().equals(p.getRodzaj()) && poz.getTytul().equals(p.getTytul())) {
				czy = true;
				break;
			}
		}
		if(czy==false) magazyn.dodajPozycje(p);
	}
	public void ustawCene(Pozycja p, double cena) {
		p.setCena(cena);
	}
	public void zrealizujZamowienie(Zamowienie z) throws WydawnictwoException {
		magazyn.usunPozycje(z.getZamowionaPozycja(), z.getIlosc());

	}
	public String wypiszZamowienia() {
		String info = "";
		for(Zamowienie z : ListaZamowien) {
			info += z + "\n";
		}
		return info;
	}
	public String wypiszZamowieniaKlienta(Klient k) {
		String info = "";
		for(Zamowienie z : ListaZamowien) {
			if(z.getZleceniodawca().getNr_konta().equals(k.getNr_konta())) {
				info += z + "\n";
			}
		}
		return info;
	}
	
	
	

	
	
	
	
}
