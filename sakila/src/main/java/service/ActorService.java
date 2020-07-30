package service;

import java.util.List;

import dto.ActorDto;
import dto.ActorDto2;
import dto.AddressDto;
import model.Actor;
import model.Customer;

public interface ActorService {
	List<Actor> recuperaAllActor();

	List<Actor> findsActorsById(int id);

	List<Actor> findsActorByNome(String actorNome);

	void modificaNome(Actor actor);

	void cancActor(Actor actor);

	List<ActorDto> InfoActor();

	List<ActorDto2> datoActor(String actorName);

	void insertActor(List<Actor> actor);
}
