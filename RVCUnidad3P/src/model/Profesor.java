package model;

import java.io.Serializable;

public class Profesor implements Serializable{
	private Long id_profesor;
	private String nombre;
	private String fecha_registro;
	private String cve_prof;
	
	public Profesor(Long id_profesor, String nombre, String fecha_registro, String cve_prof) {
		super();
		this.id_profesor = id_profesor;
		this.nombre = nombre;
		this.fecha_registro = fecha_registro;
		this.cve_prof = cve_prof;
	}
	public Profesor() {
		this (0L,"","","");
	}

	public Long getId_profesor() {
		return id_profesor;
	}

	public void setId_profesor(Long id_profesor) {
		this.id_profesor = id_profesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getCve_prof() {
		return cve_prof;
	}

	public void setCve_prof(String cve_prof) {
		this.cve_prof = cve_prof;
	}

	@Override
	public String toString() {
		return "Profesor [id_profesor=" + id_profesor + ", nombre=" + nombre + ", fecha_registro=" + fecha_registro
				+ ", cve_prof=" + cve_prof + "]";
	}
	
	
	
	
	
	
}
