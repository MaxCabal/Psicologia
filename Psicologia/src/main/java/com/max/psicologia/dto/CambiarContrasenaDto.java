package com.max.psicologia.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CambiarContrasenaDto {
	
	public CambiarContrasenaDto(String username) {
		this.username = username;
	}
	
	private String username;
	
	@NotBlank(message="La actual contraseña no puede ser vacia")
	private String actual;
	
	@NotBlank(message="La nueva contraseña no puede ser vacia")
	private String nueva;
	
	@NotBlank(message="La confirmacion nueva contraseña no puede ser vacia")
	private String nuevaConfirmar;
	
}
