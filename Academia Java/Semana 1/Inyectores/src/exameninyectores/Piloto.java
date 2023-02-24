//@author Enrique Palomares
package exameninyectores;

public class Piloto {

    //HAS-A
    String nombre;
    Monoplaza nameMonoplaza;

    public Piloto(String nombre) {
        this.nombre = nombre;
    }

    void conducir() {
        System.out.println(nombre + ": Empezar a conducir "
                + nameMonoplaza.getClass().getSimpleName());
        nameMonoplaza.encender();
    }

}
