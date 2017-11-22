package model;

import java.io.Serializable;

public class Personaje implements Serializable{
	private Long id;
	private String posicion_actual;
	private String velocidad;
	private String estado;
	
	public Personaje(Long id, String posicion_actual, String velocidad, String estado) {
		super();
		this.id = id;
		this.posicion_actual = posicion_actual;
		this.velocidad = velocidad;
		this.estado = estado;
	}
	public Personaje() {
		this (0L,"","","");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPosicion_actual() {
		return posicion_actual;
	}

	public void setPosicion_actual(String posicion_actual) {
		this.posicion_actual = posicion_actual;
	}

	public String getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Personaje [id=" + id + ", posicion_actual=" + posicion_actual + ", velocidad=" + velocidad + ", estado="
				+ estado + "]";
	}

	
	
	
	
	
	
}
