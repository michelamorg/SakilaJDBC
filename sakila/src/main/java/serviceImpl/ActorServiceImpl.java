package serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;

import dao.ActorDao;
import daoImpl.ActorDaoImpl;
import dto.ActorDto;
import dto.ActorDto2;
import model.Actor;
import service.ActorService;

public class ActorServiceImpl implements ActorService {

	private static final Logger log = Logger.getLogger(ActorServiceImpl.class);

	private ActorDao actorDao = new ActorDaoImpl();

	public List<Actor> recuperaAllActor() {
		List<Actor> recuperaActor = actorDao.findsAllActor();
		for (Actor a : recuperaActor) {
			log.info(a.getActor_id() + a.getFirst_name() + a.getLast_name() + a.getLast_update());

		}
		return recuperaActor;
	}

	public List<Actor> findsActorsById(int id) {
		List<Actor> trovaId = actorDao.findsById(id);
		for (Actor b : trovaId) {
			log.info(b.getActor_id() + b.getFirst_name() + b.getLast_name() + b.getLast_update());

		}
		return trovaId;
	}

	public List<Actor> findsActorByNome(String actorNome) {
		List<Actor> trovaNome = actorDao.findsByName(actorNome);
		for (Actor c : trovaNome) {
			log.info(c.getActor_id() + c.getFirst_name() + c.getLast_name() + c.getLast_update());

		}
		return trovaNome;
	}

	public void modificaNome(Actor actor) {
		int resultMod = actorDao.updateActor(actor);
		if (resultMod > 0) {
			log.info("esiste almeno un record per modificare ");
		} else {
			log.info("utente non esiste");
		}
	}

	public void cancActor(Actor actor) {
		int resultMod = actorDao.deleteActor(actor);
		if (resultMod > 0) {
			log.info("esiste almeno un record per cancellare ");
		} else {
			log.info("utente non esiste");
		}
	}

	public List<ActorDto> InfoActor() {
		List<ActorDto> inner = actorDao.findAllInfoActor();
		for (ActorDto d : inner) {
			log.info(d.getFilm_id() + d.getFirst_name() + d.getLast_name() + d.getTitle());

		}
		return inner;
	}

	public List<ActorDto2> datoActor(String actorName) {
		List<ActorDto2> datoActor = actorDao.datoAttore(actorName);
		for (ActorDto2 dto2 : datoActor) {
			log.info(dto2.getTitle() + dto2.getLanguageName() + dto2.getCategoryName());

		}
		return datoActor;
	}

	public void insertActor(List<Actor> actor) {
		actorDao.insertActor(actor);

	}

}
