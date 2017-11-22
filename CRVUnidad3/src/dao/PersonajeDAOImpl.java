package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Personaje;

public class PersonajeDAOImpl implements PersonajeDAO {
	// Propiedades de la conexión
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public PersonajeDAOImpl() {
		getConnection();
	}

	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/personaje", "postgres", "ramos");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void createPersonaje(Personaje personaje) {
		// TODO Auto-generated method stub
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("INSERT INTO personajes ( posicion_actual, velocidad, estado)" + " values(?,?,?);");

				preparedStatement.setString(1, personaje.getPosicion_actual());
				preparedStatement.setString(2, personaje.getVelocidad());
				preparedStatement.setString(3, personaje.getEstado());
			

				preparedStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public Personaje readPersonaje(Long id) {
		// TODO Auto-generated method stub
		Personaje personaje = null;
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement("SELECT * FROM personajes WHERE id=?;");
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					personaje = new Personaje(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getString(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return personaje;
	}

	@Override
	public List<Personaje> readAllPersonajes() {
		// TODO Auto-generated method stub
		List<Personaje> personajes = new ArrayList<Personaje>();
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement("SELECT * FROM personajes");
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					Personaje personaje = new Personaje(resultSet.getLong("id"), resultSet.getString("posicion_actual"),
							resultSet.getString("velocidad"), resultSet.getString("estado"));
					personajes.add(personaje);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return personajes;
	}

	@Override
	public void updatePersonaje(Personaje personaje) {
		// TODO Auto-generated method stub
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("UPDATE personajes SET posicion_actual=?, velocidad=?, estado=?  WHERE id=?;");
				//preparedStatement.setLong(1, personaje.getId());
				preparedStatement.setString(1, personaje.getPosicion_actual());
				preparedStatement.setString(2, personaje.getVelocidad());
				preparedStatement.setString(3, personaje.getEstado());
				preparedStatement.setLong(4, personaje.getId());
				preparedStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void deletePersonaje(Long id) {
		// TODO Auto-generated method stub
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM personajes WHERE id=?;");

				preparedStatement.setLong(1, id);
				preparedStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
