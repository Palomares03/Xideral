package Calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;


class TestExam {
	
	@BeforeAll
	static void antesEach(TestInfo prueba) {
		System.out.println("Iniciando Pruebas");
	}//Ejecución de Mensaje de inicio
	
	@AfterAll
	static void despuesEach(TestInfo info) {
		System.out.println("Terminando Pruebas");
	}//Ejecución de Mensaje de termino

	@Test
	void testSuma() {
		Operacion c1 = new Numero(5);
		Operacion c2 = new Numero(15);
		Operacion suma = new Suma(c1,c2);
		assertEquals(20,suma.getValor());
	}//Comparación entre suma
	
	@Test
	void testResta() {
		Operacion c1 = new Numero(15);
		Operacion c2 = new Numero(10);
		Operacion Resta = new Resta(c1,c2);
		assertTrue(5==Resta.getValor());
	}//Comparación entre resta
	
	@Test
	void testMulti() {
		Operacion c1 = new Numero(5);
		Operacion c2 = new Numero(3);
		Operacion Multi = new Multi(c1,c2);
		assertEquals(Multi.getValor(),5*3);
	}//Comparación entre multiplicacion
	
	@Test
	void testDiv() {
		Operacion c1 = new Numero(5);
		Operacion c2 = new Numero(15);
		Operacion Div = new Div(c1,c2);
		assertEquals(0.33,.01,Div.getValor());
	}//Comparación entre division
	
	@Test
	void raiz() {
		double d=16;
		double res1 = Math.sqrt(d);
		assertEquals(4, res1);
	}//Prueba independiente de raíz cuadrada
	
	//Formula general de ecuaciones de segundo grado
	//x=(-b + √((b^2)-(4*a*c))/(2*a)
	//x=(-b - √((b^2)-(4*a*c))/(2*a)
	
	
	//Resultado Positivo de la Formula general de ecuaciones de segundo grado
	@Test
	void testFormSuma() {
		
		//Valores
		Operacion a = new Numero(4);
		Operacion b = new Numero(9);
		Operacion c = new Numero(2);
		
		//Resta de la operación Interna de la raíz cuadrada				
		Operacion r = new Resta(
				new Multi(b,b),
				new Multi(new Numero(4),
						  new Multi(a,c)
						  )
				);
		//Raíz cuadrada
		Operacion res = new Numero(
				Math.sqrt(r.getValor())
				);
		
		//Division final
		Operacion res1 = new Div(
				
				new Suma(
						new Multi(new Numero(-1),b),res
						),
				new Multi(
						new Numero(2),a
						)
				);
		
		assertEquals(res1.getValor(),-0.25,0.01);
		
		
	}
	
	
	//Resultado Negativo de la Formula general de ecuaciones de segundo grado
	@Test
	void testFormResta() {
		
		//Valores
		Operacion a = new Numero(4);
		Operacion b = new Numero(9);
		Operacion c = new Numero(2);
		
		//Resta de la operación Interna de la raíz cuadrada				
		Operacion r = new Resta(
				new Multi(b,b),
				new Multi(new Numero(4),
						  new Multi(a,c)
						  )
				);
		//Raíz cuadrada
		Operacion res = new Numero(
				Math.sqrt(r.getValor())
				);
		
		//Division final
		Operacion res1 = new Div(
				
				new Resta(
						new Multi(new Numero(-1),b),res
						),
				new Multi(
						new Numero(2),a
						)
				);
		
		assertEquals(res1.getValor(),-2);
		
		
	}
	
}
