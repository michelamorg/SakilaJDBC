package dao;

import java.util.List;

import dto.FilmDto;
import dto.FilmDto2;
import model.Actor;
import model.Film;

public interface FilmDao {
	public List<Film> findAllFilm();

	public List<Film> findById(int id);

	public List<Film> findByName(String filmName);

	public int updateFilm(Film film);

	public int deletFilm(Film film);

	public List<FilmDto> infoFilm();
	
	public int insertFilm(List<Film> film);
	
	public List<FilmDto2> datoFilm(String filmName);

}
