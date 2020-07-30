package main;

import java.util.ArrayList;
import java.util.List;

import controller.CityController;
import model.Address;
import model.City;

public class TestCity {

	public static void main(String[] args) {
		CityController test = new CityController();
/*
		test.letturaDatiCitta();

		System.out.println("  ");

		test.trovaDaNome("Brindisi");

		System.out.println(" ");

		City mod = new City();
		mod.setCity("India");
		mod.setCity_id(78);
		test.modificaCity(mod);

		System.out.println("   ");

		City inser = new City();
		inser.setCity_id(601);
		inser.setCity("Roma");
		inser.setCountry_id(110);
		inser.setLast_update("2006-02-15 04:45:28");
		List<City> city = new ArrayList<City>();
		city.add(inser);
		test.inserisci(city);

		System.out.println("   ");

		test.trovaDaId(601);

		System.out.println(" ");

		test.innerCity();
*/
		System.out.println("  ");

		
		  City canc = new City(); 
		  canc.setCity_id(601); 
		  test.cancCity(canc);
		
	}

}
