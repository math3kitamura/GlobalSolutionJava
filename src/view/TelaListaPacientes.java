package view;

import app.Main;
import model.Paciente;

import javax.swing.*;
import java.awt.*;

public class TelaListaPacientes extends JFrame {

    private JComboBox<Paciente> cbPacientes;
    private JTextArea area;

    public TelaListaPacientes() {
        setTitle("Pacientes / Funções");
        setSize(600, 430);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));

        cbPacientes = new JComboBox<>();
        carregarPacientes();

        area = new JTextArea();
        area.setEditable(false);

        JPanel topo = new JPanel(new BorderLayout());
        topo.add(new JLabel("Paciente:"), BorderLayout.WEST);
        topo.add(cbPacientes, BorderLayout.CENTER);

        JPanel botoes = new JPanel(new GridLayout(2, 3, 5, 5));
        JButton btnExibir = new JButton("Exibir Dados");
        JButton btnHistorico = new JButton("Visualizar Histórico");
        JButton btnSolicitar = new JButton("Solicitar Consulta");
        JButton btnAlerta = new JButton("Emitir Alerta");
        JButton btnRelatorio = new JButton("Gerar Relatório");
        JButton btnAtualizar = new JButton("Atualizar Lista");

        botoes.add(btnExibir);
        botoes.add(btnHistorico);
        botoes.add(btnSolicitar);
        botoes.add(btnAlerta);
        botoes.add(btnRelatorio);
        botoes.add(btnAtualizar);

        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        btnExibir.addActionListener(e -> exibirDados());
        btnHistorico.addActionListener(e -> visualizarHistorico());
        btnSolicitar.addActionListener(e -> executarAcao("Consulta solicitada para o paciente."));
        btnAlerta.addActionListener(e -> executarAcao("Alerta emitido para o paciente."));
        btnRelatorio.addActionListener(e -> executarAcao("Relatório do paciente gerado."));
        btnAtualizar.addActionListener(e -> carregarPacientes());

        setVisible(true);
    }

    private void carregarPacientes() {
        if (cbPacientes == null) return;
        cbPacientes.removeAllItems();
        for (Paciente paciente : Main.usuarioService.listarPacientes()) {
            cbPacientes.addItem(paciente);
        }
    }

    private Paciente pacienteSelecionado() {
        return (Paciente) cbPacientes.getSelectedItem();
    }

    private void exibirDados() {
        Paciente p = pacienteSelecionado();
        if (p == null) {
            area.setText("Nenhum paciente cadastrado.");
            return;
        }
        p.exibirDados();
        area.setText("===== PACIENTE =====\n" +
                "ID: " + p.getId() + "\n" +
                "Nome: " + p.getNome() + "\n" +
                "CPF: " + p.getCpf() + "\n" +
                "Telefone: " + p.getTelefone() + "\n" +
                "Idade: " + p.getIdade() + "\n" +
                "Sintomas: " + p.getSintomas());
    }

    private void visualizarHistorico() {
        Paciente p = pacienteSelecionado();
        if (p == null) {
            area.setText("Nenhum paciente cadastrado.");
            return;
        }
        p.visualizarHistorico();
        area.setText("===== HISTÓRICO MÉDICO =====\n" + p.getHistoricoMedico());
    }

    private void executarAcao(String mensagem) {
        Paciente p = pacienteSelecionado();
        if (p == null) {
            area.setText("Nenhum paciente cadastrado.");
            return;
        }
        if (mensagem.contains("Consulta")) p.solicitarConsulta();
        if (mensagem.contains("Alerta")) p.emitirAlerta();
        if (mensagem.contains("Relatório")) p.gerarRelatorio();
        area.setText(mensagem + "\nPaciente: " + p.getNome());
    }
}
