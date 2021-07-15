package com.max.psicologia.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the comuna database table.
 * 
 */
@Entity
@NamedQuery(name="Comuna.findAll", query="SELECT c FROM Comuna c")
public class Comuna implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_comuna")
	private int idComuna;

	private String comuna;

	//bi-directional many-to-one association to Region
	@ManyToOne
	@JoinColumn(name="id_region")
	private Region region;

	//bi-directional many-to-one association to Profesional
	@OneToMany(mappedBy="comuna")
	private List<Profesional> profesionals;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="comuna")
	private List<Usuario> usuarios;

	public Comuna() {
	}

	public int getIdComuna() {
		return this.idComuna;
	}

	public void setIdComuna(int idComuna) {
		this.idComuna = idComuna;
	}

	public String getComuna() {
		return this.comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Profesional> getProfesionals() {
		return this.profesionals;
	}

	public void setProfesionals(List<Profesional> profesionals) {
		this.profesionals = profesionals;
	}

	public Profesional addProfesional(Profesional profesional) {
		getProfesionals().add(profesional);
		profesional.setComuna(this);

		return profesional;
	}

	public Profesional removeProfesional(Profesional profesional) {
		getProfesionals().remove(profesional);
		profesional.setComuna(null);

		return profesional;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setComuna(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setComuna(null);

		return usuario;
	}

}