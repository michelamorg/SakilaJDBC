package controller;

import java.util.List;

import model.Actor;
import service.ActorService;
import serviceImpl.ActorServiceImpl;

public class ActorController {

	ActorService actorService = new ActorServiceImpl();

	public void letturaActor() {
		actorService.recuperaAllActor();
	}

	public void trovaId(int id) {
		actorService.findsActorsById(id);
	}

	public void trovaNome(String actorNome) {
		actorService.findsActorByNome(actorNome);
	}

	public void modificaActor(Actor actor) {
		actorService.modificaNome(actor);
	}

	public void cancellaActor(Actor actor) {
		actorService.cancActor(actor);
	}

	public void joinActor() {
		actorService.InfoActor();
	}

	public void joinDatoActor(String actorName) {
		actorService.datoActor(actorName);
	}

	public void inserisciActor(List<Actor> actor) {
		actorService.insertActor(actor);
	}
}
