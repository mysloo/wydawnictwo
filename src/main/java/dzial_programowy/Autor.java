package dzial_programowy;
import java.util.ArrayList;
import java.util.List;

import exceptions.CzyPoprawnyStringException;

public class Autor {
	private String imie, nazwisko;
	private List<Pozycja> ListaPozycji = new ArrayList<Pozycja>();
	
	public Autor(String im, String nazw) throws CzyPoprawnyStringException{
		if(czyLitery(im)) imie = im;
		else throw new CzyPoprawnyStringException("Wprowadzono niepoprawne imie.");
		if(czyLitery(nazw)) nazwisko = nazw;
		else throw new CzyPoprawnyStringException("Wprowadzono niepoprawne nazwisko.");
	}
	public Autor(Autor a){ //smiec
		imie = a.imie;
		nazwisko = a.nazwisko;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof  Autor))
			return false;
		return ((Autor) obj).getImie().equals(imie) && ((Autor) obj).getNazwisko().equals(nazwisko);
	}

	public String getImie() {
		return imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	
	public void dodajPozycje(Pozycja p) {
		ListaPozycji.add(p);
	}
	public List<Pozycja> getListaPozycji(){
		return ListaPozycji;
	}
	public void napiszPozycje(Pozycja p) {
		ListaPozycji.add(p);

		
	}
	public String toString() {
		return imie + " " + nazwisko;
	}
	public String wypiszListePozycji() {
		String info = "";
		for(Pozycja p : ListaPozycji) {
			info += p + "\n";
		}
		return info;
	}
	//65-90, 97-122
	//????????????
	public boolean czyLitery(String s) {
		int nr,ile=0;
		for(int i=0;i<s.length();i++) {
			nr = s.charAt(i);
			if((nr>=65 && nr<=90) || (nr>=97 && nr<=122) || s.charAt(i)=='?' || s.charAt(i)=='?'
				|| s.charAt(i)=='?' ||	s.charAt(i)=='?' || s.charAt(i)=='?' || s.charAt(i)=='?' 				|| s.charAt(i)=='?' || s.charAt(i)=='?' || s.charAt(i)=='?' || s.charAt(i)=='?' 
				|| s.charAt(i)=='?' || s.charAt(i)=='?' || s.charAt(i)=='?' || s.charAt(i)=='?' 
				|| s.charAt(i)=='?' || s.charAt(i)=='?' || s.charAt(i)=='?' || s.charAt(i)=='?') {
				ile++;
			}
		}
		if(ile==s.length() && !(s.isEmpty())) return true;
		else return false;
	}
	
}
