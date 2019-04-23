package dzial_handlowy;
public class Klient {
	private String imie, nazwisko, nr_konta;
	
	public Klient(String _imie, String _nazwisko, String _nrKonta) {
		imie = _imie;
		nazwisko = _nazwisko;
		nr_konta = _nrKonta;
	}
	
	public String getImie() {
		return imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public String getNr_konta() {
		return nr_konta;
	}

	public String toString() {
		return ", Klient: " +nr_konta + " " + imie + " " + nazwisko;
	}
	
}
