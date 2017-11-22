package dao;

import java.util.List;

import model.Personaje;

public interface PersonajeDAO {
	void createPersonaje(Personaje personaje);
	Personaje readPersonaje(Long id);
	List<Personaje> readAllPersonajes();
	void updatePersonaje(Personaje personaje);
	void deletePersonaje(Long id);
}
