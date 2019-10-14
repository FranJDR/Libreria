package test;

import static org.junit.jupiter.api.Assertions.*;

import modelo.Validador;

class ValidadorTest {

	Validador validador = new Validador();

	@org.junit.jupiter.api.Test
	void isNumber() {
		assertTrue(validador.isNumber("123123412"));
		assertFalse(validador.isNumber("sdasASDsdasd"));
		assertFalse(validador.isNumber("123123.123123"));
	}

}
