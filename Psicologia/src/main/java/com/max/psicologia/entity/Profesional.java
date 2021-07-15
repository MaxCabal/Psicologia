package com.max.psicologia.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the profesional database table.
 * 
 */
@Entity
@NamedQuery(name="Profesional.findAll", query="SELECT p FROM Profesional p")
public class Profesional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String rut;

	private String apellidos;

	private String contrasena;

	private String direccion;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_ingreso")
	private Date fecIngreso;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_nac")
	private Date fecNac;

	private String nombre;

	@Column(name="nombre_usuario")
	private String nombreUsuario;

	private String telefono;

	//bi-directional many-to-one association to Intervencion
	@OneToMany(mappedBy="profesional")
	private List<Intervencion> intervencions;

	//bi-directional many-to-one association to Comuna
	@ManyToOne
	@JoinColumn(name="id_comuna")
	private Comuna comuna;

	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="profesional_rol"
		, joinColumns={
			@JoinColumn(name="rut")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_rol")
			}
		)
	private List<Rol> rols;

	public Profesional() {
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecIngreso() {
		return this.fecIngreso;
	}

	public void setFecIngreso(Date fecIngreso) {
		this.fecIngreso = fecIngreso;
	}

	public Date getFecNac() {
		return this.fecNac;
	}

	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Intervencion> getIntervencions() {
		return this.intervencions;
	}

	public void setIntervencions(List<Intervencion> intervencions) {
		this.intervencions = intervencions;
	}

	public Intervencion addIntervencion(Intervencion intervencion) {
		getIntervencions().add(intervencion);
		intervencion.setProfesional(this);

		return intervencion;
	}

	public Intervencion removeIntervencion(Intervencion intervencion) {
		getIntervencions().remove(intervencion);
		intervencion.setProfesional(null);

		return intervencion;
	}

	public Comuna getComuna() {
		return this.comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

}