package dao;

import java.util.List;

import model.Profesor;

public interface ProfesorDAO {
	void createProfesor(Profesor profesor);
	Profesor readProfesor(Long idProfesor);
	List<Profesor> readAllProfesores();
	void updateProfesor(Profesor profesor);
	void deleteProfesor(Long idProfesor);
}
