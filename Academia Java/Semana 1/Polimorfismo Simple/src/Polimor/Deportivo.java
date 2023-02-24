//@author Enrique Palomares
package Polimor;

public class Deportivo extends Auto {       //Clase Hijo heredadno datos de Auto

    private int vm;

    public Deportivo(String marca, String color, String modelo, int vm) {
        super(marca, color, modelo);
        this.vm = vm;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Velocidad Maxima: " + vm);
    }
}
