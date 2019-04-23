package wydawnictwo;

import dzial_handlowy.*;
import dzial_programowy.*;
import dzial_druku.*;

public class Main {

	public static void main(String[] args) {

		Sklep sklep = new Sklep("Rysiek");
		Magazyn mag = new Magazyn();
		
		Dzial_Programowy d_prog = new Dzial_Programowy();
		Dzial_Druku d_druku = new Dzial_Druku();
		Dzial_Handlowy d_han = new Dzial_Handlowy(mag, sklep);
		Wydawnictwo w = new Wydawnictwo(d_druku, d_prog, d_han);
		String s = "???mateu?z";
		int nr = 0;
		for(int i=0;i<s.length();i++) {
			System.out.println(s.contentEquals("????????????"));

		}
		
	/*	Autor autor = new Autor("Jan", "Kowalski");
		Autor autor2 = new Autor("Adam", "Nowak");
		Autor autor3 = new Autor("Marcin", "Zakolak");
		d_prog.zawrzyjUmoweOprace(autor, 3000, 5);//mozna wyifowac jezeli autor ma UoP to nie moze miec UoD
		d_prog.zawrzyjUmoweOdzielo(autor2, 500, new Romans(autor2,"Romansiwo",50));
		d_prog.zawrzyjUmoweOdzielo(autor3, 400, new Tygodnik(autor3, "Przeglad sportowy",20.25));
		
		System.out.println(d_prog.wypiszListeUmow());
		
		d_prog.rozwiazUmowe(d_prog.getListaUmow().get(2));//wybieram z listy i wtedy usuwa
		System.out.println(d_prog.wypiszListeUmow());
		
		System.out.println(autor3.wypiszListePozycji());//nie ma umowy, ale jego dane pozostaly
		
		d_prog.zleceniePracy(autor, new Album(d_prog.getListaUmow().get(0).getAutor(), "Album",30));
		
		System.out.println(autor.wypiszListePozycji());
		System.out.println(d_prog.getListaUmow().get(0).getAutor().wypiszListePozycji()); // w umowie zmieniono
		//-----------------------------------------------------------------------
		
		//albo przekazywanie w parametrze do funkcji wydawnictwo, albo zorbienie wydawnictwa w kazdym z DZIALE
		d_prog.zlecDruk(w, d_prog.getListaUmow().get(0).getAutor().getListaPozycji().get(0), 100);
		d_prog.zlecDruk(w, d_prog.getListaUmow().get(1).getAutor().getListaPozycji().get(0), 50);
		System.out.println("\nZawartosc magazynu:\n" + mag.wypiszZawartoscMagazynu());
		
		//---------------------------------------------------------------------
		
		Klient k = new Klient("Mateusz","Laniewski","99723");
		sklep.sprzedajKsiazke(d_han, d_prog.getListaUmow().get(1).getAutor().getListaPozycji().get(0), 15);
		System.out.println("\nPo zakupie:\nZawartosc magazynu:\n" + d_han.getMagazyn().wypiszZawartoscMagazynu());
		
		Romans album = new Romans(autor,"tytul",30);
		System.out.println(album.getRodzaj());
		
		d_prog.dodajAutora(autor);
		d_prog.dodajAutora(autor3);
		System.out.println(d_prog.wypiszListeAutorow());
		d_prog.usunAutora(autor);
		System.out.println(d_prog.wypiszListeAutorow());
		
		Tygodnik tyg = new Tygodnik(autor2,"abacs",30);
		System.out.println(tyg.getNrWydania());
		
		/*Album album = new Album(autor,"Album");
		Romans romans = new Romans(autor,"Romans");
		
		autor.dodajPozycje(album);
		autor.dodajPozycje(romans);
		System.out.println(autor.wypiszListePozycji());
	
		Autor autor2 = new Autor("Pidar","Blyat",20);
		Tygodnik tyg = new Tygodnik(autor2,"Tygodnik",1);
		autor2.dodajPozycje(tyg);
		System.out.println(autor2.wypiszListePozycji());
		
		
		d_prog.zawrzyjUmoweOprace(autor, 200, 2);
		d_prog.zawrzyjUmoweOprace(autor2, 200, 12);
		d_prog.zawrzyjUmoweOdzielo(autor2, 3300, new Romans(autor2,"Ksiazka o dzielo"));
		d_prog.rozwiazUmowe(d_prog.getListaUmow().get(0));//usuwa pierwsza, cala lista sie aktualizuje
		
		System.out.println(d_prog.zleceniePracy(d_prog.getListaUmow().get(0), new Sensacyjne(autor2, "Zlecona praca")));	
		
		
		System.out.println("Lista umow:\n"+d_prog.wypiszListeUmow());
		
		
		mag.dodajPozycje(romans, 22);
		mag.dodajPozycje(album, 3);
		
		mag.usunPozycje(album, 1);
		mag.usunPozycje(romans, 18);
		System.out.println(mag.wypiszZawartoscMagazynu());
		
		System.out.println(mag.sprawdzStan(album));



		
		d_druku.wydrukuj(w, d_druku.getListaDrukarni().get(2), album, 15);
		d_druku.wydrukuj(w, d_druku.getListaDrukarni().get(0), tyg, 3);
		
		System.out.println("\n" + d_druku.wypiszDrukarnie());
		System.out.println(d_druku.wypiszZlecenia());*/
		
		



		


		
		
	}

}
