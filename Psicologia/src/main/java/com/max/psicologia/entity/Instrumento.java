package com.max.psicologia.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the instrumento database table.
 * 
 */
@Entity
@NamedQuery(name="Instrumento.findAll", query="SELECT i FROM Instrumento i")
public class Instrumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_instrumento")
	private int idInstrumento;

	private String instrumento;

	//bi-directional many-to-many association to Fase
	@ManyToMany(mappedBy="instrumentos")
	private List<Fase> fases;

	public Instrumento() {
	}

	public int getIdInstrumento() {
		return this.idInstrumento;
	}

	public void setIdInstrumento(int idInstrumento) {
		this.idInstrumento = idInstrumento;
	}

	public String getInstrumento() {
		return this.instrumento;
	}

	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

	public List<Fase> getFases() {
		return this.fases;
	}

	public void setFases(List<Fase> fases) {
		this.fases = fases;
	}

}