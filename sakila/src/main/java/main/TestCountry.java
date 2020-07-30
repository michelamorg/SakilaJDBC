package main;

import java.util.ArrayList;
import java.util.List;

import controller.CountryController;
import model.City;
import model.Country;

public class TestCountry {

	public static void main(String[] args) {

		CountryController test = new CountryController();
		/*
		test.letturaTuttiCountry();

		System.out.println("  ");

		test.trovaByNome("Zurigo");

		System.out.println("  ");

		Country mod = new Country();
		mod.setCountry("Lapponia");
		mod.setCountry_id(76);
		test.modificaCountry(mod);

		System.out.println("   ");

		Country inser = new Country();
		inser.setCountry_id(110);
		inser.setCountry("Italia");
		inser.setLast_update("2006-02-15 04:44:00");
		List<Country> c = new ArrayList<Country>();
		c.add(inser);
		test.inserisciCountry(c);

		System.out.println("  ");

		test.trovaById(110);

		System.out.println("  ");

		test.infoCountry();

		*/
		 System.out.println("  ");
		
		  Country canc=new Country(); 
		  canc.setCountry_id(110);
		 test.cancellaCountry(canc);
		

	}

}
