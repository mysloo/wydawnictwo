package dzial_handlowy;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import dzial_handlowy.Dzial_Handlowy;

import dzial_programowy.Pozycja;
import exceptions.UjemnaWartoscException;
import exceptions.WydawnictwoException;
public class Sklep {
	private String nazwaSklepu;
	
	public Sklep(String nazwa){
		nazwaSklepu = nazwa;
	}
	public Sklep(Sklep s){
		nazwaSklepu = s.nazwaSklepu;
	}
	
	public String getNazwaSklepu() {
		return nazwaSklepu;
	}
	
	public String wypiszDostepnePozycje(Dzial_Handlowy d_h) {
		String info = "";
		info = d_h.getMagazyn().wypiszZawartoscMagazynu();
		return info;
	}
	public WydawnictwoException sprzedajKsiazke(Dzial_Handlowy d_h, Pozycja p, int ilosc) {
		Klient k = new Klient("przyklad","przyklad","52502");
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss"); 
		Date dateobj = new Date(); 
		Zamowienie z = new Zamowienie(d_h.getListaZamowien().size()+1, k, p, ilosc, df.format(dateobj));

		try{
			d_h.zrealizujZamowienie(z);
			return null;
		}
		catch(WydawnictwoException e) {
			d_h.usunZamowienie(z);
			return e;
		}
	
	}
}
