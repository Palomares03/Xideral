package Calculadora;

public class Suma implements Operacion{
	
	Operacion num1;
	Operacion num2;
	
	//Obtención de valores
	
	public Suma(Operacion num1, Operacion num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	
	//Retorna resultado de la operación
	@Override
	public Double getValor() {
		return num1.getValor()+num2.getValor();
	}
	

}
