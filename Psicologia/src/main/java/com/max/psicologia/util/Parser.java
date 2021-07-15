package com.max.psicologia.util;

import java.util.ArrayList;
import java.util.List;

import com.max.psicologia.dto.ComunaDto;
import com.max.psicologia.dto.IntervencionDetalleDto;
import com.max.psicologia.entity.Comuna;
import com.max.psicologia.entity.Intervencion;


public class Parser {
	
	public static List<ComunaDto> toListComunaDto(List<Comuna> comunas) {
		List<ComunaDto> comunasDto = new ArrayList<ComunaDto>();
		for (Comuna comuna : comunas) {
			comunasDto.add(new ComunaDto(comuna.getIdComuna(), comuna.getComuna(), comuna.getRegion().getIdRegion()));
		}
		return comunasDto;
	}
	
	public static IntervencionDetalleDto toIntervencionDto(Intervencion intervencion) {
		IntervencionDetalleDto intervencionDto = new IntervencionDetalleDto();
		intervencionDto.setObservaciones(intervencion.getObservaciones());
		intervencionDto.setObjetivo(intervencion.getObjetivo());
		intervencionDto.setFecha(intervencion.getFecha().toString());
		intervencionDto.setFechaControl(intervencion.getFecControl().toString());
		intervencionDto.setValor(String.valueOf(intervencion.getValor()));
		return intervencionDto;
	}
	
}
