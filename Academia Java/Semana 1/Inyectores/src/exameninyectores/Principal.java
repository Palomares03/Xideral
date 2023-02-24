//@author Enrique Palomares
package exameninyectores;

public class Principal {
    
    public static void main(String[] args) {

        Piloto sp = new Piloto("Sergio Perez");

        Inyector.inyectaMonoplaza(sp);

        sp.conducir();
    }
    
}
