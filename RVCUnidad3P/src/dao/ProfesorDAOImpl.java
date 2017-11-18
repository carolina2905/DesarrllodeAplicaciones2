package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Profesor;

public class ProfesorDAOImpl implements ProfesorDAO {
	// Propiedades de la conexión
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public ProfesorDAOImpl() {
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
	public void createProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("INSERT INTO profesor ( nombre, fecha_registro, cve_prof)" + " values(?,?,?);");

				preparedStatement.setString(1, profesor.getNombre());
				preparedStatement.setString(2, profesor.getFecha_registro());
				preparedStatement.setString(3, profesor.getCve_prof());
			

				preparedStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public Profesor readProfesor(Long idProfesor) {
		// TODO Auto-generated method stub
		Profesor profesor = null;
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement("SELECT * FROM profesor WHERE id_profesor=?;");
				preparedStatement.setLong(1, idProfesor);
				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					profesor = new Profesor(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getString(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return profesor;
	}

	@Override
	public List<Profesor> readAllProfesores() {
		// TODO Auto-generated method stub
		List<Profesor> profesores = new ArrayList<Profesor>();
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement("SELECT * FROM profesor");
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					Profesor profesor = new Profesor(resultSet.getLong("id_profesor"), resultSet.getString("nombre"),
							resultSet.getString("fecha_registro"), resultSet.getString("cve_prof"));
					profesores.add(profesor);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return profesores;
	}

	@Override
	public void updateProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("UPDATE profesor SET nombre=?, fecha_registro=?, cve_prof=?  WHERE id_profesor=?;");

				preparedStatement.setString(1, profesor.getNombre());
				preparedStatement.setString(2, profesor.getFecha_registro());
				preparedStatement.setString(3, profesor.getCve_prof());
				preparedStatement.setLong(4, profesor.getId_profesor());
				preparedStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void deleteProfesor(Long idProfesor) {
		// TODO Auto-generated method stub
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM profesor WHERE id_profesor=?;");

				preparedStatement.setLong(1, idProfesor);
				preparedStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
