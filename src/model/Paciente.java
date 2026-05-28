package model;

import abstracts.Usuario;
import interfaces.Monitoravel;

public class Paciente extends Usuario implements Monitoravel {

    private int idade;
    private String sintomas;
    private String historicoMedico;

    public Paciente(int id, String nome, String cpf, String telefone, String login, String senha, int idade, String sintomas, String historicoMedico) {

        super(id, nome, cpf, telefone, login, senha);

        this.idade = idade;
        this.sintomas = sintomas;
        this.historicoMedico = historicoMedico;
    }

    public void solicitarConsulta() {

        System.out.println("Consulta solicitada");
    }

    public void visualizarHistorico() {

        System.out.println(historicoMedico);
    }

    @Override
    public void exibirDados() {

        System.out.println("===== PACIENTE =====");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Idade: " + idade);
        System.out.println("Sintomas: " + sintomas);
    }

    @Override
    public void emitirAlerta() {

        System.out.println("Alerta médico emitido");
    }

    @Override
    public void gerarRelatorio() {

        System.out.println("Relatório do paciente gerado");
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }
}