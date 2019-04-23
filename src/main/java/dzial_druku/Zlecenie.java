package dzial_druku;
import dzial_programowy.Pozycja;
public class Zlecenie {
	private int nr_zlecenia, ilosc;
	private Pozycja pozycja;
	private String data;
	
	public Zlecenie(int nr, int ile, Pozycja p, String _data) {
		nr_zlecenia = nr;
		ilosc = ile;
		pozycja = p;
		data = _data;
	}
	
	public int getNr_zlecenia() {
		return nr_zlecenia;
	}
	public int getIlosc() {
		return ilosc;
	}
	public Pozycja getPozycja() {
		return pozycja;
	}
	public String getData() {
		return data;
	}
	
	public String toString() {
		return "Zlecenie nr." + nr_zlecenia + " " + pozycja + ",ile: " + ilosc + ", " + data;
	}
	
}
