package main;

import java.util.ArrayList;
import java.util.List;

import controller.ActorController;
import model.Actor;

public class TestActor {

	public static void main(String[] args) {

		ActorController test = new ActorController();
	/*
		test.letturaActor();

	

		System.out.println(" ");

		test.trovaNome("JENNIFER");

		System.out.println(" ");

		Actor mod = new Actor();
		mod.setFirst_name("Marta");
		mod.setActor_id(13);
		test.modificaActor(mod);

		System.out.println("   ");
		test.joinActor();

		System.out.println("   ");
		test.joinDatoActor("PENELOPE");
		
			
		Actor act =new Actor(); 
		act.setActor_id(201);
		act.setFirst_name("Michela");
		act.setLast_name("Morgillo");
		act.setLast_update("2006-02-15 03:34:33");
		
		List<Actor> inser=new ArrayList<Actor>();
		inser.add(act);
		test.inserisciActor(inser);
		
		System.out.println(" ");

		test.trovaId(201);
	
		*/
		Actor canc=new Actor(); 
		canc.setActor_id(201);
		test.cancellaActor(canc);

	}

}
