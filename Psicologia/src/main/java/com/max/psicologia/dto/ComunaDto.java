package com.max.psicologia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//@AllArgsConstructor
public class ComunaDto {
	public ComunaDto(int idComuna2, String comuna2, int idRegion2) {
		// TODO Auto-generated constructor stub
	}
	int idComuna;
	String comuna;
	int idRegion;
}
