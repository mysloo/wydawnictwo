package dzial_programowy;

import exceptions.CzyPoprawnyStringException;
import exceptions.UjemnaWartoscException;
import exceptions.WydawnictwoException;
import exceptions.ZaDuzaIloscException;

public abstract class Pozycja {
	private Autor autor;
	private double cena = 0;
	private String tytul;
	private String rodzaj;
	private int ilosc = 0;

	public Pozycja(Autor a, String _tytul, double _cena) throws CzyPoprawnyStringException, UjemnaWartoscException{
		autor = new Autor(a);
		rodzaj = this.getClass().getSimpleName();
		if(czyLitery(_tytul)) tytul = _tytul;
		else throw new CzyPoprawnyStringException("Tytul sklada sie z nieprawidlowych znakow!");
		if(_cena<0) {
			throw new UjemnaWartoscException("Cena nie moze byc ujemna!", _cena);
		}
		cena = _cena;
	}
	public Pozycja(Pozycja p) {
		autor = p.autor;
		tytul = p.tytul;
		rodzaj = p.rodzaj;
		cena = p.cena;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Pozycja)) {
			return false;
		}
		return ((Pozycja) obj).getTytul().equals(tytul);
	}

	public int getNrWydania() {
		return 0;
	}
	
	public  String getRodzaj() {
		return rodzaj;
	}
	public Autor getAutor() {
		return autor;
	}
	public double getCena() {
		return cena;
	}
	public String getTytul() {
		return tytul;
	}
	public void setCena(double value) {
		cena = value;
	}
	public int getIlosc() {
		return ilosc;
	}
	public void setIlosc(int ile) throws UjemnaWartoscException {
		if(ile<0) {
			throw new UjemnaWartoscException("Ujemna ilosc!", ile);
		}
		ilosc += ile;
	}
	//zakup
	public void zmniejszIlosc(int ile) throws WydawnictwoException{
		if(ile<0) {
			throw new UjemnaWartoscException("Ujemna ilosc!", ile);
		}
		if(ilosc-ile<0) {
			throw new ZaDuzaIloscException("Za duzo ksiazek!", ile);
		}
		ilosc -= ile;
	}
	
	public boolean czyLitery(String s) {
	/*	int nr,ile=0;
		for(int i=0;i<s.length();i++) {
			nr = s.charAt(i);
			if((nr>=65 && nr<=90) || (nr>=97 && nr<=122) || s.charAt(i)=='?' || s.charAt(i)=='?'
				|| s.charAt(i)=='?' ||	s.charAt(i)=='?' || s.charAt(i)=='?' || s.charAt(i)=='?' 				|| s.charAt(i)=='?' || s.charAt(i)=='?' || s.charAt(i)=='?' || s.charAt(i)=='?' 
				|| s.charAt(i)=='?' || s.charAt(i)=='?' || s.charAt(i)=='?' || s.charAt(i)=='?' 
				|| s.charAt(i)=='?' || s.charAt(i)=='?' || s.charAt(i)=='?' || s.charAt(i)=='?' || s.charAt(i)==' ' || s.charAt(i)=='-') {
				ile++;
			}
		}
		if(ile==s.length() && !(s.isEmpty())) return true;
		else return false;*/
		return true;
	}
	
}
