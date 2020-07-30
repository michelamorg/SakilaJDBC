package serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;

import dao.CityDao;
import daoImpl.CityDaoImpl;
import dto.CityDto;
import model.City;
import service.CityService;

public class CityServiceImpl implements CityService {
	
	private static final Logger log = Logger.getLogger(CityServiceImpl.class);

	private CityDao cityDao = new CityDaoImpl();

	public List<City> recuperaAllCity() {
		List<City> recuperaCitta = cityDao.findAllCity();

		for (City c : recuperaCitta) {
			log.info(c.getCity_id() + " " + c.getCity() + " " + c.getCountry_id() + " " + c.getLast_update());

		}
		return recuperaCitta;
	}

	//////////////////////////////////////////////////

	public List<City> findsCityById(int id) {
		List<City> trovaId = cityDao.findById(id);
		for (City a : trovaId) {
			log.info(a.getCity_id() + " " + a.getCity() + " " + a.getCountry_id() + " " + a.getLast_update());

		}

		return trovaId;

	}

	/////////////////////////////////////////////////////////

	public List<City> findsCityByNome(String cityNome) {
		List<City> trovaNome = cityDao.findByName(cityNome);
		for (City x : trovaNome) {
			log.info(x.getCity_id() + " " + x.getCity() + " " + x.getCountry_id() + " " + x.getLast_update());

		}
		return trovaNome;

	}

	/////////////////////////////////////////////////////////////

	public void modificaNome(City city) {
		int resultMod = cityDao.updateCityName(city);
		if (resultMod > 0) {
			log.info("esiste almeno un record per modificare ");
		} else {
			log.info("utente non esiste");
		}

	}

	////////////////////////////////////////////////////

	public void cancCity(City city) {
		/// devo verificare se ciò che vado a cancellare esiste
		int resultCanc = cityDao.deleteCity(city);

		if (resultCanc > 0) {
			log.info("esiste almeno un record per cancellare ");
		} else {
			log.info("utente non esiste");
		}

	}

	//////////////////////////////////////////////////////////

	public List<CityDto> retriveAllInfoCity() {
		List<CityDto> listDto = cityDao.findAllInfoCity();
		for (CityDto dto : listDto) {
			log.info(dto.getCity() + dto.getCountry() + dto.getAddress());
		}
		return listDto;
	}

	public void inserisciCittà(List<City> city) {
		cityDao.insertCity(city);

	}

}
