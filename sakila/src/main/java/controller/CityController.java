package controller;

import java.util.List;

import model.City;
import service.CityService;
import serviceImpl.CityServiceImpl;

public class CityController {

	CityService cityService = new CityServiceImpl();

	public void letturaDatiCitta() {
		cityService.recuperaAllCity();
	}

	public void trovaDaId(int id) {
		cityService.findsCityById(id);
	}

	public void trovaDaNome(String cityNome) {
		cityService.findsCityByNome(cityNome);
	}

	public void modificaCity(City city) {
		cityService.modificaNome(city);
	}

	public void cancCity(City city) {
		cityService.cancCity(city);

	}

	public void innerCity() {
		cityService.retriveAllInfoCity();
	}

	public void inserisci(List<City> city) {
		cityService.inserisciCittà(city);
	}
}
