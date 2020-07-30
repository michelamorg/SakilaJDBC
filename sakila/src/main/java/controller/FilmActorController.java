package controller;

import java.util.List;

import model.Customer;
import model.FilmActor;
import service.FilmActorService;
import serviceImpl.FilmActorServiceImpl;

public class FilmActorController {

	FilmActorService filmActorService = new FilmActorServiceImpl();

	public void recuperaAllFa() {
		filmActorService.recuperaAllFa();
	}

	public void trovaId(int id) {
		filmActorService.findsFaById(id);
	}

	public void trovaNome(String filmActorNome) {
		filmActorService.findsFaByNome(filmActorNome);
	}

	public void modificaFa(FilmActor filmActor) {
		filmActorService.modificaNome(filmActor);
	}

	public void cancellaFa(FilmActor filmActor) {
		filmActorService.cancFilmActor(filmActor);
	}

	public void joinFa() {
		filmActorService.retriveAllInfoFilmActor();
	}

	public void insert(List<FilmActor> filmActor) {
		filmActorService.inserisciFa(filmActor);
	}
}
