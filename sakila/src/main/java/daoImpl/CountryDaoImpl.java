package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.CountryDao;
import dto.CountryDTO;
import model.City;
import model.Country;

import utilis.DbConn;

public class CountryDaoImpl implements CountryDao {

	private static final Logger log = Logger.getLogger(CountryDaoImpl.class);

	private Connection conn;
	private Statement stm;
	private ResultSet rs;
	private PreparedStatement pstm;
	private Country cou;
	private List<Country> listaCountry;
	private List<Country> trovaNome;
	private List<CountryDTO> listaCountryDTO;
	private List<Country> trovaId;

	public List<Country> findAllCountry() {// 1
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM COUNTRY";

			stm = conn.createStatement();

			rs = stm.executeQuery(SQL);

			listaCountry = new ArrayList<Country>();
			while (rs.next()) {
				Country paese = new Country();
				paese.setCountry_id(rs.getInt("country_id"));
				paese.setCountry(rs.getString("country"));
				paese.setLast_update(rs.getString("last_update"));

				listaCountry.add(paese);

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
			log.info("lettura dati Country effettuata!");
		}

		return listaCountry;

	}

	///////////////////////////////////////////////////////

	public List<Country> findById(Integer id) {// 2
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM COUNTRY WHERE COUNTRY_ID=?";

			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, id);

			rs = pstm.executeQuery();
			cou = new Country();
			trovaId = new ArrayList<Country>();
			while (rs.next()) {

				cou.setCountry_id(rs.getInt("country_id"));
				cou.setCountry(rs.getString("country"));
				cou.setLast_update(rs.getString("last_update"));

				trovaId.add(cou);

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
	////////////////////////////////////////////////////

	public List<Country> findByName(String countryName) {// 3
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM COUNTRY WHERE COUNTRY=?";

			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, countryName);

			rs = pstm.executeQuery();
			trovaNome = new ArrayList<Country>();
			while (rs.next()) {
				Country cou = new Country();
				cou.setCountry_id(rs.getInt("country_id"));
				cou.setCountry(rs.getString("country"));
				cou.setLast_update(rs.getString("last_update"));

				trovaNome.add(cou);

			}

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

	////////////////////////////////////////////
	public int updateCountryName(Country country) {// 4
		int modifica = 0;
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "UPDATE COUNTRY SET COUNTRY=? WHERE COUNTRY_ID=?";

			pstm = conn.prepareStatement(SQL);

			pstm.setString(1, country.getCountry());
			pstm.setInt(2, country.getCountry_id());

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

	public int deleteCountry(Country country) {// 5
		int canc = 0;
		try {
			conn = DbConn.getInstance().getConnection();
			String SQL = "DELETE FROM COUNTRY WHERE COUNTRY_ID=?";

			pstm = conn.prepareStatement(SQL);

			pstm.setInt(1, country.getCountry_id());
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
///////////////////////////////////////////////

	public List<CountryDTO> findAllInfoCountry() {// 6
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT C.COUNTRY, CI.CITY, A.DISTRICT " + "FROM COUNTRY C " + "INNER JOIN CITY CI "
					+ "ON C.COUNTRY_ID=CI.COUNTRY_ID " + "INNER JOIN ADDRESS A " + "ON A.CITY_ID=CI.CITY_ID";

			stm = conn.createStatement();

			rs = stm.executeQuery(SQL);

			listaCountryDTO = new ArrayList<CountryDTO>();
			while (rs.next()) {
				CountryDTO dto = new CountryDTO();

				dto.setCountry(rs.getString("country"));
				dto.setCity(rs.getString("city"));
				dto.setDitrict(rs.getString("district"));

				listaCountryDTO.add(dto);

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
			log.info("ricerca dati tramite join effettuata!");
		}
		return listaCountryDTO;
	}

	public int inserCountry(List<Country> country) {
		int insert = 0;
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "insert into country (country_id, country, last_update)" + "values(?,?, ?);";

			pstm = conn.prepareStatement(SQL);
			for (Country c : country) {
				log.info("i valori inseriti sono:"+c.getCountry_id()+c.getCountry()+c.getLast_update());
				pstm.setInt(1, c.getCountry_id());
				pstm.setString(2, c.getCountry());
				pstm.setString(3, c.getLast_update());

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
