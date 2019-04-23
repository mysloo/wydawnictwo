package exceptions;

public class ZaDuzaIloscException extends WydawnictwoException{
	private double ilosc;

	public ZaDuzaIloscException(double ile) { ilosc = ile;	}
	public ZaDuzaIloscException(String msg, double ile) {
		super(msg);
		ilosc = ile;
	}

	public double getWartosc() {
		return ilosc;
	}
}
