//@author Enrique Palomares
package Polimor;

public class Electrico extends Auto {       //Clase Hijo

    private int km;

    public Electrico(String marca, String color, String modelo, int km) {
        super(marca, color, modelo);
        this.km = km;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Autonomia KM: " + km);
    }
}
