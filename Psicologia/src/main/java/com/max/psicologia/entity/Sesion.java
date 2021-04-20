package com.max.psicologia.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sesion database table.
 * 
 */
@Entity
@NamedQuery(name="Sesion.findAll", query="SELECT s FROM Sesion s")
public class Sesion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sesion")
	private int idSesion;

	private String duracion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String sesion;

	//bi-directional many-to-one association to Intervencion
	@OneToMany(mappedBy="sesion")
	private List<Intervencion> intervencions;

	public Sesion() {
	}

	public int getIdSesion() {
		return this.idSesion;
	}

	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}

	public String getDuracion() {
		return this.duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getSesion() {
		return this.sesion;
	}

	public void setSesion(String sesion) {
		this.sesion = sesion;
	}

	public List<Intervencion> getIntervencions() {
		return this.intervencions;
	}

	public void setIntervencions(List<Intervencion> intervencions) {
		this.intervencions = intervencions;
	}

	public Intervencion addIntervencion(Intervencion intervencion) {
		getIntervencions().add(intervencion);
		intervencion.setSesion(this);

		return intervencion;
	}

	public Intervencion removeIntervencion(Intervencion intervencion) {
		getIntervencions().remove(intervencion);
		intervencion.setSesion(null);

		return intervencion;
	}

}