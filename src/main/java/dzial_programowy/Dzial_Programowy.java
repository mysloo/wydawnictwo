package dzial_programowy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import exceptions.UjemnaWartoscException;
import wydawnictwo.Wydawnictwo;
public class Dzial_Programowy {
	private List<Umowa> ListaUmow = new LinkedList<Umowa>();
	private List<Autor> ListaAutorow = new LinkedList<Autor>();

	public Dzial_Programowy() { }
	
	public List<Autor> getListaAutorow() {
		return ListaAutorow;
	}
	public List<Umowa> getListaUmow(){
		return ListaUmow;
	}
	public boolean dodajAutora(Autor a){
		boolean czy = false;
		for(Autor x : ListaAutorow) {
			if(x.getImie().equals(a.getImie()) && x.getNazwisko().equals(a.getNazwisko())) {
				czy=true;
				break;
			}
		}
		if(!czy) {
			ListaAutorow.add(a);
			return true;
		}
		else return false;
	}
	public boolean usunAutora(Autor a) {
		for(Autor aut : ListaAutorow) {
			if(aut.getImie().equals(a.getImie()) && aut.getNazwisko().equals(a.getNazwisko())) {
				a = aut;
				break;
			}
		}
		if(ListaAutorow.remove(a)) {
			int ile = 0;
			for(Umowa u : ListaUmow) {
				if(u.getAutor().getImie().equals(a.getImie()) && u.getAutor().getNazwisko().equals(a.getNazwisko())) {
					ile++;
				}
			}
			for(int i=0 ;i<ile;i++) {
				for(Umowa u : ListaUmow) {
					if(u.getAutor().getImie().equals(a.getImie()) && u.getAutor().getNazwisko().equals(a.getNazwisko())) {
						rozwiazUmowe(u);
						break;
					}
				}
			}
			return true;
		}
		else return false;
	}
	
	public boolean zawrzyjUmoweOprace(Autor a, double placa, int okres) throws UjemnaWartoscException {
		boolean mozliwe = true;
		for(Umowa u : ListaUmow) {
			if(u.getAutor().equals(a) && u.getRodzajUmowy().equals("Umowa o prace")) {
				mozliwe = false;
			}
		}
		if(mozliwe) {
			ListaUmow.add(new Umowa_o_prace(a,placa,okres));
			return mozliwe;
		}
		else return mozliwe;
	}
	public boolean zawrzyjUmoweOdzielo(Autor a, double placa, Pozycja p) throws UjemnaWartoscException {
		boolean mozliwe = true;
		for(Umowa u : ListaUmow) {
			if(u.getAutor().equals(a) && u.getRodzajUmowy().equals("Umowa o prace")) {
				mozliwe = false;
			}
		}
		if(mozliwe) {
			ListaUmow.add(new Umowa_o_dzielo(a,placa,p));
			if (!a.getListaPozycji().contains(p)) {
				a.napiszPozycje(p);
			}
			return mozliwe;
		}
		return mozliwe;

	}
	public void rozwiazUmowe(Umowa u) {
		ListaUmow.remove(u);
	}
	public void zleceniePracy(Autor a, Pozycja p) { // do poprawki!
		boolean czy = false;
		for(Pozycja poz : a.getListaPozycji()) {
			if(p.getAutor().equals(poz.getAutor()) && p.getTytul().equals(poz.getTytul()) && p.getRodzaj().equals(poz.getRodzaj())) {
				czy = true;
			}
		}
		if(czy==false) a.napiszPozycje(p);
	}
	
	public UjemnaWartoscException zlecDruk(Wydawnictwo w, Pozycja p, int ilosc){
		try{
			p.setIlosc(ilosc);
		}
		catch(UjemnaWartoscException e) {
			return e;
		}
		w.getDzial_druku().wydrukuj(w, p);
		return null;
	}
	
	public String wypiszListeUmow() {
		String info = "";
		int i = 0;
		for(Umowa u : ListaUmow) {
			i++;
			info += i + ". " + u.getAutor() + ", Wynagrodzenie: " + u.getWynagrodzenie() + ", " + u + "\n";
		}
		return info;
	}
	public Autor zwrocAutora(Autor autor) {
	    return getListaAutorow().get(getListaAutorow().indexOf(autor));
    }
	public String wypiszListeAutorow() {
		String info = "";
		int i = 0;
		for(Autor a : ListaAutorow) {
			i++;
			info += i + ". " + a + "\n";
		}
		return info;
	}

}
