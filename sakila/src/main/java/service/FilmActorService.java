package service;

import java.util.List;

import dto.FilmActorDto;
import model.FilmActor;

public interface FilmActorService {
	List<FilmActor> recuperaAllFa();

	List<FilmActor> findsFaById(int id);

	List<FilmActor> findsFaByNome(String filmActorNome);

	void modificaNome(FilmActor filmActor);

	void cancFilmActor(FilmActor filmActor);

	void inserisciFa(List<FilmActor> filmActor);

	List<FilmActorDto> retriveAllInfoFilmActor();
}
