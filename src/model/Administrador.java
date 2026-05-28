package model;

import abstracts.Usuario;
import interfaces.Notificavel;

public class Administrador extends Usuario implements Notificavel {

    public Administrador(int id, String nome, String cpf, String telefone, String login, String senha) {

        super(id, nome, cpf, telefone, login, senha);
    }

    public void gerarRelatorioSistema() {

        System.out.println("Relatório do sistema gerado");
    }

    public void listarUsuarios() {

        System.out.println("Usuários listados");
    }

    @Override
    public void exibirDados() {

        System.out.println("===== ADMINISTRADOR =====");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
    }

    @Override
    public void enviarNotificacao() {

        System.out.println("Notificação geral enviada");
    }
}