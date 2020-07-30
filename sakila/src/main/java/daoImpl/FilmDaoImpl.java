package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.FilmDao;
import dto.ActorDto2;
import dto.CityDto;
import dto.FilmDto;
import dto.FilmDto2;
import model.Actor;
import model.City;
import model.Film;
import utilis.DbConn;

public class FilmDaoImpl implements FilmDao {

	private static final Logger log = Logger.getLogger(FilmDaoImpl.class);
	private Connection conn;
	private Statement stm;
	private PreparedStatement pstm;
	private ResultSet rs;
	private List<Film> listFilm;
	private List<Film> trovaId;
	private List<Film> trovaNome;
	private List<FilmDto> trovaInfo;
	private List<FilmDto2> listDto2;

	public List<Film> findAllFilm() {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM  FILM";

			stm = conn.createStatement();

			rs = stm.executeQuery(SQL);

			listFilm = new ArrayList<Film>();
			while (rs.next()) {
				Film f = new Film();
				f.setFilm_id(rs.getInt("film_id"));
				f.setTitle(rs.getString("title"));
				f.setDescription(rs.getString("description"));
				f.setRelease_year(rs.getInt("release_year"));
				f.setLanguage_id(rs.getInt("language_id"));
				f.setOriginal_language_id(rs.getInt("original_language_id"));
				f.setRental_duration(rs.getInt("rental_duration"));
				f.setRental_rate(rs.getDouble("rental_rate"));
				f.setLength(rs.getInt("length"));
				f.setReplacement_cost(rs.getDouble("replacement_cost"));

				listFilm.add(f);
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
			log.info("lettura dati Film effettuata");
		}

		return listFilm;

	}

	public List<Film> findById(int id) {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM FILM WHERE FILM_ID=?";

			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, id);

			rs = pstm.executeQuery();
			Film f1 = new Film();
			trovaId = new ArrayList<Film>();
			while (rs.next()) {
				f1.setFilm_id(rs.getInt("film_id"));
				f1.setTitle(rs.getString("title"));
				f1.setDescription(rs.getString("description"));
				f1.setRelease_year(rs.getInt("release_year"));
				f1.setLanguage_id(rs.getInt("language_id"));
				f1.setOriginal_language_id(rs.getInt("original_language_id"));
				f1.setRental_duration(rs.getInt("rental_duration"));
				f1.setRental_rate(rs.getDouble("rental_rate"));
				f1.setLength(rs.getInt("length"));
				f1.setReplacement_cost(rs.getDouble("replacement_cost"));

				trovaId.add(f1);

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

	public List<Film> findByName(String filmName) {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM FILM WHERE TITLE=?";

			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, filmName);

			rs = pstm.executeQuery();
			Film f2 = new Film();
			trovaNome = new ArrayList<Film>();
			while (rs.next()) {
				f2.setFilm_id(rs.getInt("film_id"));
				f2.setTitle(rs.getString("title"));
				f2.setDescription(rs.getString("description"));
				f2.setRelease_year(rs.getInt("release_year"));
				f2.setLanguage_id(rs.getInt("language_id"));
				f2.setOriginal_language_id(rs.getInt("original_language_id"));
				f2.setRental_duration(rs.getInt("rental_duration"));
				f2.setRental_rate(rs.getDouble("rental_rate"));
				f2.setLength(rs.getInt("length"));
				f2.setReplacement_cost(rs.getDouble("replacement_cost"));

				trovaNome.add(f2);

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

	public int updateFilm(Film film) {
		int modifica = 0;
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "UPDATE FILM SET TITLE=? WHERE FILM_ID=?";

			pstm = conn.prepareStatement(SQL);

			pstm.setString(1, film.getTitle());
			pstm.setInt(2, film.getFilm_id());

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

	public int deletFilm(Film film) {
		int canc = 0;
		try {
			conn = DbConn.getInstance().getConnection();
			String SQL = "DELETE FROM FILM WHERE FILM_ID=?";

			pstm = conn.prepareStatement(SQL);

			pstm.setInt(1, film.getFilm_id());
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

	public List<FilmDto> infoFilm() {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT A.FIRST_NAME, A.LAST_NAME, F.TITLE, F.DESCRIPTION, FA.FILM_ID " + "FROM ACTOR A "
					+ "INNER JOIN FILM_ACTOR FA " + "ON FA.ACTOR_ID=A.ACTOR_ID " + "INNER JOIN FILM F "
					+ "ON F.FILM_ID=FA.FILM_ID";

			stm = conn.createStatement();

			rs = stm.executeQuery(SQL);
		
			trovaInfo = new ArrayList<FilmDto>();
			while (rs.next()) {
				FilmDto dto = new FilmDto();
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setTitle(rs.getString("title"));
				dto.setDescription(rs.getString("description"));
				dto.setFilm_id(rs.getInt("film_id"));
				
	
				trovaInfo.add(dto);

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
			log.info("lettura tramite join 1 effettuata");
		}
		return trovaInfo;
	}

	public int insertFilm(List<Film> film) {
		int insert = 0;
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "insert into film ( film_id, title, description, release_year, language_id,last_update) "
					+ "values(?, ?, ?, ?,?,?)";

			pstm = conn.prepareStatement(SQL);
			for (Film f : film) {

				log.info(f.getFilm_id() + f.getTitle() + f.getDescription() + f.getRelease_year()
						+ f.getLanguage_id()  + f.getLast_update());

				pstm.setInt(1, f.getFilm_id());
				pstm.setString(2, f.getTitle());
				pstm.setString(3, f.getDescription());
				pstm.setInt(4, f.getRelease_year());
				pstm.setInt(5, f.getLanguage_id());
				pstm.setString(6, f.getLast_update());

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

	public List<FilmDto2> datoFilm(String filmName) {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "select a.first_name, a.last_name " + "from actor a " + "inner join film_actor fa "
					+ "on a.actor_id=fa.actor_id " + "inner join film f " + "on f.film_id=fa.film_id "
					+ "where f.title=?";

			pstm = conn.prepareStatement(SQL);

			pstm.setString(1, filmName);
			rs = pstm.executeQuery();
			listDto2 = new ArrayList<FilmDto2>();
			while (rs.next()) {
				FilmDto2 film = new FilmDto2();

				film.setFirst_name(rs.getString("first_name"));
				film.setLast_name(rs.getString("last_name"));

				listDto2.add(film);

			}
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
		return listDto2;

	}
}
