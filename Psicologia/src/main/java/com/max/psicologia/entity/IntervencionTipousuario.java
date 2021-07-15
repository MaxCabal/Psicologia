package com.max.psicologia.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the intervencion_tipousuario database table.
 * 
 */
@Entity
@Table(name="intervencion_tipousuario")
@NamedQuery(name="IntervencionTipousuario.findAll", query="SELECT i FROM IntervencionTipousuario i")
public class IntervencionTipousuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name="fec_control")
	private Date fecControl;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="id_fase")
	private int idFase;

	@Column(name="id_intervencion")
	private int idIntervencion;

	@Column(name="id_sesion")
	private int idSesion;

	@Column(name="id_tipo_intervencion")
	private int idTipoIntervencion;

	private String objetivo;

	private String observaciones;

	@Column(name="referencia_instrumento")
	private int referenciaInstrumento;

	private String rut;

	@Column(name="rut_profesional")
	private String rutProfesional;

	private int valor;

	public IntervencionTipousuario() {
	}

	public Date getFecControl() {
		return this.fecControl;
	}

	public void setFecControl(Date fecControl) {
		this.fecControl = fecControl;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdFase() {
		return this.idFase;
	}

	public void setIdFase(int idFase) {
		this.idFase = idFase;
	}

	public int getIdIntervencion() {
		return this.idIntervencion;
	}

	public void setIdIntervencion(int idIntervencion) {
		this.idIntervencion = idIntervencion;
	}

	public int getIdSesion() {
		return this.idSesion;
	}

	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}

	public int getIdTipoIntervencion() {
		return this.idTipoIntervencion;
	}

	public void setIdTipoIntervencion(int idTipoIntervencion) {
		this.idTipoIntervencion = idTipoIntervencion;
	}

	public String getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getReferenciaInstrumento() {
		return this.referenciaInstrumento;
	}

	public void setReferenciaInstrumento(int referenciaInstrumento) {
		this.referenciaInstrumento = referenciaInstrumento;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getRutProfesional() {
		return this.rutProfesional;
	}

	public void setRutProfesional(String rutProfesional) {
		this.rutProfesional = rutProfesional;
	}

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}