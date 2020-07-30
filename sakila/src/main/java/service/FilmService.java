package service;

import java.util.List;

import dto.ActorDto2;
import dto.FilmDto;
import dto.FilmDto2;
import model.Actor;
import model.Film;

public interface FilmService {
	List<Film> recuperaAllFilm();

	List<Film> findsFilmById(int id);

	List<Film> findsFilmByName(String filmName);

	void modificaNome(Film film);

	void cancFilm(Film film);

	List<FilmDto> InfoFilm();

	List<FilmDto2> datoFilm(String filmName);

	void insertFilm(List<Film> film);

}
