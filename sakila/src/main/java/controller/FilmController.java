package controller;

import java.util.List;

import model.Film;
import service.FilmService;
import serviceImpl.FilmServiceImpl;

public class FilmController {

	FilmService filmService=new FilmServiceImpl();
	
	public void letturaFilm() {
		filmService.recuperaAllFilm();
	}
	
	public void trovaId(int id) {
		filmService.findsFilmById(id);
	}
	
	public void trovaNome(String filmName) {
		filmService.findsFilmByName(filmName);
	}
	
	public void modificaFilm (Film film) {
		filmService.modificaNome(film);
	}
	
	public void cancellaFilm (Film film ) {
		filmService.cancFilm(film);
	}
	
	public void joinFilm() {
		filmService.InfoFilm();
	}
	
	public void datoFilm(String filmName) {
		filmService.datoFilm(filmName);
	}
	
	public void inserisciFilm(List<Film> film) {
		filmService.insertFilm(film);
	}
}
