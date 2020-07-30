package service;

import java.util.List;

import dto.CountryDTO;
import dto.CustomerDTO;
import model.Country;

public interface CountryService {

	List<Country> recuperaAllCountry();

	List<Country> findsCountryById(int id);

	List<Country> findsCountryByNome(String countryNome);

	void modificaNome(Country country);

	List<CountryDTO> retriveAllInfoCountry();

	void inserimento(List<Country> country);

	void cancCountry(Country country);
}
