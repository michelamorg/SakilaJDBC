package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.FilmActorDao;
import dto.FilmActorDto;
import dto.FilmDto;
import model.City;
import model.Film;
import model.FilmActor;
import utilis.DbConn;

public class FilmActorDaoImpl implements FilmActorDao{
	
	private static final Logger log = Logger.getLogger(FilmActorDaoImpl.class);
	
	private Connection conn;
	private Statement stm;
	private PreparedStatement pstm;
	private ResultSet rs;
	private List<FilmActor> listFilmActor;
	private List<FilmActor> trovaId;
	private List<FilmActor> trovaNome;
	private List<FilmActorDto> trovaInfo;
	
	public List<FilmActor> findAllFilmActor() {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM  FILM_ACTOR";

			stm = conn.createStatement();

			rs = stm.executeQuery(SQL);
			
			listFilmActor = new ArrayList<FilmActor>();
			while (rs.next()) {
				FilmActor f = new FilmActor();
				
				f.setActor_id(rs.getInt("actor_id"));
				f.setFilm_id(rs.getInt("film_id"));
				f.setLast_update(rs.getString("last_update"));
				
				

				listFilmActor.add(f);
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
			log.info("lettura dati Film Actor effettuata");
		}
		
		return listFilmActor;

	}


	public List<FilmActor> findById(int id) {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM FILM_ACTOR WHERE FILM_ID=?";

			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, id);

			rs = pstm.executeQuery();
			FilmActor f1 = new FilmActor();
			trovaId = new ArrayList<FilmActor>();
			while (rs.next()) {
				
				f1.setActor_id(rs.getInt("actor_id"));
				f1.setFilm_id(rs.getInt("film_id"));
				f1.setLast_update(rs.getString("last_update"));
				

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

	public List<FilmActor> findByName(String lastUpdate) {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM FILM_ACTOR WHERE LAST_UPDATE=?";

			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, lastUpdate);

			rs = pstm.executeQuery();
			FilmActor f2 = new FilmActor();
			trovaNome = new ArrayList<FilmActor>();
			while (rs.next()) {
				
				f2.setActor_id(rs.getInt("actor_id"));
				f2.setFilm_id(rs.getInt("film_id"));
				f2.setLast_update(rs.getString("last_update"));

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

	public int updateFilmActor(FilmActor filmActor) {
		int modifica = 0;
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "UPDATE FILM SET LAST_UPDATE=? WHERE FILM_ID=?";

			pstm = conn.prepareStatement(SQL);

			pstm.setString(1, filmActor.getLast_update());
			pstm.setInt(2, filmActor.getFilm_id());

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
			log.info("modifica andata a buon fine!" );
		}
		return modifica;
	}

	public int deletFilmActor(FilmActor filmActor) {
		int canc = 0;
		try {
			conn = DbConn.getInstance().getConnection();
			String SQL = "DELETE FROM FILM_ACTOR WHERE FILM_ID=?";

			pstm = conn.prepareStatement(SQL);

			pstm.setInt(1, filmActor.getFilm_id());
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
			log.info("cancellazione andata a buon fine!" );
		}
		return canc;
	}


	public List<FilmActorDto> infoFilmActor() {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT F.TITLE,F.DESCRIPTION, FA.LAST_UPDATE " + 
					"FROM FILM F " + 
					"INNER JOIN FILM_ACTOR FA " + 
					"ON F.FILM_ID=FA.FILM_ID";

			stm = conn.createStatement();

			rs = stm.executeQuery(SQL);
			
			FilmActorDto dto = new FilmActorDto();
			
			trovaInfo=new ArrayList<FilmActorDto>();
			
			while (rs.next()) {
				dto.setTitle(rs.getString("title"));
				dto.setDescription(rs.getString("description"));
				dto.setLast_update(rs.getString("last_update"));
				
				

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
log.info("lettura tramite join effettuata");
		}
		return trovaInfo;
	}


	public int inserisciFa(List<FilmActor> filmActor) {
		int insert = 0;
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "insert into film_actor(actor_id, film_id,last_update) " + "values(?, ?,?)";

			pstm = conn.prepareStatement(SQL);
			for (FilmActor fa : filmActor) {
				
log.info(fa.getActor_id()+fa.getFilm_id()+fa.getLast_update());
				pstm.setInt(1, fa.getActor_id());
				pstm.setInt(2, fa.getFilm_id());
				pstm.setString(3, fa.getLast_update() );
				
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
