package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.omg.CORBA.NO_MEMORY;

import dao.ActorDao;
import dto.ActorDto;
import dto.ActorDto2;
import dto.AddressDto;
import model.Actor;
import model.Address;
import model.Customer;
import utilis.DbConn;

public class ActorDaoImpl implements ActorDao {
	
	private static final Logger log = Logger.getLogger(ActorDaoImpl.class);
	
	private Connection conn;
	private Statement stm;
	private PreparedStatement pstm;
	private ResultSet rs;
	private List<Actor> listActor;
	private List<Actor> trovaId;
	private List<Actor> trovaNome;
	private List<ActorDto> listdto;
	private List<ActorDto2> datoAttore;

	public List<Actor> findsAllActor() {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM ACTOR";

			stm = conn.createStatement();
			rs = stm.executeQuery(SQL);

			listActor = new ArrayList<Actor>();
			while (rs.next()) {
				Actor act = new Actor();
				act.setActor_id(rs.getInt("actor_id"));
				act.setFirst_name(rs.getString("first_name"));
				act.setLast_name(rs.getString("last_name"));
				act.setLast_update(rs.getString("last_update"));

				listActor.add(act);
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
			log.info("lettura dati attori effettuata");
		}

		return listActor;

	}

	public List<Actor> findsById(int id) {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM ACTOR WHERE ACTOR_ID=?";

			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, id);

			rs = pstm.executeQuery();

			trovaId = new ArrayList<Actor>();
			while (rs.next()) {
				Actor act1 = new Actor();
				act1.setActor_id(rs.getInt("actor_id"));
				act1.setFirst_name(rs.getString("first_name"));
				act1.setLast_name(rs.getString("last_name"));
				act1.setLast_update(rs.getString("last_update"));

				trovaId.add(act1);

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

	public List<Actor> findsByName(String nameActor) {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT * FROM ACTOR WHERE FIRST_NAME=?";

			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, nameActor);

			rs = pstm.executeQuery();
			trovaNome = new ArrayList<Actor>();
			while (rs.next()) {
				Actor act2 = new Actor();
				act2.setActor_id(rs.getInt("actor_id"));
				act2.setFirst_name(rs.getString("first_name"));
				act2.setLast_name(rs.getString("last_name"));
				act2.setLast_update(rs.getString("last_update"));

				trovaNome.add(act2);
				
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

	public int updateActor(Actor actor) {
		int modifica = 0;
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "UPDATE ACTOR SET FIRST_NAME=? WHERE ACTOR_ID=?";

			pstm = conn.prepareStatement(SQL);

			pstm.setString(1, actor.getFirst_name());
			pstm.setInt(2, actor.getActor_id());

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

	public int deleteActor(Actor actor) {
		int canc = 0;
		try {
			conn = DbConn.getInstance().getConnection();
			String SQL = "DELETE FROM ACTOR WHERE ACTOR_ID=?"; 

			pstm = conn.prepareStatement(SQL);

			pstm.setInt(1, actor.getActor_id());
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

	public List<ActorDto> findAllInfoActor() {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "SELECT A.FIRST_NAME, A.LAST_NAME, FC.FILM_ID, F.TITLE " + "FROM ACTOR A "
					+ "INNER JOIN FILM_ACTOR FC " + "ON A.ACTOR_ID=FC.ACTOR_ID " + "INNER JOIN FILM F "
					+ "ON F.FILM_ID=FC.FILM_ID";

			stm = conn.createStatement();

			rs = stm.executeQuery(SQL);

			listdto = new ArrayList<ActorDto>();
			while (rs.next()) {
				ActorDto dto = new ActorDto();
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setFilm_id(rs.getInt("film_id"));
				dto.setTitle(rs.getString("title"));

				listdto.add(dto);

				
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
log.info("lettura dati join 1 effettuata");
		}
		return listdto;
	}
/*
 * dato un attore , visualizzare tutti i film , 
 * in quale lingua e in quale categoria sono stati 
 * fatti dall'attore. 
 */

	public List<ActorDto2> datoAttore(String actorName) {
		try {
			conn=DbConn.getInstance().getConnection();
			
			String SQL="select f.title, l.name, c.name " + 
					"from actor a " + 
					"inner join film_actor fa " + 
					"on a.actor_id=fa.actor_id " + 
					"inner join film f " + 
					"on f.film_id=fa.film_id " + 
					"inner join language l " + 
					"on f.language_id=l.language_id " + 
					"inner join film_category fc " + 
					"on fc.film_id=f.film_id " + 
					"inner join category c " + 
					"on c.category_id=fc.category_id " + 
					"where a.first_name=?"; 
			
			pstm=conn.prepareStatement(SQL);
			
			pstm.setString(1, actorName);
			rs=pstm.executeQuery();
			datoAttore=new ArrayList<ActorDto2>();
			while (rs.next()) {
				ActorDto2 act=new ActorDto2();
				
			act.setTitle(rs.getString("title"));
			act.setLanguageName(rs.getNString("name"));
			act.setCategoryName(rs.getNString("name"));
			
			datoAttore.add(act);
	
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
log.info("lettura dati join 2 effettuata");
		}
		return datoAttore;

	}

	public int insertActor(List<Actor> actor) {
		int insert = 0;
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "insert into actor(actor_id, first_name, last_name, last_update) " + 
					"values (?, ?, ?, ?)";

			pstm = conn.prepareStatement(SQL);
			for (Actor act : actor) {
				
				
				log.info(act.getActor_id()+act.getFirst_name()+act.getLast_name()+act.getLast_update());
				
				pstm.setInt(1, act.getActor_id());
				pstm.setString(2, act.getFirst_name());
				pstm.setString(3, act.getLast_name());
				pstm.setString(4,act.getLast_update());
				

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
