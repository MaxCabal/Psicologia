package com.max.psicologia.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the intervencion database table.
 * 
 */
@Entity
@NamedQuery(name="Intervencion.findAll", query="SELECT i FROM Intervencion i")
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

	@Column(name="visita_id_visita")
	private int visitaIdVisita;

	//bi-directional many-to-one association to Fase
	@ManyToOne
	private Fase fase;

	//bi-directional many-to-one association to Sesion
	@ManyToOne
	private Sesion sesion;

	//bi-directional many-to-one association to TipoIntervencion
	@ManyToOne
	@JoinColumn(name="id_tipo_intervencion")
	private TipoIntervencion tipoIntervencion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="rut")
	private Usuario usuario;

	public Intervencion() {
	}

	public int getIdIntervencion() {
		return this.idIntervencion;
	}

	public void setIdIntervencion(int idIntervencion) {
		this.idIntervencion = idIntervencion;
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

	public int getVisitaIdVisita() {
		return this.visitaIdVisita;
	}

	public void setVisitaIdVisita(int visitaIdVisita) {
		this.visitaIdVisita = visitaIdVisita;
	}

	public Fase getFase() {
		return this.fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Sesion getSesion() {
		return this.sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

	public TipoIntervencion getTipoIntervencion() {
		return this.tipoIntervencion;
	}

	public void setTipoIntervencion(TipoIntervencion tipoIntervencion) {
		this.tipoIntervencion = tipoIntervencion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}