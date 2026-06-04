package view;

import app.Main;
import model.Medico;

import javax.swing.*;
import java.awt.*;

public class TelaListaMedicos extends JFrame {

    private JComboBox<Medico> cbMedicos;
    private JTextArea area;

    public TelaListaMedicos() {
        setTitle("Médicos / Funções");
        setSize(600, 380);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));

        cbMedicos = new JComboBox<>();
        carregarMedicos();
        area = new JTextArea();
        area.setEditable(false);

        JPanel topo = new JPanel(new BorderLayout());
        topo.add(new JLabel("Médico:"), BorderLayout.WEST);
        topo.add(cbMedicos, BorderLayout.CENTER);

        JPanel botoes = new JPanel(new GridLayout(1, 5, 5, 5));
        JButton btnExibir = new JButton("Exibir Dados");
        JButton btnConsulta = new JButton("Realizar Consulta");
        JButton btnDiagnostico = new JButton("Emitir Diagnóstico");
        JButton btnNotificacao = new JButton("Enviar Notificação");
        JButton btnAtualizar = new JButton("Atualizar");

        botoes.add(btnExibir);
        botoes.add(btnConsulta);
        botoes.add(btnDiagnostico);
        botoes.add(btnNotificacao);
        botoes.add(btnAtualizar);

        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        btnExibir.addActionListener(e -> exibirDados());
        btnConsulta.addActionListener(e -> executarAcao("Consulta realizada."));
        btnDiagnostico.addActionListener(e -> executarAcao("Diagnóstico emitido."));
        btnNotificacao.addActionListener(e -> executarAcao("Notificação enviada ao paciente."));
        btnAtualizar.addActionListener(e -> carregarMedicos());

        setVisible(true);
    }

    private void carregarMedicos() {
        if (cbMedicos == null) return;
        cbMedicos.removeAllItems();
        for (Medico medico : Main.usuarioService.listarMedicos()) {
            cbMedicos.addItem(medico);
        }
    }

    private Medico medicoSelecionado() {
        return (Medico) cbMedicos.getSelectedItem();
    }

    private void exibirDados() {
        Medico m = medicoSelecionado();
        if (m == null) {
            area.setText("Nenhum médico cadastrado.");
            return;
        }
        m.exibirDados();
        area.setText("===== MÉDICO =====\n" +
                "ID: " + m.getId() + "\n" +
                "Nome: " + m.getNome() + "\n" +
                "CPF: " + m.getCpf() + "\n" +
                "Telefone: " + m.getTelefone() + "\n" +
                "CRM: " + m.getCrm() + "\n" +
                "Especialidade: " + m.getEspecialidade());
    }

    private void executarAcao(String mensagem) {
        Medico m = medicoSelecionado();
        if (m == null) {
            area.setText("Nenhum médico cadastrado.");
            return;
        }
        if (mensagem.contains("Consulta")) m.realizarConsulta();
        if (mensagem.contains("Diagnóstico")) m.emitirDiagnostico();
        if (mensagem.contains("Notificação")) m.enviarNotificacao();
        area.setText(mensagem + "\nMédico: " + m.getNome());
    }
}
