package service;

import java.util.List;

import dto.AddressDto;
import model.Address;
import model.Customer;

public interface AddressService {
	List<Address> recuperaAllAddress();

	List<Address> findsAddressById(int id);

	List<Address> findsAddressByNome(String addressNome);

	void modificaNome(Address address);

	void cancCountry(Address address);

	List<AddressDto> InfoCountry();

	void insertAddress(List<Address> address);
}
