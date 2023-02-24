//@author Enrique Palomares
package com.curso;

public class Singleton {

    private static Singleton instancia = null;
    private String valor;

    private Singleton() {}                 //Constructor
    

    public static Singleton getInstance() {     //get para manipular el objeto
        if (instancia == null) //
            instancia = new Singleton();         //crea instancia si no existe
        
        return instancia;                      // si existe devuelve la existente
    }

    public void instance(String mensaje) {
        System.out.println(mensaje);
    }

    public void setValor(String mensaje) {
        valor = mensaje;
    }

    public String getValor() {
        return valor;
    }

}
