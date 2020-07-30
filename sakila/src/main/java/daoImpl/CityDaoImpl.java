package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.CityDao;
import dto.CityDto;
import model.Address;
import model.City;

import utilis.DbConn;

public class CityDaoImpl implements CityDao {
	private static final Logger log = Logger.getLogger(CityDaoImpl.class);

	private Connection conn;
	private Statement stm;
	private PreparedStatement pstm;
	private ResultSet rs;
	private List<City> listCity;
	private City citta;
	private List<City> trovaId;
	private List<City> trovaNome;
	private List<CityDto> listCityDto;

	public List<City> findAllCity() { 
		try {
			conn = DbConn.getInstance().getConnection();
			String SQL = "SELECT * FROM CITY";

			stm = conn.createStatement();

			rs = stm.executeQuery(SQL);

			listCity = new ArrayList<City>();
			while (rs.next()) {
				City cit = new City();
				cit.setCity_id(rs.getInt("city_id"));
				cit.setCity(rs.getString("city"));
				cit.setCountry_id(rs.getInt("country_id"));
				cit.setLast_update(rs.getString("last_update"));

				listCity.add(cit);

			}
			rs.close();
		} catch (SQLException e) {
			// TODO: handle exception
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
			log.info("Lettura dati City effettuata!");
		}

		return listCity;

	}

	////////////////////////////////////////////////////////////////////////////

	public List<City> findById(Integer id) {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM CITY WHERE CITY_ID=?";

			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, id);

			rs = pstm.executeQuery();
			citta = new City();
			trovaId = new ArrayList<City>();
			while (rs.next()) {

				citta.setCity_id(rs.getInt("city_id"));
				citta.setCity(rs.getString("city"));
				citta.setCountry_id(rs.getInt("country_id"));
				citta.setLast_update(rs.getString("last_update"));

				trovaId.add(citta);

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

/////////////////////////////////////////////////////////////////////

	public List<City> findByName(String cityName) {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM CITY WHERE CITY=?";

			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, cityName);

			rs = pstm.executeQuery();
			trovaNome = new ArrayList<City>();
			while (rs.next()) {
				City c = new City();
				c.setCity_id(rs.getInt("city_id"));
				c.setCity(rs.getString("city"));
				c.setCountry_id(rs.getInt("country_id"));
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
			log.info("Trovato tramite nome.");
		}
		return trovaNome;
	}

	////////////////////////////////////////////////////////////

	public int updateCityName(City city) { // 4
		int modifica = 0;
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "UPDATE CITY SET CITY=? WHERE CITY_ID=?";

			pstm = conn.prepareStatement(SQL);

			pstm.setString(1, city.getCity());
			pstm.setInt(2, city.getCity_id());

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
			log.info("modifica andata a buon fine");
		}
		return modifica;
	}

	///////////////////////////////////////////////////

	public int deleteCity(City city) { // 5
		int canc = 0;
		try {
			conn = DbConn.getInstance().getConnection();
			String SQL = "DELETE FROM CITY WHERE CITY_ID=?";

			pstm = conn.prepareStatement(SQL);

			pstm.setInt(1, city.getCity_id());
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
			log.info("cancellazione andata a buon fine.");
		}
		return canc;
	}

	/////////////////////////////////////////////////
	public List<CityDto> findAllInfoCity() { // 6
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT C.COUNTRY, CI.CITY, A.ADDRESS " + "FROM COUNTRY C " + "INNER JOIN CITY CI "
					+ "ON C.COUNTRY_ID=CI.COUNTRY_ID " + "INNER JOIN ADDRESS A " + "ON A.CITY_ID=CI.CITY_ID";

			stm = conn.createStatement();

			rs = stm.executeQuery(SQL);

			listCityDto = new ArrayList<CityDto>();

			while (rs.next()) {
				CityDto dto = new CityDto();
				dto.setCity(rs.getString("city"));
				dto.setCountry(rs.getString("country"));
				dto.setAddress(rs.getString("address"));

				listCityDto.add(dto);

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
			log.info("lettura dati tramite join effettuata!");

		}
		return listCityDto;
	}

	public int insertCity(List<City> city) {
		int insert = 0;
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "insert into city(city_id, city, country_id, last_update)" + "values(?, ?,?, ?)";

			pstm = conn.prepareStatement(SQL);
			for (City cit : city) {
				log.info("i valori inseriti sono:"+cit.getCity_id()+cit.getCity()+cit.getCountry_id()+cit.getLast_update());

				pstm.setInt(1, cit.getCity_id());
				pstm.setString(2, cit.getCity());
				pstm.setInt(3, cit.getCountry_id());
				pstm.setString(4, cit.getLast_update());

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
			log.info("Inserimento effettuato!");
		}
		return insert;
	}

}
