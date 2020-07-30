package dao;

import java.util.List;

import dto.AddressDto;
import model.Address;
import model.Customer;

public interface AddressDao {
	public List<Address> findAllAddress();// 1

	public List<Address> findById(Integer id);// 2

	public List<Address> findByName(String address);// 3

	public int updateAddressName(Address address);// 4

	public int deleteAddress(Address address); // 5

	public List<AddressDto> findAllInfoAddress(); // 6

	public int insertAddress(List<Address> address); // 7

}
