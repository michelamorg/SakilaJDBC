package serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;

import dao.AddressDao;

import daoImpl.AddressDaoImpl;
import dto.AddressDto;
import model.Address;

import service.AddressService;

public class AddressServiceImpl implements AddressService {

	private static final Logger log = Logger.getLogger(AddressServiceImpl.class);

	private AddressDao addressDao = new AddressDaoImpl();

	public List<Address> recuperaAllAddress() {
		List<Address> recuperaAddress = addressDao.findAllAddress();
		for (Address a : recuperaAddress) {
			log.info(a.getAddress_id() + a.getAddress() + a.getAddress2() + a.getCity_id() + a.getDistrict()
					+ a.getLast_update() + a.getPhone() + a.getPostal_code());
		}
		return recuperaAddress;
	}

	public List<Address> findsAddressById(int id) {
		List<Address> trovaId = addressDao.findById(id);
		for (Address b : trovaId) {
			log.info(b.getAddress_id() + b.getAddress() + b.getAddress2() + b.getCity_id() + b.getDistrict()
					+ b.getLast_update() + b.getPhone() + b.getPostal_code());
		}
		return trovaId;
	}

	public List<Address> findsAddressByNome(String addressNome) {
		List<Address> trovaNome = addressDao.findByName(addressNome);
		for (Address c : trovaNome) {
			log.info(c.getAddress_id() + c.getAddress() + c.getAddress2() + c.getCity_id() + c.getDistrict()
					+ c.getLast_update() + c.getPhone() + c.getPostal_code());
		}
		return trovaNome;
	}

	public void modificaNome(Address address) {
		int resultMod = addressDao.updateAddressName(address);
		if (resultMod > 0) {
			log.info("esiste almeno un record per modificare ");
		} else {
			log.info("utente non esiste");
		}

	}

	public void cancCountry(Address address) {
		int resultMod = addressDao.deleteAddress(address);
		if (resultMod > 0) {
			log.info("esiste almeno un record per modificare ");
		} else {
			log.info("utente non esiste");
		}

	}

	public List<AddressDto> InfoCountry() {
		List<AddressDto> inner = addressDao.findAllInfoAddress();
		for (AddressDto x : inner) {
			log.info(x.getAddress() + x.getCity() + x.getEmail() + x.getLast_name());
		}
		return inner;
	}

	public void insertAddress(List<Address> address) {

		addressDao.insertAddress(address);

	}
}
