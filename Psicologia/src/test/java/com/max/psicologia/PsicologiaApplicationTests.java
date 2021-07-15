package com.max.psicologia;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PsicologiaApplicationTests {

	@Test
	void contextLoads() {
		String page = "1~109";
		String surg = page.substring(page.lastIndexOf("~")+1,page.length());
		System.out.print(surg);
	}

}
