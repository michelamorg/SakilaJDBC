package serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;

import dao.FilmDao;
import daoImpl.FilmDaoImpl;
import dto.FilmDto;
import dto.FilmDto2;
import model.City;
import model.Film;
import service.FilmService;

public class FilmServiceImpl implements FilmService {
	
	private static final Logger log = Logger.getLogger(FilmServiceImpl.class);

	private FilmDao filmDao = new FilmDaoImpl();

	public List<Film> recuperaAllFilm() {
		List<Film> recuperaFilm = filmDao.findAllFilm();

		for (Film a : recuperaFilm) {
			log.info(a.getFilm_id() + a.getTitle() + a.getDescription() + a.getLanguage_id()
					+ a.getOriginal_language_id() + a.getRelease_year() + a.getRental_duration() + a.getRental_rate()
					+ a.getLength() + a.getReplacement_cost());

		}
		return recuperaFilm;
	}

	public List<Film> findsFilmById(int id) {
		List<Film> trovaId = filmDao.findById(id);

		for (Film b : trovaId) {
			log.info(b.getFilm_id() + b.getTitle() + b.getDescription() + b.getLanguage_id()
					+ b.getOriginal_language_id() + b.getRelease_year() + b.getRental_duration() + b.getRental_rate()
					+ b.getLength() + b.getReplacement_cost());
		}
		return trovaId;
	}

	public List<Film> findsFilmByName(String filmName) {
		List<Film> trovaNome = filmDao.findByName(filmName);

		for (Film c : trovaNome) {
			log.info(c.getFilm_id() + c.getTitle() + c.getDescription() + c.getLanguage_id()
					+ c.getOriginal_language_id() + c.getRelease_year() + c.getRental_duration() + c.getRental_rate()
					+ c.getLength() + c.getReplacement_cost());
		}
		return trovaNome;
	}

	public void modificaNome(Film film) {
		int resultMod = filmDao.updateFilm(film);
		if (resultMod > 0) {
			log.info("esiste almeno un record da modificare");
		} else {
			log.info("il record non esiste");
		}
	}

	public void cancFilm(Film film) {
		int resultCanc = filmDao.deletFilm(film);
		if (resultCanc > 0) {
			log.info("esiste almeno un record da cancellare");
		} else {
			log.info("il record non esiste");
		}
	}

	public List<FilmDto> InfoFilm() {
		List<FilmDto> join = filmDao.infoFilm();
		for (FilmDto x : join) {
			log.info(x.getFilm_id() + x.getFirst_name() + x.getLast_name() + x.getTitle() + x.getDescription());
		}
		return join;
	}

	public List<FilmDto2> datoFilm(String filmName) {
		List<FilmDto2> datoFilm = filmDao.datoFilm(filmName);
		for (FilmDto2 dto2 : datoFilm) {
			log.info(dto2.getFirst_name() + dto2.getLast_name());
		}
		return datoFilm;
	}

	public void insertFilm(List<Film> film) {
		filmDao.insertFilm(film);

	}

}
