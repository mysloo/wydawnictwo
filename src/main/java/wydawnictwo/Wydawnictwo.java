package wydawnictwo;
import dzial_druku.*;
import dzial_programowy.*;
import dzial_handlowy.*;
import exceptions.CzyPoprawnyStringException;
import exceptions.UjemnaWartoscException;
import javafx.scene.input.InputMethodTextRun;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Wydawnictwo {
	private Dzial_Druku dzial_druku;
	private Dzial_Programowy dzial_programowy;
	private Dzial_Handlowy dzial_handlowy;

	public Wydawnictwo(Dzial_Druku dd, Dzial_Programowy dp, Dzial_Handlowy dh){
		dzial_druku = dd;
		dzial_programowy = dp;
		dzial_handlowy = dh;
	}
	public Dzial_Druku getDzial_druku() {
		return dzial_druku;
	}
	public Dzial_Programowy getDzial_programowy() {
		return dzial_programowy;
	}
	public Dzial_Handlowy getDzial_handlowy() {
		return dzial_handlowy;
	}
	
	public void zapisDoPliku(String nazwaPliku) {
		try {
			List<Autor> autorzy = new LinkedList<>();
			PrintWriter plik = new PrintWriter(nazwaPliku, "UTF-8");
			plik.println("<?xml version = \"1.0\"?>");
			plik.println("<Wydawnictwo>");
			plik.println("    <Umowy>");
			for (Umowa umowa : dzial_programowy.getListaUmow()) {
				switch (umowa.getRodzajUmowy()) {
					case "Umowa o prace":
						autorzy.add(umowa.getAutor());
						plik.println("        <Praca imie=\"" + umowa.getAutor().getImie() + "\" nazwisko=\"" + umowa.getAutor().getNazwisko() + "\" wynagrodzenie=\"" + umowa.getWynagrodzenie() + "\" okres=\"" + umowa.getOkres() + "\"/>");
						break;
					case "Umowa o dzielo":
						autorzy.add(umowa.getAutor());
						plik.println("        <Dzielo imie=\"" + umowa.getAutor().getImie() + "\" nazwisko=\"" + umowa.getAutor().getNazwisko() + "\" wynagrodzenie=\"" + umowa.getWynagrodzenie() + "\" typ=\"" + umowa.getPozycja().getRodzaj() + "\" tytul=\"" + umowa.getPozycja().getTytul() + "\" cena=\"" + umowa.getPozycja().getCena() + "\"/>");
						break;
				}
			}
			for (Autor autor : dzial_programowy.getListaAutorow()) {
				if(!autorzy.contains(autor)) {
					autorzy.add(autor);
					plik.println("        <BrakUmowy imie=\"" + autor.getImie() + "\" nazwisko=\"" + autor.getNazwisko() + "\"/>");
				}
			}
			plik.println("    </Umowy>");
			plik.println("    <Pozycje>");
			for (Autor autor : dzial_programowy.getListaAutorow()) {
				for (Pozycja pozycja : autor.getListaPozycji()) {
					plik.println("        <" + pozycja.getRodzaj() + " imie=\"" + pozycja.getAutor().getImie() + "\" nazwisko=\"" + pozycja.getAutor().getNazwisko()+"\" tytul=\"" + pozycja.getTytul() + "\" cena=\"" + pozycja.getCena() +"\" ilosc=\"" + pozycja.getIlosc() + "\"/>");
				}
			}
			plik.println("    </Pozycje>");
			plik.println("</Wydawnictwo>");
			plik.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public void odczytZPliku(String nazwaPliku) {
		File plik = new File(nazwaPliku);
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			Document document = saxBuilder.build(plik);
			Element elementGlowny = document.getRootElement();
			List<Autor> autorzy = new LinkedList<>();
			Autor autor;
			double wynagrodzenie;
			for (Element pozycja : elementGlowny.getChildren().get(1).getChildren()) {
				autor = new Autor(pozycja.getAttributeValue("imie"), pozycja.getAttributeValue("nazwisko"));
				String tytul = pozycja.getAttributeValue("tytul");
				String typ = pozycja.getName();
				Double cena = Double.parseDouble(pozycja.getAttributeValue("cena"));
				int ilosc = Integer.parseInt(pozycja.getAttributeValue("ilosc"));
				if( !autorzy.contains(autor) ) {
					autorzy.add(autor);
					dzial_programowy.dodajAutora(autor);
				}
				autor = dzial_programowy.zwrocAutora(autor);
				switch (typ) {
					case "Album":
						Album album = new Album(autor, tytul, cena);
						autor.dodajPozycje(album);
						dzial_programowy.zlecDruk(this, album, ilosc);
						break;
					case "Romans":
						Romans romans = new Romans(autor, tytul, cena);
						autor.dodajPozycje(romans);
						dzial_programowy.zlecDruk(this, romans, ilosc);
						break;
					case "Sensacyjne":
						Sensacyjne sensacyjne = new Sensacyjne(autor, tytul, cena);
						autor.dodajPozycje(sensacyjne);
						dzial_programowy.zlecDruk(this, sensacyjne, ilosc);
						break;
					case "Miesiecznik":
						Miesiecznik miesiecznik = new Miesiecznik(autor, tytul, cena);
						autor.dodajPozycje(miesiecznik);
						dzial_programowy.zlecDruk(this, miesiecznik, ilosc);
						break;
					case "Tygodnik":
						Tygodnik tygodnik = new Tygodnik(autor, tytul, cena);
						autor.dodajPozycje(tygodnik);
						dzial_programowy.zlecDruk(this, tygodnik, ilosc);
				}
			}
			for (Element umowa: elementGlowny.getChildren().get(0).getChildren()) {
				switch (umowa.getName()) {
					case "BrakUmowy":
						autor  = new Autor(umowa.getAttributeValue("imie"), umowa.getAttributeValue("nazwisko"));
						if (!autorzy.contains(autor)) {
							autorzy.add(autor);
							dzial_programowy.dodajAutora(autor);
						}
						break;
					case "Praca":
						autor = new Autor(umowa.getAttributeValue("imie"), umowa.getAttributeValue("nazwisko"));
						wynagrodzenie = Double.parseDouble(umowa.getAttributeValue("wynagrodzenie"));
						int okres = Integer.parseInt(umowa.getAttributeValue("okres"));
						if (!autorzy.contains(autor)) {
							autorzy.add(autor);
							dzial_programowy.dodajAutora(autor);
						}
						autor = dzial_programowy.zwrocAutora(autor);
						dzial_programowy.zawrzyjUmoweOprace(autor, wynagrodzenie, okres);
						break;
					case "Dzielo":
						autor = new Autor(umowa.getAttributeValue("imie"), umowa.getAttributeValue("nazwisko"));
						String tytul = umowa.getAttributeValue("tytul");
						String typ = umowa.getAttributeValue("typ");
						wynagrodzenie = Double.parseDouble(umowa.getAttributeValue("wynagrodzenie"));
						double cena = Double.parseDouble(umowa.getAttributeValue("cena"));
						if (!autorzy.contains(autor)) {
							autorzy.add(autor);
							dzial_programowy.dodajAutora(autor);
						}
						autor = dzial_programowy.zwrocAutora(autor);
						switch (typ) {
							case "Album":
								dzial_programowy.zawrzyjUmoweOdzielo(autor, wynagrodzenie, new Album(autor, tytul, cena));
								break;
							case "Miesiecznik":
								dzial_programowy.zawrzyjUmoweOdzielo(autor, wynagrodzenie, new Miesiecznik(autor, tytul, cena));
								break;
							case "Romans":
								dzial_programowy.zawrzyjUmoweOdzielo(autor, wynagrodzenie, new Romans(autor, tytul, cena));
								break;
							case "Sensacyjne":
								dzial_programowy.zawrzyjUmoweOdzielo(autor, wynagrodzenie, new Sensacyjne(autor, tytul, cena));
								break;
							case "Tygodnik":
								dzial_programowy.zawrzyjUmoweOdzielo(autor, wynagrodzenie, new Tygodnik(autor, tytul, cena));
						}
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch (JDOMException e){
			e.printStackTrace();
		}
		catch (CzyPoprawnyStringException e){}
		catch (UjemnaWartoscException e){}
	}
}
