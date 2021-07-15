package com.max.psicologia.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.max.psicologia.dto.MesDto;
import com.max.psicologia.entity.Usuario;
import com.max.psicologia.exception.RutNoValidoException;


public class Utils {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
	
	public static String convertSHA256(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} 
		catch (NoSuchAlgorithmException e) {		
			e.printStackTrace();
			return null;
		}
		    
		byte[] hash = md.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();
		    
		for(byte b : hash) {        
			sb.append(String.format("%02x", b));
		}
		    
		return sb.toString();
	}
	
	public static void formatRutPaciente(Usuario usuario) {
		usuario.setRut(usuario.getRut().replaceAll("[\\.]",""));
	}
	
	public static boolean validarRut(String rut) throws RutNoValidoException {

	    boolean validacion = false;
	    try {
	        rut =  rut.toUpperCase();
	        rut = rut.replace(".", "");
	        rut = rut.replace("-", "");
	        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

	        char dv = rut.charAt(rut.length() - 1);

	        int m = 0, s = 1;
	        for (; rutAux != 0; rutAux /= 10) {
	            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
	        }
	        if (dv == (char) (s != 0 ? s + 47 : 75)) {
	            return true;
	        } else {
	        	throw new RutNoValidoException("Rut no valido");
	        }
	        
	    } catch (java.lang.NumberFormatException e) {
	    	throw new RutNoValidoException("Rut no valido");
	    }
	}
	
	public static Date parseDate(String fecha) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
		} catch (ParseException e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}
	
	public static java.sql.Date parseSqlDate(String fecha) {
		Date parsedDate = parseDate(fecha);
		return new java.sql.Date(parsedDate.getTime());
	}
	
	public static Date parseDateTime(String fecha) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(fecha);
		} catch (ParseException e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}
	
	public static String formatDate(Date fecha) {
		if(fecha == null) return "";
		return new SimpleDateFormat("dd/MM/yyyy").format(fecha);
	}
	
	public static Timestamp parseTimestamp(String fecha) {
		try {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		    Date parsedDate = dateFormat.parse(fecha);
		    return new java.sql.Timestamp(parsedDate.getTime());
		} catch(Exception e) {
			LOGGER.error("Error trying to convert timestamp "+e.getMessage());
		    return null;
		}
	}
	
	public static Date getAyer() {
		return Utils.parseDate(getAyerString());
	}
	
	public static String getAyerString() {
		Calendar calendario = Calendar.getInstance();
		calendario.add(Calendar.DATE, -1);
		return calendario.get(Calendar.DATE)+"/"+(calendario.get(Calendar.MONTH)+1)+"/"+calendario.get(Calendar.YEAR);
	}
	
	public static Date getPrimerDia() {
		Calendar calendario = Calendar.getInstance();
		calendario.set(Calendar.DAY_OF_MONTH,1);
		return calendario.getTime();
	}
	
	public static Date getPrimerDia(int mes) {
		Calendar calendario = Calendar.getInstance();
		calendario.set(Calendar.MONTH, mes);
		calendario.set(Calendar.DAY_OF_MONTH,1);
		return calendario.getTime();
	}
	
	public static Date getPrimerDia(int mes, int anno) {
		Calendar calendario = Calendar.getInstance();
		calendario.set(Calendar.MONTH, mes);
		calendario.set(Calendar.YEAR, anno);
		calendario.set(Calendar.DAY_OF_MONTH,1);
		return calendario.getTime();
	}
	
	public static Date getUltimoDia() {
		Calendar calendario = Calendar.getInstance();
		calendario.set(Calendar.DATE, calendario.getActualMaximum(Calendar.DATE));
		return calendario.getTime();
	}
	
	public static Date getUltimoDia(int mes) {
		Calendar calendario = Calendar.getInstance();
		calendario.set(Calendar.MONTH, mes);
		calendario.set(Calendar.DATE, calendario.getActualMaximum(Calendar.DATE));
		return calendario.getTime();
	}
	
	public static Date getUltimoDia(int mes, int anno) {
		Calendar calendario = Calendar.getInstance();
		calendario.set(Calendar.MONTH, mes);
		calendario.set(Calendar.YEAR, anno);
		calendario.set(Calendar.DATE, calendario.getActualMaximum(Calendar.DATE));
		return calendario.getTime();
	}
	
	public static int getUltimoDiaInt(int mes) {
		Calendar calendario = Calendar.getInstance();
		calendario.set(Calendar.MONTH, mes);
		return calendario.getActualMaximum(Calendar.DATE);
	}
	
	public static int getMesActualInt() {
		Calendar calendario = Calendar.getInstance();
		return calendario.get(Calendar.MONTH);
	}
	
	public static int getAnnoActualInt() {
		Calendar calendario = Calendar.getInstance();
		return calendario.get(Calendar.YEAR);
	}
	
	public static List<MesDto> getMeses() {
		List<MesDto> meses = new ArrayList<MesDto>();
		meses.add(new MesDto(0,"Enero"));
		meses.add(new MesDto(1,"Febrero"));
		meses.add(new MesDto(2,"Marzo"));
		meses.add(new MesDto(3,"Abril"));
		meses.add(new MesDto(4,"Mayo"));
		meses.add(new MesDto(5,"Junio"));
		meses.add(new MesDto(6,"Julio"));
		meses.add(new MesDto(7,"Agosto"));
		meses.add(new MesDto(8,"Septiembre"));
		meses.add(new MesDto(9,"Octubre"));
		meses.add(new MesDto(10,"Noviembre"));
		meses.add(new MesDto(11,"Diciembre"));
		return meses;
	}
	
	public static List<String> getAnnos() {
		List<String> annos = new ArrayList<String>();
		for(int i=2021;i<2100;i++) {
			annos.add(String.valueOf(i));
		}
		return annos;
	}

}
