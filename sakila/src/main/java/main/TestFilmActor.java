package main;

import java.util.ArrayList;
import java.util.List;

import controller.FilmActorController;
import controller.FilmController;
import model.Actor;
import model.FilmActor;
import service.FilmActorService;

public class TestFilmActor {

	public static void main(String[] args) {
		FilmActorController test = new FilmActorController();
		/*
		test.recuperaAllFa();

		System.out.println("  ");

		test.trovaNome("2006-02-15 05:05:03");

		System.out.println("  ");

		FilmActor mod = new FilmActor();
		mod.setFilm_id(106);
		mod.setLast_update("2006-02-18 05:05:03");
		test.modificaFa(mod);

		System.out.println("   ");
		
		FilmActor act = new FilmActor(); 
		act.setActor_id(201);
		act.setFilm_id(934);
		act.setLast_update("2006-02-15 03:05:03");
		List<FilmActor> inser = new ArrayList<FilmActor>();
		inser.add(act);
		test.insert(inser);

		System.out.println("  ");

		test.trovaId(934);
	
		System.out.println("  ");
		
		test.joinFa();
		*/
	
		System.out.println("  ");
		FilmActor canc =new FilmActor();
		canc.setFilm_id(934);
		test.cancellaFa(canc);
	
	}

}
