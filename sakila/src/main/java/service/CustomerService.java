package service;

import java.util.List;

import dto.CustomerDTO;
import model.Customer;

public interface CustomerService {

	List<Customer> recuperaAllCustomer();

	List<Customer> findsCustomerById(int id);

	List<Customer> findsCustomerByNome(String customerNome);

	void modificaNome(Customer customer);

	void cancCustomer(Customer customer);

	void insertCustomer(List<Customer> customer);

	public List<CustomerDTO> retriveAllInfoCustomer();

	public List<CustomerDTO> retriveAllInfoCustomer(String countryName);

}
