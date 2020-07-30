package controller;

import java.util.List;

import model.Address;
import service.AddressService;
import serviceImpl.AddressServiceImpl;

public class AddressController {
	AddressService addressService = new AddressServiceImpl();

	public void letturaAddress() {
		addressService.recuperaAllAddress();
	}

	public void trovaById(int id) {
		addressService.findsAddressById(id);
	}

	public void trovaByNome(String addressNome) {
		addressService.findsAddressByNome(addressNome);
	}

	public void modificaAddress(Address address) {
		addressService.modificaNome(address);
	}

	public void cancellaAddress(Address address) {
		addressService.cancCountry(address);
	}

	public void joinAddress() {
		addressService.InfoCountry();
	}

	public void inserAddress(List<Address> address) {
		addressService.insertAddress(address);
	}
}
