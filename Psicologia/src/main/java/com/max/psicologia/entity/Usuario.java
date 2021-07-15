package com.max.psicologia.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String rut;

	private String apellidos;

	private String direccion;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_ingreso")
	private Date fecIngreso;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_nac")
	private Date fecNac;

	private String nombres;

	private String telefono;

	//bi-directional many-to-one association to Intervencion
	@OneToMany(mappedBy="usuario")
	private List<Intervencion> intervencions;

	//bi-directional many-to-one association to Comuna
	@ManyToOne
	@JoinColumn(name="id_comuna")
	private Comuna comuna;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado estado;

	//bi-directional many-to-one association to TipoUsuario
	@ManyToOne
	@JoinColumn(name="id_tipo_usuario")
	private TipoUsuario tipoUsuario;
	
	@Transient
	private int edad;

	public Usuario() {
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

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
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
		intervencion.setUsuario(this);

		return intervencion;
	}

	public Intervencion removeIntervencion(Intervencion intervencion) {
		getIntervencions().remove(intervencion);
		intervencion.setUsuario(null);

		return intervencion;
	}

	public Comuna getComuna() {
		return this.comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public int getEdad() {
		return Period.between(LocalDate.parse(new SimpleDateFormat("dd/MM/yyyy").format(fecNac), DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.now()).getYears();
	}

}