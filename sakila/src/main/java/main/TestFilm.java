package main;

import java.util.ArrayList;
import java.util.List;

import controller.FilmController;
import model.Film;

public class TestFilm {

	public static void main(String[] args) {
		FilmController test = new FilmController();

		test.letturaFilm();

		System.out.println("  ");

		test.trovaNome("AFFAIR PREJUDICE");

		System.out.println("   ");

		Film mod = new Film();
		mod.setFilm_id(67);
		mod.setTitle("il monaco");
		test.modificaFilm(mod);

		System.out.println("  ");

		test.datoFilm("ADAPTATION HOLES");

		System.out.println("");

		test.joinFilm();

		System.out.println(" ");

		Film f = new Film(); 
		f.setFilm_id(1002);
		f.setTitle("non ci resta che piangere");
		f.setDescription("drammatico");
		f.setRelease_year(1984);
		f.setLanguage_id(5);
		f.setLast_update("2020-07-23 18:00:19");

		List<Film> inser = new ArrayList<Film>();
		inser.add(f);
		test.inserisciFilm(inser);

		System.out.println(" ");

		test.trovaId(1002);

		Film canc = new Film();
		canc.setFilm_id(1002);
		test.cancellaFilm(canc);

	}

}
