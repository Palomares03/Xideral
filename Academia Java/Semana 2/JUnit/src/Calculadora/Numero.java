package Calculadora;

public class Numero implements Operacion {
	
	double num;

	//Obtiene valor
	
	public Numero(double num) {
		this.num = num;
	}

	
	//Retorna valor
	@Override
	public Double getValor() {
		return num;
	}

}