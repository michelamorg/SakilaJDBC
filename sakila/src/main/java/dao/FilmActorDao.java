package dao;

import java.util.List;

import dto.FilmActorDto;
import model.FilmActor;

public interface FilmActorDao {
	public List<FilmActor> findAllFilmActor();

	public List<FilmActor> findById(int id);

	public List<FilmActor> findByName(String filmActorName);

	public int updateFilmActor(FilmActor filmActor);

	public int deletFilmActor(FilmActor filmActor);

	public List<FilmActorDto> infoFilmActor();

	public int inserisciFa(List<FilmActor> filmActor);
}
