package controller;

import java.util.List;

import model.Customer;
import service.CustomerService;
import serviceImpl.CustomerServiceImpl;

public class CustomerController {

	private CustomerService customerService;

	public CustomerController() {
		customerService = new CustomerServiceImpl();
	}

	public void letturaCustomer() {
		customerService.recuperaAllCustomer();
	}

	public void trovaDaId(int id) {
		customerService.findsCustomerById(id);
	}

	public void trovaNome(String customerNome) {
		customerService.findsCustomerByNome(customerNome);
	}

	public void modificaNome(Customer customer) {
		customerService.modificaNome(customer);
	}

	public void cancella(Customer customer) {
		customerService.cancCustomer(customer);
	}

	public void tutteInfoCustomer() {
		customerService.retriveAllInfoCustomer();
	}

	public void tutteInfoCustomer2(String countryName) {
		customerService.retriveAllInfoCustomer(countryName);
	}

	public void insert(List<Customer> customer) {
		customerService.insertCustomer(customer);
	}

}
