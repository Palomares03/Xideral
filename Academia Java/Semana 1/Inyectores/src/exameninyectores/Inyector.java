//@author Enrique Palomares
package exameninyectores;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Inyector {

    static List<Monoplaza> monoplazas = Arrays.asList(
            new RB19(),
            new W14(),
            new MCL60()
    );

    static void inyectaMonoplaza(Piloto e) {
        int aleatorio = new Random().nextInt(monoplazas.size());

        Monoplaza otroMonoplaza = monoplazas.get(aleatorio);
        //INYECTAR
        e.nameMonoplaza = otroMonoplaza;
    }

}