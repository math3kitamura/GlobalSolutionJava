package service;

import model.Consulta;

import java.util.ArrayList;

public class ConsultaService {

    private ArrayList<Consulta> consultas = new ArrayList<>();

    public void agendarConsulta(Consulta consulta) {

        consultas.add(consulta);

        System.out.println("Consulta agendada");
    }

    public void cancelarConsulta(Consulta consulta) {

        consulta.cancelarConsulta();
    }

    public void listarConsultas() {

        for (Consulta consulta : consultas) {

            consulta.exibirResumo();
        }
    }
}