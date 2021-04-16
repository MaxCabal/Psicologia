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

	private String observaciones;

	private String tratamiento;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="rut")
	private Paciente paciente;

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

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}