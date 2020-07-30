package serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;

import dao.CountryDao;
import daoImpl.CountryDaoImpl;
import dto.CountryDTO;
import model.Country;
import service.CountryService;

public class CountryServiceImpl implements CountryService {

	private static final Logger log = Logger.getLogger(CountryServiceImpl.class);

	private CountryDao countryDao;

	public CountryServiceImpl() {
		countryDao = new CountryDaoImpl();

	}

	public List<Country> recuperaAllCountry() {
		List<Country> recuperaTutti = countryDao.findAllCountry();
		for (Country c : recuperaTutti) {
			log.info(c.getCountry_id() + c.getCountry() + c.getLast_update());

		}
		return recuperaTutti;
	}

	public List<Country> findsCountryById(int id) {
		List<Country> trovaId = countryDao.findById(id);
		for (Country x : trovaId) {
			log.info(x.getCountry_id() + x.getCountry() + x.getLast_update());

		}
		return trovaId;
	}

	public List<Country> findsCountryByNome(String countryNome) {
		List<Country> trovaNome = countryDao.findByName(countryNome);
		for (Country y : trovaNome) {
			log.info(y.getCountry_id() + y.getCountry() + y.getLast_update());
		}
		return trovaNome;
	}

	public void modificaNome(Country country) {
		// devo verificare se ciò che vado a modificare esiste
		int resultMod = countryDao.updateCountryName(country);
		if (resultMod > 0) {
			log.info("esiste almeno un record per modificare ");
		} else {
			log.info("utente non esiste");
		}

	}

	public void cancCountry(Country country) {
		/// devo verificare se ciò che vado a cancellare esiste
		int resultCanc = countryDao.deleteCountry(country);

		if (resultCanc > 0) {
			log.info("esiste almeno un record per cancellare ");
		} else {
			log.info("utente non esiste");
		}

	}

	public List<CountryDTO> retriveAllInfoCountry() {
		List<CountryDTO> inner = countryDao.findAllInfoCountry();
		for (CountryDTO a : inner) {
			log.info(a.getCountry() + a.getCity() + a.getDitrict());

		}
		return inner;
	}

	public void inserimento(List<Country> country) {

		countryDao.inserCountry(country);

	}
}
