package org.generation.java12_unit_tests_junit5.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
@DisplayName("Prueba unitarias de la clase Calculator")
public class CalculatorTest {
	
	Calculator calculator;
	
	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}
	
	@Test
	void addTest() {
		assertEquals(5, calculator.add(2, 3));
	}
	
	@Test
	@DisplayName("Resta de números enteros")
	void restTest(){
		assertEquals(5, calculator.rest(6,1));
	}
	
    /**
     * @ParameterizedTest permite ejecutar una prueba unitaria varias
     * veces con diferentes parámetros. Es útil cuando se quiere
     * probar el mismo método con diferentes entradas y resultados
     * esperados, sin necesidad de escribir varias pruebas manualmente.
     *
     * @CsvSource es una anotación que se utiliza junto con ParameterizedTest
     * para proporcionar datos a la prueba. Los datos se suministran
     * en formato CSV (valores separados por comas) y se asignan a
     * los parámetros del método de prueba. Cada línea de datos
     * representa una ejecución del test con diferentes valores.
     *
     */
    @ParameterizedTest(name="Prueba resta de {0} - {1} = {2}")
    @CsvSource({
            "0, 10, -10",
            "10, 3, 7",
            "-6, -5, -1"
    })
	void restParameterizedTest(int first, int second, int expectedResult) {
		assertEquals( expectedResult, calculator.rest(first, second));
	}



}
