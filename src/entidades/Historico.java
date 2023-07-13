package entidades;


import Exceptions.ExceptionDateNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Historico<T> extends ListaGenerica<Hospedagem> {

    private static ListaGenerica<Hospedagem> historico;

    public Historico() {
        historico = new ListaGenerica<Hospedagem>();
    }

    public HashMap<String, Double> listarHospedesEGastos() throws ExceptionDateNull {
        HashMap<String, Double> hospedesEGastos = new HashMap<>();

        for (Hospedagem hospedagem : this) {
            Hospede hospede = hospedagem.getHospede();
            String nomeHospede = hospede.getNome();
            double valorConta = hospedagem.valorDaConta();

            if (hospedesEGastos.containsKey(nomeHospede)) {
                double totalGasto = hospedesEGastos.get(nomeHospede);
                totalGasto += valorConta;
                hospedesEGastos.put(nomeHospede, totalGasto);
            } else {
                hospedesEGastos.put(nomeHospede, valorConta);
            }
        }

        return hospedesEGastos;
    }


    public static double faturamentoTotal(Historico<Hospedagem> historico) {
        double soma = 0;
        for(Hospedagem hospedagem : historico) {
            try {
                soma += hospedagem.valorDaConta();
            } catch (ExceptionDateNull e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return soma;
    }



}