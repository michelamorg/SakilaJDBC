package daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;

import com.mysql.cj.log.Log;

import dao.CustomerDao;
import dto.CustomerDTO;
import model.Address;
import model.Customer;

import utilis.DbConn;

public class CustomerDaoImpl implements CustomerDao {

	private static final Logger log = Logger.getLogger(CustomerDaoImpl.class);

	private Connection conn;
	private Statement stm;
	private java.sql.PreparedStatement pstm;
	private ResultSet rs;
	private List<Customer> listaCustomer;
	private List<Customer> trovaNome;
	private List<Customer> trovaId;
	private Customer modifica;
	private Customer cancella;
	private List<Customer> trovaInfo;

	private List<CustomerDTO> listCustomerDto;
	private List<CustomerDTO> listCustomerDto2;
	private List<CustomerDTO> listCustomerDto3;

	private Customer cust;
	private Customer cust2;

	public List<Customer> findAllCustomer() { 
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM CUSTOMER";

			stm = conn.createStatement();

			rs = stm.executeQuery(SQL);

			listaCustomer = new ArrayList<Customer>();
			while (rs.next()) {
				cust = new Customer();
				cust.setCustomer_id(rs.getInt("customer_id"));
				cust.setStore_id(rs.getInt("store_id"));

				cust.setFirst_name(rs.getString("first_name"));
				cust.setEmail(rs.getString("email"));
				cust.setAddress_id(rs.getInt("address_id"));
				cust.setActive(rs.getString("active"));
				cust.setCreate_date(rs.getString("create_date"));

				cust.setLast_update(rs.getString("last_update"));

				listaCustomer.add(cust);

			}

			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			try {
				conn.close();
			} catch (SQLException e) {

				log.error(e.getClass());
			}
			log.info("lettura dati Customer effettuata!");
		}

		return listaCustomer;
	}

	/////////////////////////////////////////////

	public List<Customer> findById(Integer id) { 
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM COUNTRY WHERE COUNTRY_ID=?";

			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, id);

			rs = pstm.executeQuery();
			cust = new Customer();
			trovaId = new ArrayList<Customer>();
			while (rs.next()) {
				
				
				cust.setCustomer_id(rs.getInt("customer_id"));
				cust.setStore_id(rs.getInt("store_id"));
				cust.setFirst_name(rs.getString("first_name"));
				cust.setLast_name(rs.getString("last_name"));
				cust.setEmail(rs.getString("email"));
				cust.setAddress_id(rs.getInt("address_id"));
				cust.setActive(rs.getString("active"));
				cust.setCreate_date(rs.getString("create_date"));
				cust.setLast_update(rs.getString("last_update"));

				trovaId.add(cust);

			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getCause());
			}
			log.info("trovato tramite id.");
		}
		return trovaId;
	}
	/////////////////////////////////////////////////

	public List<Customer> findByName(String customerName) { 

		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM CUSTOMER WHERE FIRST_NAME=?";

			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, customerName);

			rs = pstm.executeQuery();
			trovaNome = new ArrayList<Customer>();
			while (rs.next()) {
				Customer cust = new Customer();
				cust.setCustomer_id(rs.getInt("customer_id"));
				cust.setStore_id(rs.getInt("store_id"));
				;
				cust.setFirst_name(rs.getString("first_name"));
				cust.setEmail(rs.getString("email"));
				cust.setAddress_id(rs.getInt("address_id"));
				cust.setActive(rs.getString("active"));
				cust.setCreate_date(rs.getString("create_date"));
				;
				cust.setLast_update(rs.getString("last_update"));

				trovaNome.add(cust);

			}

			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getCause());
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getCause());
			}
			log.info("trovato tramite nome.");
		}
		return trovaNome;
	}

