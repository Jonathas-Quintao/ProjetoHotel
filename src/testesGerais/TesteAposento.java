package testesGerais;

import entidades.Aposento;

public class TesteAposento {
    public static void main(String[] args) {
        Aposento a1 = new Aposento(21, "suite", 5000);
        Aposento a2 = new Aposento(32, "suite", 100);

        System.out.println(a1.getPreco());
        System.out.println(a2.getPreco());

        System.out.println(a1.getQuarto());
        System.out.println(a2.getQuarto());

        System.out.println(a1.toString());
        System.out.println(a2.toString());

    }
}
