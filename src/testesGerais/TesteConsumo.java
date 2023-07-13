package testesGerais;

import entidades.Consumo;

public class TesteConsumo {
    public static void main(String[] args) {
        Consumo c1 = new Consumo("chocolate", 2);

        System.out.println(c1.getProduto());

        System.out.println(c1.getPreco());

        System.out.println(c1.getCodigo());

        System.out.println(c1.toString());



    }






}