////////////////////////////////////////////////////////////////

	public int updateCustomerName(Customer customer) {
		int modifica = 0;
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "UPDATE CUSTOMER SET FIRST_NAME=? WHERE CUSTOMER_ID=?";

			pstm = conn.prepareStatement(SQL);

			pstm.setString(1, customer.getFirst_name());
			pstm.setInt(2, customer.getCustomer_id());

			modifica = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getCause());
			}
			log.info("modifica andata a buon fine!");
		}
		return modifica;
	}

	//////////////////////////////////////////////////////

	public int deleteCustomer(Customer customer) { 
		int cancella = 0;
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID=?";

			pstm = conn.prepareStatement(SQL);

			pstm.setInt(1, customer.getCustomer_id());
			cancella = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getCause());
			}
			log.info("cancellazione andata a buon fine!");
		}
		return cancella;
	}

	/////////////////////////////////////////////////////////////////////

	public List<CustomerDTO> findAllInfoCustomer() {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT FIRST_NAME, LAST_NAME, EMAIL, PHONE, ADDRESS, POSTAL_CODE, CITY ,COUNTRY FROM CUSTOMER "
					+ " INNER JOIN ADDRESS ON ADDRESS.ADDRESS_ID=CUSTOMER.ADDRESS_ID " + " INNER JOIN CITY "
					+ " ON CITY.CITY_ID=ADDRESS.CITY_ID " + " INNER JOIN COUNTRY "
					+ " on COUNTRY.COUNTRY_ID=CITY.COUNTRY_ID " + " order by COUNTRY";

			stm = conn.createStatement();

			rs = stm.executeQuery(SQL);

			listCustomerDto = new ArrayList<CustomerDTO>();
			while (rs.next()) {
				CustomerDTO cust = new CustomerDTO();

				cust.setFirstName(rs.getString("first_name"));
				cust.setLastName(rs.getString("last_name"));
				cust.setEmail(rs.getString("email"));
				cust.setPhone(rs.getString("phone"));
				cust.setAddress(rs.getString("address"));
				cust.setPostal_code(rs.getNString("postal_code"));
				cust.setCity(rs.getString("city"));
				cust.setCountry(rs.getString("country"));

				listCustomerDto.add(cust);

			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			try {
				conn.close();
			} catch (SQLException e) {
				log.error(e.getClass());
			}
			log.info("lettura tramite join 1 effettuata.");
		}
		return listCustomerDto;
	}



	
	//////////////////////////////////////////////////////////

	public List<CustomerDTO> findAllInfoCustomer(String countryName) { 
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT FIRST_NAME, LAST_NAME, EMAIL, PHONE, ADDRESS, POSTAL_CODE, CITY " + "FROM CUSTOMER "
					+ "INNER JOIN ADDRESS " + " ON ADDRESS.ADDRESS_ID=CUSTOMER.ADDRESS_ID " + " INNER JOIN CITY "
					+ "ON CITY.CITY_ID=ADDRESS.CITY_ID " + "INNER JOIN COUNTRY " + "on COUNTRY.COUNTRY_ID=CITY.COUNTRY_ID "
					+ "WHERE COUNTRY=?";

			pstm = conn.prepareStatement(SQL);
			pstm.setNString(1, countryName);
			
			rs=pstm.executeQuery();
			listCustomerDto2 = new ArrayList<CustomerDTO>();
			while (rs.next()) {
				CustomerDTO cust = new CustomerDTO();

				cust.setFirstName(rs.getString("first_name"));
				cust.setLastName(rs.getString("last_name"));
				cust.setEmail(rs.getString("email"));
				cust.setPhone(rs.getString("phone"));
				cust.setAddress(rs.getString("address"));
				cust.setPostal_code(rs.getString("postal_code"));
				cust.setCity(rs.getString("city"));

				listCustomerDto2.add(cust);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			try {
				conn.close();
			} catch (SQLException e) {
				log.error(e.getCause());
			}
log.info("lettura tramite join 2 effettuata");
		}
		return listCustomerDto2;

	}



	public int insertCustomer(List<Customer> customer) {
		int insert = 0;
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "insert into customer( customer_id, store_id, first_name, last_name, email, address_id,create_date, last_update) values"
					+ "(?,? , ?, ?, ?,?, ?, ?)";

			pstm = conn.prepareStatement(SQL);
			for (Customer cust : customer) {
				
				log.info("i valori inseriti sono:"+cust.getCustomer_id() + cust.getStore_id()+ cust.getFirst_name()+ cust.getLast_name()+ cust.getEmail() + cust.getAddress_id()  + cust.getCreate_date() + cust.getLast_update());
				
				
				pstm.setInt(1, cust.getCustomer_id());
				pstm.setInt(2, cust.getStore_id());
				pstm.setString(3, cust.getFirst_name());
				pstm.setString(4, cust.getLast_name());
				pstm.setString(5, cust.getEmail());
				pstm.setInt(6, cust.getAddress_id());
				pstm.setString(7, cust.getCreate_date());
				pstm.setString(8, cust.getLast_update());

				insert = pstm.executeUpdate();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getCause());
			}
			log.info("inserimento effettuato");
		}
		return insert;
	}

}
