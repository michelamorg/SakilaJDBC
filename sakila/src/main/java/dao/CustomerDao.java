package dao;

import java.util.List;

import dto.CustomerDTO;
import model.City;
import model.Customer;

public interface CustomerDao {

	public List<Customer> findAllCustomer(); // select * from customer.

	public List<Customer> findById(Integer id);// select * from customer where id=?.

	public List<Customer> findByName(String customerName);// select * from customer where name=?.

	public int updateCustomerName(Customer customer);// update customer set first_name=? where id=?.

	public int deleteCustomer(Customer customer); // delete from customer where customer_id=?.

	public List<CustomerDTO> findAllInfoCustomer();

	public List<CustomerDTO> findAllInfoCustomer(String countryName);

	public int insertCustomer(List<Customer> customer);

}
