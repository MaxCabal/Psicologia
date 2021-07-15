package com.max.psicologia;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

public class TestDefault {
	
//	@Test                                               
    public void testMultiply() {
		List <Integer> lista = Arrays.asList (1,2,3,4,5,6,7,8,9,10);
//		lista.forEach((n) -> System.out.println(n));
//		lista.stream()
//	     .filter((x)-> x>=5)
//	     .forEach((n)-> System.out.println(n));
		
//		lista
//	     .stream()
//	     .filter((x)-> x>=5)
//	     .sorted((n1,n2)-> -(n1.compareTo(n2)))
//	     .forEach((n)-> System.out.println(n));
		
		int resultado = lista
                .stream()
                .mapToInt(v-> v.intValue()) //Pasarlo de array a entero
                .filter((x)-> x>=5)
                .sum();
		System.out.println(resultado);
    }
	
	@Test
	public void mapLambda() {
		Map<String, Integer> map = new TreeMap<>();
		map.put("mar",3);
		map.put("sol",5);
		StringBuilder stringBuilder = new StringBuilder();
		map.forEach((letter, number) -> stringBuilder.append(letter.concat(String.valueOf(number))));
		System.out.println(stringBuilder.toString());

	}
}
