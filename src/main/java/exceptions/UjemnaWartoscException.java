package exceptions;

public class UjemnaWartoscException extends WydawnictwoException{
	private double wartosc;

	public UjemnaWartoscException(double value) { wartosc = value;	}
	public UjemnaWartoscException(String msg, double value) {
		super(msg);
		wartosc = value;
	}

	public double getWartosc() {
		return wartosc;
	}
}
