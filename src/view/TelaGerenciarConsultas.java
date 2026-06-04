package view;

import app.Main;
import model.Consulta;

import javax.swing.*;
import java.awt.*;

public class TelaGerenciarConsultas extends JFrame {

    private JComboBox<Consulta> cbConsultas;
    private JTextArea area;

    public TelaGerenciarConsultas() {
        setTitle("Gerenciar Consultas");
        setSize(700, 430);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));

        cbConsultas = new JComboBox<>();
        carregarConsultas();
        area = new JTextArea();
        area.setEditable(false);

        JPanel topo = new JPanel(new BorderLayout());
        topo.add(new JLabel("Consulta:"), BorderLayout.WEST);
        topo.add(cbConsultas, BorderLayout.CENTER);

        JPanel botoes = new JPanel(new GridLayout(2, 3, 5, 5));
        JButton btnResumo = new JButton("Exibir Resumo");
        JButton btnIniciar = new JButton("Iniciar");
        JButton btnFinalizar = new JButton("Finalizar");
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnDiagnostico = new JButton("Registrar Diagnóstico");
        JButton btnAtualizar = new JButton("Atualizar Lista");

        botoes.add(btnResumo);
        botoes.add(btnIniciar);
        botoes.add(btnFinalizar);
        botoes.add(btnCancelar);
        botoes.add(btnDiagnostico);
        botoes.add(btnAtualizar);

        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        btnResumo.addActionListener(e -> exibirResumo());
        btnIniciar.addActionListener(e -> alterarStatus("iniciar"));
        btnFinalizar.addActionListener(e -> alterarStatus("finalizar"));
        btnCancelar.addActionListener(e -> alterarStatus("cancelar"));
        btnDiagnostico.addActionListener(e -> registrarDiagnostico());
        btnAtualizar.addActionListener(e -> carregarConsultas());

        setVisible(true);
    }

    private void carregarConsultas() {
        if (cbConsultas == null) return;
        cbConsultas.removeAllItems();
        for (Consulta consulta : Main.consultaService.getConsultas()) {
            cbConsultas.addItem(consulta);
        }
    }

    private Consulta consultaSelecionada() {
        return (Consulta) cbConsultas.getSelectedItem();
    }

    private void exibirResumo() {
        Consulta c = consultaSelecionada();
        if (c == null) {
            area.setText("Nenhuma consulta cadastrada.");
            return;
        }
        c.exibirResumo();
        area.setText(montarResumo(c));
    }

    private void alterarStatus(String acao) {
        Consulta c = consultaSelecionada();
        if (c == null) {
            area.setText("Nenhuma consulta cadastrada.");
            return;
        }
        switch (acao) {
            case "iniciar": Main.consultaService.iniciarConsulta(c); break;
            case "finalizar": Main.consultaService.finalizarConsulta(c); break;
            case "cancelar": Main.consultaService.cancelarConsulta(c); break;
        }
        area.setText(montarResumo(c));
        carregarConsultas();
    }

    private void registrarDiagnostico() {
        Consulta c = consultaSelecionada();
        if (c == null) {
            area.setText("Nenhuma consulta cadastrada.");
            return;
        }
        String diagnostico = JOptionPane.showInputDialog(this, "Informe o diagnóstico:");
        if (diagnostico != null && !diagnostico.isBlank()) {
            Main.consultaService.emitirDiagnostico(c, diagnostico);
            c.getMedico().emitirDiagnostico();
        }
        area.setText(montarResumo(c));
    }

    private String montarResumo(Consulta c) {
        return "===== CONSULTA =====\n" +
                "ID: " + c.getIdConsulta() + "\n" +
                "Paciente: " + c.getPaciente().getNome() + "\n" +
                "Médico: " + c.getMedico().getNome() + "\n" +
                "Data: " + c.getData() + "\n" +
                "Horário: " + c.getHorario() + "\n" +
                "Status: " + c.getStatus() + "\n" +
                "Diagnóstico: " + c.getDiagnostico();
    }
}
