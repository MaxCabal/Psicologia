package com.max.psicologia.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_intervencion database table.
 * 
 */
@Entity
@Table(name="tipo_intervencion")
@NamedQuery(name="TipoIntervencion.findAll", query="SELECT t FROM TipoIntervencion t")
public class TipoIntervencion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_intervencion")
	private int idTipoIntervencion;

	@Column(name="tipo_intervencion")
	private String tipoIntervencionDesc;

	//bi-directional many-to-one association to Intervencion
	@OneToMany(mappedBy="tipoIntervencion")
	private List<Intervencion> intervencions;

	public TipoIntervencion() {
	}

	public int getIdTipoIntervencion() {
		return this.idTipoIntervencion;
	}

	public void setIdTipoIntervencion(int idTipoIntervencion) {
		this.idTipoIntervencion = idTipoIntervencion;
	}

	public String getTipoIntervencionDesc() {
		return this.tipoIntervencionDesc;
	}

	public void setTipoIntervencionDesc(String tipoIntervencion) {
		this.tipoIntervencionDesc = tipoIntervencion;
	}

	public List<Intervencion> getIntervencions() {
		return this.intervencions;
	}

	public void setIntervencions(List<Intervencion> intervencions) {
		this.intervencions = intervencions;
	}

	public Intervencion addIntervencion(Intervencion intervencion) {
		getIntervencions().add(intervencion);
		intervencion.setTipoIntervencion(this);

		return intervencion;
	}

	public Intervencion removeIntervencion(Intervencion intervencion) {
		getIntervencions().remove(intervencion);
		intervencion.setTipoIntervencion(null);

		return intervencion;
	}

}