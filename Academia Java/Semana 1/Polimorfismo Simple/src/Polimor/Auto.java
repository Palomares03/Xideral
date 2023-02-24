//@author Enrique Palomares
package Polimor;

public class Auto {     //Clase Padre
    
    //Atributos
    private String marca;       
    private String color;
    private String modelo;

    public Auto(String marca, String color, String modelo) {
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
    }

    //Metodo
    public void mostrarDatos() {
        System.out.println("Marca: " + marca);
        System.out.println("Color: " + color);
        System.out.println("Modelo: " + modelo);
    }

}
