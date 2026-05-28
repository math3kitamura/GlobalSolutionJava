package model;

import abstracts.Usuario;
import interfaces.Notificavel;

public class Medico extends Usuario implements Notificavel {

    private String crm;
    private String especialidade;

    public Medico(int id, String nome, String cpf, String telefone, String login, String senha, String crm, String especialidade) {

        super(id, nome, cpf, telefone, login, senha);

        this.crm = crm;
        this.especialidade = especialidade;
    }

    public void realizarConsulta() {

        System.out.println("Consulta realizada");
    }

    public void emitirDiagnostico() {

        System.out.println("Diagnóstico emitido");
    }

    @Override
    public void exibirDados() {

        System.out.println("===== MÉDICO =====");
        System.out.println("Nome: " + getNome());
        System.out.println("CRM: " + crm);
        System.out.println("Especialidade: " + especialidade);
    }

    @Override
    public void enviarNotificacao() {

        System.out.println("Notificação enviada ao paciente");
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}