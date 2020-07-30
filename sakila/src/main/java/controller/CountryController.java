package controller;

import java.util.List;

import model.Country;
import service.CountryService;
import serviceImpl.CountryServiceImpl;

public class CountryController {

	CountryService countryService = new CountryServiceImpl();

	public void letturaTuttiCountry() {
		countryService.recuperaAllCountry();
	}

	public void trovaById(int id) {
		countryService.findsCountryById(id);
	}
	

	public void trovaByNome(String countryName) {
		countryService.findsCountryByNome(countryName);
	}

	public void modificaCountry(Country country) {
		countryService.modificaNome(country);
	}

	public void cancellaCountry(Country country) {
		countryService.cancCountry(country);
	}
	public void infoCountry() {
		countryService.retriveAllInfoCountry();
	}
	public void inserisciCountry(List<Country> country) {
		countryService.inserimento(country);
	}
}
