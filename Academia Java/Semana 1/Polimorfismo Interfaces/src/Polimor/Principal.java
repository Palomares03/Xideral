//@author Enrique Palomares
package Polimor;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        List<Auto> autos = new ArrayList<>();

        //autos.add(new Auto("Nissan", "Blanco", "Tsuru") {});
        autos.add(new Electrico("Tesla", "Negro", "Model S", 500));
        autos.add(new Pickup("Ford", "Gris", "F-150", 2000));
        autos.add(new Deportivo("Chevrolet", "Amarillo", "corvette ", 312));

        for (Auto au : autos) {
            au.mostrarDatos();
            System.out.println("");
        }

    }

}
