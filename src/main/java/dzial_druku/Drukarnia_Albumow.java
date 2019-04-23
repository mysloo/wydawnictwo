package dzial_druku;

public class Drukarnia_Albumow extends Drukarnia{
	Drukarnia_Albumow(int nr){
		super(nr);
	}
	public String drukuj(Zlecenie z) {
		return "Wydrukowano " + z.getIlosc() + " " + z.getPozycja();
	}
}
