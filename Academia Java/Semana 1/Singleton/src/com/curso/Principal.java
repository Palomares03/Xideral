//@author Enrique Palomares
package com.curso;

public class Principal {

    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        s1.setValor("Hello");
        System.out.println(s2.getValor());

    }

}
