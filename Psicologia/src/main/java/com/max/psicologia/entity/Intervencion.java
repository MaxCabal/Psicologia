package com.max.psicologia.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the intervencion database table.
 * 
 */
@Entity
@NamedQuery(name="Intervencion.findAll", query="SELECT i FROM Intervencion i")
@NoArgsConstructor
@Data
public class Intervencion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_intervencion")
	private int idIntervencion;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_control")
	private Date fecControl;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String objetivo;

	private String observaciones;

	@Column(name="referencia_instrumento")
	private int referenciaInstrumento;

	private int valor;

	//bi-directional many-to-one association to Fase
	@ManyToOne
	@JoinColumn(name="id_fase")
	private Fase fase;

	//bi-directional many-to-one association to Profesional
	@ManyToOne
	@JoinColumn(name="rut_profesional")
	private Profesional profesional;

	//bi-directional many-to-one association to Sesion
	@ManyToOne
	@JoinColumn(name="id_sesion")
	private Sesion sesion;

	//bi-directional many-to-one association to TipoIntervencion
	@ManyToOne
	@JoinColumn(name="id_tipo_intervencion")
	private TipoIntervencion tipoIntervencion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="rut")
	private Usuario usuario;
	
	@Transient
	private String rut;

	public int getIdIntervencion() {
		return idIntervencion;
	}

	public void setIdIntervencion(int idIntervencion) {
		this.idIntervencion = idIntervencion;
	}

	public Date getFecControl() {
		return fecControl;
	}

	public void setFecControl(Date fecControl) {
		this.fecControl = fecControl;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getReferenciaInstrumento() {
		return referenciaInstrumento;
	}

	public void setReferenciaInstrumento(int referenciaInstrumento) {
		this.referenciaInstrumento = referenciaInstrumento;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	public Sesion getSesion() {
		return sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

	public TipoIntervencion getTipoIntervencion() {
		return tipoIntervencion;
	}

	public void setTipoIntervencion(TipoIntervencion tipoIntervencion) {
		this.tipoIntervencion = tipoIntervencion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	

}