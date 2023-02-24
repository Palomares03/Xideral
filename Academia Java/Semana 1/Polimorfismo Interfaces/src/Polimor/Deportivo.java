//@author Enrique Palomares
package Polimor;

public class Deportivo implements Auto {

    private String marca;
    private String color;
    private String modelo;
    private int vm;

    public Deportivo(String marca, String color, String modelo, int vm) {
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.vm = vm;
    }

    public void mostrarDatos() {
        System.out.println("marca=" + marca + ", color=" + color +
                ", modelo=" + modelo + ", Velocidad Maxima=" + vm);
    }

    

}
