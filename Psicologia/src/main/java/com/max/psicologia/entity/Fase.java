package com.max.psicologia.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fase database table.
 * 
 */
@Entity
@NamedQuery(name="Fase.findAll", query="SELECT f FROM Fase f")
public class Fase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_fase")
	private int idFase;

	private int duracion;

	@Column(name="fase")
	private String faseDesc;

	//bi-directional many-to-many association to Instrumento
	@ManyToMany
	@JoinTable(
		name="fase_instrumento"
		, joinColumns={
			@JoinColumn(name="id_fase")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_instrumento")
			}
		)
	private List<Instrumento> instrumentos;

	//bi-directional many-to-one association to Intervencion
	@OneToMany(mappedBy="fase")
	private List<Intervencion> intervencions;

	public Fase() {
	}

	public int getIdFase() {
		return this.idFase;
	}

	public void setIdFase(int idFase) {
		this.idFase = idFase;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getFaseDesc() {
		return this.faseDesc;
	}

	public void setFaseDesc(String fase) {
		this.faseDesc = fase;
	}

	public List<Instrumento> getInstrumentos() {
		return this.instrumentos;
	}

	public void setInstrumentos(List<Instrumento> instrumentos) {
		this.instrumentos = instrumentos;
	}

	public List<Intervencion> getIntervencions() {
		return this.intervencions;
	}

	public void setIntervencions(List<Intervencion> intervencions) {
		this.intervencions = intervencions;
	}

	public Intervencion addIntervencion(Intervencion intervencion) {
		getIntervencions().add(intervencion);
		intervencion.setFase(this);

		return intervencion;
	}

	public Intervencion removeIntervencion(Intervencion intervencion) {
		getIntervencions().remove(intervencion);
		intervencion.setFase(null);

		return intervencion;
	}

}