//@author Enrique Palomares
package Polimor;

public class Pickup implements Auto {

    private String marca;
    private String color;
    private String modelo;
    private int kg;

    public Pickup(String marca, String color, String modelo, int kg) {
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.kg = kg;
    }

    public void mostrarDatos() {
        System.out.println("marca=" + marca + ", color=" + color +
                ", modelo=" + modelo + ", Carga Maxima=" + kg);
    }

    

}
