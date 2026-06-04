package view;

import abstracts.Usuario;
import app.Main;
import model.Administrador;

import javax.swing.*;
import java.awt.*;

public class TelaAdministrador extends JFrame {

    private JTextArea area;

    public TelaAdministrador() {
        setTitle("Administrador / Sistema");
        setSize(650, 430);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));

        area = new JTextArea();
        area.setEditable(false);

        JPanel botoes = new JPanel(new GridLayout(1, 5, 5, 5));
        JButton btnUsuarios = new JButton("Listar Usuários");
        JButton btnRelatorio = new JButton("Relatório Sistema");
        JButton btnNotificacao = new JButton("Notificação Geral");
        JButton btnDados = new JButton("Exibir Admin");
        JButton btnResumo = new JButton("Resumo Geral");

        botoes.add(btnUsuarios);
        botoes.add(btnRelatorio);
        botoes.add(btnNotificacao);
        botoes.add(btnDados);
        botoes.add(btnResumo);

        add(new JScrollPane(area), BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        btnUsuarios.addActionListener(e -> listarUsuarios());
        btnRelatorio.addActionListener(e -> gerarRelatorioSistema());
        btnNotificacao.addActionListener(e -> enviarNotificacao());
        btnDados.addActionListener(e -> exibirAdministrador());
        btnResumo.addActionListener(e -> resumoGeral());

        setVisible(true);
    }

    private Administrador administrador() {
        if (Main.usuarioService.listarAdministradores().isEmpty()) return null;
        return Main.usuarioService.listarAdministradores().get(0);
    }

    private void listarUsuarios() {
        Administrador admin = administrador();
        if (admin != null) admin.listarUsuarios();
        StringBuilder sb = new StringBuilder("===== USUÁRIOS CADASTRADOS =====\n");
        for (Usuario usuario : Main.usuarioService.listarUsuarios()) {
            sb.append("ID: ").append(usuario.getId())
                    .append(" | Nome: ").append(usuario.getNome())
                    .append(" | Login: ").append(usuario.getLogin())
                    .append(" | Tipo: ").append(usuario.getClass().getSimpleName())
                    .append("\n");
        }
        area.setText(sb.toString());
    }

    private void gerarRelatorioSistema() {
        Administrador admin = administrador();
        if (admin != null) admin.gerarRelatorioSistema();
        area.setText("Relatório do sistema gerado.\n\n" + montarResumo());
    }

    private void enviarNotificacao() {
        Administrador admin = administrador();
        if (admin != null) admin.enviarNotificacao();
        area.setText("Notificação geral enviada para os usuários do sistema.");
    }

    private void exibirAdministrador() {
        Administrador admin = administrador();
        if (admin == null) {
            area.setText("Nenhum administrador encontrado.");
            return;
        }
        admin.exibirDados();
        area.setText("===== ADMINISTRADOR =====\n" +
                "ID: " + admin.getId() + "\n" +
                "Nome: " + admin.getNome() + "\n" +
                "CPF: " + admin.getCpf() + "\n" +
                "Telefone: " + admin.getTelefone());
    }

    private void resumoGeral() {
        area.setText(montarResumo());
    }

    private String montarResumo() {
        return "===== RESUMO GERAL =====\n" +
                "Total de usuários: " + Main.usuarioService.quantidadeUsuarios() + "\n" +
                "Pacientes: " + Main.usuarioService.listarPacientes().size() + "\n" +
                "Médicos: " + Main.usuarioService.listarMedicos().size() + "\n" +
                "Consultas: " + Main.consultaService.quantidadeConsultas() + "\n" +
                "Leituras de monitoramento: " + Main.monitoramentoService.listarLeituras().size();
    }
}
