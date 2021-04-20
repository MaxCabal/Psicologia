package com.max.psicologia.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the objetivo database table.
 * 
 */
@Entity
@NamedQuery(name="Objetivo.findAll", query="SELECT o FROM Objetivo o")
public class Objetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_objetivo")
	private int idObjetivo;

	private String objetivo;

	public Objetivo() {
	}

	public int getIdObjetivo() {
		return this.idObjetivo;
	}

	public void setIdObjetivo(int idObjetivo) {
		this.idObjetivo = idObjetivo;
	}

	public String getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

}