package serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;

import dao.CustomerDao;
import daoImpl.CustomerDaoImpl;
import dto.CustomerDTO;
import model.Customer;

import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private static final Logger log = Logger.getLogger(CustomerServiceImpl.class);

	private CustomerDao customerDao = new CustomerDaoImpl();

	public List<Customer> recuperaAllCustomer() {
		List<Customer> allCust = customerDao.findAllCustomer();
		for (Customer c : allCust) {
			log.info(c.getStore_id() + c.getCustomer_id() + c.getActive() + c.getAddress_id() + c.getCreate_date()
					+ c.getEmail() + c.getFirst_name() + c.getLast_name() + c.getLast_update());

		}
		return allCust;

	}

	public List<Customer> findsCustomerById(int id) {
		List<Customer> trovaId = customerDao.findById(id);
		for (Customer a : trovaId) {
			log.info(a.getCustomer_id() + a.getAddress_id() + a.getEmail() + a.getActive() + a.getFirst_name()
					+ a.getLast_name() + a.getStore_id() + a.getCreate_date());

		}

		return trovaId;

	}

	public List<Customer> findsCustomerByNome(String customerNome) {
		List<Customer> trovaNome = customerDao.findByName(customerNome);
		for (Customer b : trovaNome) {
			log.info(b.getStore_id() + b.getCustomer_id() + b.getActive() + b.getAddress_id() + b.getCreate_date()
					+ b.getEmail() + b.getFirst_name() + b.getLast_name() + b.getLast_update());
		}
		return trovaNome;
	}

	public void modificaNome(Customer customer) {
		int resultMod = customerDao.updateCustomerName(customer);

		if (resultMod > 0) {
			log.info("esiste almeno un record per modificare");
		} else {
			log.info("utente non esiste");
		}

	}

	public void cancCustomer(Customer customer) {
		int resultCanc = customerDao.deleteCustomer(customer);

		if (resultCanc > 0) {
			log.info("esiste almeno un record per cancellare");
		} else {
			log.info("utente non esiste");
		}
	}

	public List<CustomerDTO> retriveAllInfoCustomer() {
		List<CustomerDTO> list = customerDao.findAllInfoCustomer();
		for (CustomerDTO c : list) {
			log.info(c.getFirstName() + c.getLastName() + c.getEmail() + c.getPhone() + c.getEmail()
					+ c.getPostal_code() + c.getCity() + c.getAddress());

		}
		return list;
	}

	public List<CustomerDTO> retriveAllInfoCustomer(String countryName) {

		List<CustomerDTO> list = customerDao.findAllInfoCustomer(countryName);
		for (CustomerDTO b : list) {
			log.info(b.getCountry() + b.getCity() + b.getAddress() + b.getEmail() + b.getFirstName() + b.getLastName()
					+ b.getPhone() + b.getPostal_code());

		}

		return list;
	}

	public void insertCustomer(List<Customer> customer) {

		customerDao.insertCustomer(customer);

	}
}
