package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.AddressDao;
import dto.AddressDto;
import dto.CityDto;
import model.Address;
import model.City;
import model.Customer;
import utilis.DbConn;

public class AddressDaoImpl implements AddressDao {

	private static final Logger log = Logger.getLogger(AddressDaoImpl.class);

	private Connection conn;
	private Statement stm;
	private PreparedStatement pstm;
	private ResultSet rs;
	private List<Address> listAdd;
	private Address add;
	private List<Address> trovaId;
	private List<Address> trovaNome;
	private List<AddressDto> listDto;

	public List<Address> findAllAddress() {
		try {
			conn = DbConn.getInstance().getConnection();
			String SQL = "SELECT * FROM ADDRESS";

			stm = conn.createStatement();

			rs = stm.executeQuery(SQL);

			listAdd = new ArrayList<Address>();
			while (rs.next()) {
				Address ad = new Address();
				ad.setAddress_id(rs.getInt("address_id"));
				ad.setAddress(rs.getString("address"));
				ad.setAddress2(rs.getString("address2"));
				ad.setCity_id(rs.getInt("city_id"));
				ad.setDistrict(rs.getString("district"));
				ad.setPhone(rs.getString("phone"));
				ad.setPostal_code(rs.getString("postal_code"));
				ad.setLast_update(rs.getString("last_update"));

				listAdd.add(ad);

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
				log.error(e.getCause());
			}
			log.info("lettura dati Address effettuata!");
		}

		return listAdd;

	}

//////////////////////////////////////////////////////////

	public List<Address> findById(Integer id) {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM ADDRESS WHERE ADDRESS_ID=?";

			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, id);

			rs = pstm.executeQuery();
			add = new Address();
			trovaId = new ArrayList<Address>();
			while (rs.next()) {

				add.setAddress_id(rs.getInt("address_id"));
				add.setAddress(rs.getString("address"));
				add.setAddress2(rs.getString("address2"));
				add.setCity_id(rs.getInt("city_id"));
				add.setDistrict(rs.getString("district"));
				add.setPhone(rs.getString("phone"));
				add.setPostal_code(rs.getString("postal_code"));
				add.setLast_update(rs.getString("last_update"));

				trovaId.add(add);

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

	///////////////////////////////////////////////////////////////////
	public List<Address> findByName(String address) {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM ADDRESS WHERE ADDRESS=?";

			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, address);

			rs = pstm.executeQuery();
			trovaNome = new ArrayList<Address>();
			while (rs.next()) {
				Address c = new Address();
				c.setAddress_id(rs.getInt("address_id"));
				c.setAddress(rs.getString("address"));
				c.setAddress2(rs.getString("address2"));
				c.setCity_id(rs.getInt("city_id"));
				c.setDistrict(rs.getString("district"));
				c.setPhone(rs.getString("phone"));
				c.setPostal_code(rs.getString("postal_code"));
				c.setLast_update(rs.getString("last_update"));

				trovaNome.add(c);

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
			log.info("trovato tramite nome.");
		}
		return trovaNome;
	}

	/////////////////////////////////////////////////////////////

	public int updateAddressName(Address address) {
		int modifica = 0;
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "UPDATE ADDRESS SET ADDRESS=? WHERE ADDRESS_ID=?";

			pstm = conn.prepareStatement(SQL);

			pstm.setString(1, address.getAddress());
			pstm.setInt(2, address.getAddress_id());

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

/////////////////////////////////////////////////////

	public int deleteAddress(Address address) {
		int canc = 0;
		try {
			conn = DbConn.getInstance().getConnection();
			String SQL = "DELETE FROM ADDRESS WHERE ADDRESS_ID=?";

			pstm = conn.prepareStatement(SQL);

			pstm.setInt(1, address.getAddress_id());
			canc = pstm.executeUpdate();

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
		return canc;
	}

	/////////////////////////////////////////////////////////////////

	public List<AddressDto> findAllInfoAddress() {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT CU.LAST_NAME, CU.EMAIL, A.ADDRESS,  C.CITY " + "FROM CUSTOMER CU "
					+ "INNER JOIN ADDRESS A " + "ON CU.ADDRESS_ID=A.ADDRESS_ID " + "INNER JOIN CITY C "
					+ "ON C.CITY_ID=A.CITY_ID";

			stm = conn.createStatement();

			rs = stm.executeQuery(SQL);

			listDto = new ArrayList<AddressDto>();
			while (rs.next()) {
				AddressDto dto = new AddressDto();
				dto.setLast_name(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				dto.setCity(rs.getString("city"));

				listDto.add(dto);

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
				// TODO: handle exception
			}
			log.info("lettura join effettuata!");

		}
		return listDto;
	}

	public int insertAddress(List<Address> address) {
		int insert = 0;
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "insert into address(address_id, address,address2,district, city_id,postal_code, phone)"
					+ "values(?, ?,?, ?,?, ?, ?)";

			pstm = conn.prepareStatement(SQL);
			for (Address addr : address) {

				log.info("i valori inseriti sono:"+addr.getAddress_id()+addr.getAddress()+addr.getAddress2()+addr.getCity_id()+addr.getDistrict()+addr.getPhone()+addr.getPostal_code());

				pstm.setInt(1, addr.getAddress_id());
				pstm.setString(2, addr.getAddress());
				pstm.setString(3, addr.getAddress2());
				pstm.setString(4, addr.getDistrict());
				pstm.setInt(5, addr.getCity_id());
				pstm.setString(6, addr.getPostal_code());
				pstm.setString(7, addr.getPhone());

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
			log.info("inserimento effettuato!");
		}
		return insert;
	}

}
