package service;

import model.Consulta;

import java.util.ArrayList;

public class ConsultaService {

    private ArrayList<Consulta> consultas = new ArrayList();

    public void agendarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
        System.out.println("Consulta agendada com sucesso!");
    }

    public void iniciarConsulta(Consulta consulta) {
        if (consulta != null) {
            consulta.iniciarConsulta();
        }

    }

    public void finalizarConsulta(Consulta consulta) {
        if (consulta != null) {
            consulta.finalizarConsulta();
        }

    }

    public void cancelarConsulta(Consulta consulta) {
        if (consulta != null) {
            consulta.cancelarConsulta();
        }

    }

    public void emitirDiagnostico(Consulta consulta, String diagnostico) {
        if (consulta != null) {
            consulta.setDiagnostico(diagnostico);
            System.out.println("Diagnóstico registrado na consulta.");
        }

    }

    public void listarConsultas() {
        for(Consulta consulta : this.consultas) {
            consulta.exibirResumo();
        }

    }

    public int quantidadeConsultas() {
        return this.consultas.size();
    }

    public ArrayList<Consulta> getConsultas() {
        return this.consultas;
    }

    public Consulta buscarConsultaPorId(int idConsulta) {
        for(Consulta consulta : this.consultas) {
            if (consulta.getIdConsulta() == idConsulta) {
                return consulta;
            }
        }

        return null;
    }
}