package com.max.psicologia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IntervencionDetalleDto {
	public String observaciones;
	
	public String objetivo;
	
	public String fecha;
	
	public String fechaControl;
	
	public String valor;
}
