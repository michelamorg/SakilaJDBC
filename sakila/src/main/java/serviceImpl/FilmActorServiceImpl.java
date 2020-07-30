package serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;

import dao.FilmActorDao;
import daoImpl.FilmActorDaoImpl;
import dto.FilmActorDto;
import model.City;
import model.FilmActor;
import service.FilmActorService;

public class FilmActorServiceImpl implements FilmActorService {
	
	private static final Logger log = Logger.getLogger(FilmActorServiceImpl.class);
	
	private FilmActorDao filmActorDao = new FilmActorDaoImpl();

	public List<FilmActor> recuperaAllFa() {
		List<FilmActor> recuperaFa = filmActorDao.findAllFilmActor();

		for (FilmActor a : recuperaFa) {
			log.info(a.getActor_id() + a.getFilm_id() + a.getLast_update());

		}
		return recuperaFa;
	}

	public List<FilmActor> findsFaById(int id) {
		List<FilmActor> trovaId = filmActorDao.findById(id);

		for (FilmActor b : trovaId) {
			log.info(b.getActor_id() + b.getFilm_id() + b.getLast_update());

		}
		return trovaId;
	}

	public List<FilmActor> findsFaByNome(String filmActorNome) {
		List<FilmActor> trovaNome = filmActorDao.findByName(filmActorNome);

		for (FilmActor c : trovaNome) {
			log.info(c.getActor_id() + c.getFilm_id() + c.getLast_update());

		}
		return trovaNome;
	}

	public void modificaNome(FilmActor filmActor) {
		int resultMod = filmActorDao.updateFilmActor(filmActor);
		if (resultMod > 0) {
			log.info("esiste almeno un record per modificare ");
		} else {
			log.info("non esiste nemmeo un record");
		}
	}

	public void cancFilmActor(FilmActor filmActor) {
		int resultCanc = filmActorDao.deletFilmActor(filmActor);
		if (resultCanc > 0) {
			log.info("esiste almeno un record per cancellare ");
		} else {
			log.info("non esiste nemmeo un record");
		}
	}

	public List<FilmActorDto> retriveAllInfoFilmActor() {
		List<FilmActorDto> join = filmActorDao.infoFilmActor();

		for (FilmActorDto x : join) {
			log.info(x.getTitle() + x.getDescription() + x.getLast_update());

		}
		return join;

	}

	public void inserisciFa(List<FilmActor> filmActor) {
		filmActorDao.inserisciFa(filmActor);
		
	}

}
