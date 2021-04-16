package com.max.psicologia.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the region database table.
 * 
 */
@Entity
@NamedQuery(name="Region.findAll", query="SELECT r FROM Region r")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_region")
	private int idRegion;

	private String region;

	//bi-directional many-to-one association to Comuna
	@OneToMany(mappedBy="region")
	private List<Comuna> comunas;

	public Region() {
	}

	public int getIdRegion() {
		return this.idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<Comuna> getComunas() {
		return this.comunas;
	}

	public void setComunas(List<Comuna> comunas) {
		this.comunas = comunas;
	}

	public Comuna addComuna(Comuna comuna) {
		getComunas().add(comuna);
		comuna.setRegion(this);

		return comuna;
	}

	public Comuna removeComuna(Comuna comuna) {
		getComunas().remove(comuna);
		comuna.setRegion(null);

		return comuna;
	}

}