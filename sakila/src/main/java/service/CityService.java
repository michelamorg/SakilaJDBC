package service;

import java.util.List;

import dto.CityDto;
import model.City;

public interface CityService {

	List<City> recuperaAllCity();

	List<City> findsCityById(int id);

	List<City> findsCityByNome(String cityNome);

	void modificaNome(City city);

	List<CityDto> retriveAllInfoCity();

	void inserisciCittà(List<City> city);

	void cancCity(City city);

}
