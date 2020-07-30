package dao;

import java.util.List;

import dto.ActorDto;
import dto.ActorDto2;
import model.Actor;
import model.Customer;

public interface ActorDao {

	public List<Actor> findsAllActor();
	
	public List<Actor> findsById(int id);
	
	public List<Actor> findsByName(String nameActor);
	
	public  int updateActor(Actor actor);
	
	public  int deleteActor(Actor actor);
	
	public int insertActor(List<Actor> actor);
	
	public List<ActorDto> findAllInfoActor() ;
	
	public List<ActorDto2> datoAttore(String actorNome);
	
	
	
}
