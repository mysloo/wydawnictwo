package dzial_druku;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dzial_programowy.Album;
import dzial_programowy.Pozycja;
import wydawnictwo.Wydawnictwo;
public class Dzial_Druku {
	private List<Drukarnia> ListaDrukarni = new ArrayList<Drukarnia>();
	private List<Zlecenie> ListaZlecen = new ArrayList<Zlecenie>();
	
	public Dzial_Druku() {
		Drukarnia druk1 = new Drukarnia(1);
		Drukarnia druk2 = new Drukarnia(2);
		Drukarnia_Albumow a_druk= new Drukarnia_Albumow(3);
		ListaDrukarni.add(druk1);
		ListaDrukarni.add(druk2);
		ListaDrukarni.add(a_druk);
	}
	public List<Drukarnia> getListaDrukarni() {
		return ListaDrukarni;
	}
	public List<Zlecenie> getListaZlecen() {
		return ListaZlecen;
	}
	public String wypiszDrukarnie() {
		String info = "";
		for(Drukarnia d : ListaDrukarni) {
			info += d + "\n";
		}
		return info;
	}
	public String wypiszZlecenia() {
		String info = "";
		for(Zlecenie z : ListaZlecen) {
			info += z + "\n";
		}
		return info;
	}
	public void wydrukuj(Wydawnictwo w, Pozycja p) {
	    DateFormat df = new SimpleDateFormat("dd/MM/yy, hh:mm"); 
	    Date dateobj = new Date(); 
	    Zlecenie z = new Zlecenie(ListaZlecen.size()+1, p.getIlosc(), p, df.format(dateobj));
		ListaZlecen.add(z);	
		if(p instanceof Album) this.getListaDrukarni().get(2).drukuj(z);
		else this.getListaDrukarni().get(0).drukuj(z);
		w.getDzial_handlowy().zaaktualizujMagazyn(p);
		
	}
}
