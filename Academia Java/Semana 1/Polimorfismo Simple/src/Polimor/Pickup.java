//@author Enrique Palomares
package Polimor;

public class Pickup extends Auto {      //Clase Hijo

    private int kg;

    public Pickup(String marca, String color, String modelo, int kg) {
        super(marca, color, modelo);
        this.kg = kg;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Carga Maxima Kg: " + kg);
    }
}
