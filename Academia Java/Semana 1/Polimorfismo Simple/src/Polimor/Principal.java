//@author Enrique Palomares
package Polimor;

import java.util.ArrayList;     //Importar Clase para trabajar con arreglos
import java.util.List;          //Importar Clase para trabajar con listas

public class Principal {

    public static void main(String[] args) {

        List<Auto> autos = new ArrayList<>();   //creacion de arreglo

        //  Nuevos Objetos creados desde el arreglo
        autos.add(new Auto("Nissan", "Blanco", "Tsuru"));
        autos.add(new Electrico("Tesla", "Negro", "Model S", 500));
        autos.add(new Pickup("Ford", "Gris", "F-150", 2000));
        autos.add(new Deportivo("Chevrolet", "Rojo", "corvette ", 312));

        //Mostra datos creados
        for (Auto au : autos) {
            au.mostrarDatos();
            System.out.println("");
        }

    }

}
