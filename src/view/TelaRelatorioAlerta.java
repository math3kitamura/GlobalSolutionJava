package view;

import model.Alerta;
import model.Relatorio;

import javax.swing.*;
import java.awt.*;

public class TelaRelatorioAlerta extends JFrame {

    private JTextField txtMensagem;
    private JTextField txtNivel;
    private JTextField txtData;
    private JTextField txtResponsavel;
    private JTextArea txtConteudo;
    private JTextArea area;
    private Alerta alertaAtual;
    private Relatorio relatorioAtual;

    public TelaRelatorioAlerta() {
        setTitle("Relatórios e Alertas");
        setSize(700, 560);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));

        JPanel campos = new JPanel(new GridLayout(6, 2, 5, 5));
        txtMensagem = new JTextField("Paciente com sinais vitais alterados");
        txtNivel = new JTextField("ALTO");
        txtData = new JTextField("02/06/2026");
        txtResponsavel = new JTextField("Equipe de saúde");
        txtConteudo = new JTextArea("Conteúdo do relatório...");

        campos.add(new JLabel("Mensagem do alerta")); campos.add(txtMensagem);
        campos.add(new JLabel("Nível de risco")); campos.add(txtNivel);
        campos.add(new JLabel("Data do relatório")); campos.add(txtData);
        campos.add(new JLabel("Responsável")); campos.add(txtResponsavel);
        campos.add(new JLabel("Conteúdo")); campos.add(new JScrollPane(txtConteudo));

        JPanel botoes = new JPanel(new GridLayout(2, 3, 5, 5));
        JButton btnCriarAlerta = new JButton("Criar Alerta");
        JButton btnAtivar = new JButton("Ativar Alerta");
        JButton btnDesativar = new JButton("Desativar Alerta");
        JButton btnMostrar = new JButton("Mostrar Alerta");
        JButton btnRelatorio = new JButton("Gerar Relatório");
        JButton btnRelatorioTipo = new JButton("Gerar por Tipo");

        botoes.add(btnCriarAlerta);
        botoes.add(btnAtivar);
        botoes.add(btnDesativar);
        botoes.add(btnMostrar);
        botoes.add(btnRelatorio);
        botoes.add(btnRelatorioTipo);

        area = new JTextArea();
        area.setEditable(false);

        add(campos, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        btnCriarAlerta.addActionListener(e -> criarAlerta());
        btnAtivar.addActionListener(e -> ativarAlerta());
        btnDesativar.addActionListener(e -> desativarAlerta());
        btnMostrar.addActionListener(e -> mostrarAlerta());
        btnRelatorio.addActionListener(e -> gerarRelatorio());
        btnRelatorioTipo.addActionListener(e -> gerarRelatorioTipo());

        setVisible(true);
    }

    private void criarAlerta() {
        alertaAtual = new Alerta(txtMensagem.getText(), txtNivel.getText());
        area.setText("Alerta criado.\n" + montarAlerta());
    }

    private void ativarAlerta() {
        garantirAlerta();
        alertaAtual.ativarAlerta();
        area.setText("Alerta ativado.\n" + montarAlerta());
    }

    private void desativarAlerta() {
        garantirAlerta();
        alertaAtual.desativarAlerta();
        area.setText("Alerta desativado.\n" + montarAlerta());
    }

    private void mostrarAlerta() {
        garantirAlerta();
        alertaAtual.mostrarAlerta();
        area.setText(montarAlerta());
    }

    private void gerarRelatorio() {
        relatorioAtual = new Relatorio(txtData.getText(), txtConteudo.getText(), txtResponsavel.getText());
        relatorioAtual.gerarRelatorio();
        relatorioAtual.mostrarRelatorio();
        area.setText(montarRelatorio());
    }

    private void gerarRelatorioTipo() {
        String tipo = JOptionPane.showInputDialog(this, "Tipo de relatório:", "Monitoramento");
        if (tipo == null || tipo.isBlank()) return;
        relatorioAtual = new Relatorio(txtData.getText(), txtConteudo.getText(), txtResponsavel.getText());
        relatorioAtual.gerarRelatorio(tipo);
        area.setText("Relatório do tipo " + tipo + " gerado.\n\n" + montarRelatorio());
    }

    private void garantirAlerta() {
        if (alertaAtual == null) {
            alertaAtual = new Alerta(txtMensagem.getText(), txtNivel.getText());
        }
    }

    private String montarAlerta() {
        return "===== ALERTA =====\n" +
                "Mensagem: " + alertaAtual.getMensagem() + "\n" +
                "Nível de risco: " + alertaAtual.getNivelRisco() + "\n" +
                "Ativo: " + alertaAtual.isAtivo();
    }

    private String montarRelatorio() {
        return "===== RELATÓRIO =====\n" +
                "Data: " + relatorioAtual.getDataRelatorio() + "\n" +
                "Responsável: " + relatorioAtual.getResponsavel() + "\n" +
                "Conteúdo: " + relatorioAtual.getConteudo();
    }
}
