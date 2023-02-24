//@author Enrique Palomares
package Polimor;

public class Electrico implements Auto {

    private String marca;
    private String color;
    private String modelo;
    private int km;

    public Electrico(String marca, String color, String modelo, int km) {
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.km = km;
    }

    public void mostrarDatos() {
        System.out.println("marca=" + marca + ", color=" + color +
                ", modelo=" + modelo + ", km=" + km);
    }

    

}
