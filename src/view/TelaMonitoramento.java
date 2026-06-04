package view;

import app.Main;
import model.SensorSaude;

import javax.swing.*;
import java.awt.*;

public class TelaMonitoramento extends JFrame {

    private JTextField txtTemperatura;
    private JTextField txtPressao;
    private JTextField txtBatimentos;
    private JTextField txtOxigenacao;
    private JTextArea area;

    public TelaMonitoramento() {
        setTitle("Monitoramento");
        setSize(600, 430);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));

        JPanel campos = new JPanel(new GridLayout(4, 2, 5, 5));
        txtTemperatura = new JTextField("39.5");
        txtPressao = new JTextField("12");
        txtBatimentos = new JTextField("90");
        txtOxigenacao = new JTextField("88");

        campos.add(new JLabel("Temperatura")); campos.add(txtTemperatura);
        campos.add(new JLabel("Pressão")); campos.add(txtPressao);
        campos.add(new JLabel("Batimentos")); campos.add(txtBatimentos);
        campos.add(new JLabel("Oxigenação")); campos.add(txtOxigenacao);

        JPanel botoes = new JPanel(new GridLayout(1, 4, 5, 5));
        JButton btnAtualizar = new JButton("Capturar/Monitorar");
        JButton btnMostrar = new JButton("Mostrar Leitura");
        JButton btnAlerta = new JButton("Emitir Alerta");
        JButton btnRelatorio = new JButton("Gerar Relatório");
        botoes.add(btnAtualizar);
        botoes.add(btnMostrar);
        botoes.add(btnAlerta);
        botoes.add(btnRelatorio);

        area = new JTextArea();
        area.setEditable(false);

        add(campos, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        btnAtualizar.addActionListener(e -> monitorar());
        btnMostrar.addActionListener(e -> mostrarLeitura());
        btnAlerta.addActionListener(e -> emitirAlerta());
        btnRelatorio.addActionListener(e -> gerarRelatorio());

        setVisible(true);
    }

    private SensorSaude criarSensorDaTela() {
        return new SensorSaude(
                Double.parseDouble(txtTemperatura.getText()),
                Double.parseDouble(txtPressao.getText()),
                Integer.parseInt(txtBatimentos.getText()),
                Double.parseDouble(txtOxigenacao.getText())
        );
    }

    private void monitorar() {
        try {
            SensorSaude sensor = criarSensorDaTela();
            Main.monitoramentoService.monitorarPaciente(sensor);
            area.setText("Monitoramento realizado.\n" + sensor.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Preencha os sinais vitais com números válidos.");
        }
    }

    private void mostrarLeitura() {
        SensorSaude sensor = Main.monitoramentoService.ultimaLeitura();
        if (sensor == null) {
            area.setText("Nenhuma leitura registrada ainda.");
            return;
        }
        Main.monitoramentoService.mostrarDados(sensor);
        area.setText("===== SENSOR =====\n" + sensor.toString());
    }

    private void emitirAlerta() {
        SensorSaude sensor = Main.monitoramentoService.ultimaLeitura();
        if (sensor == null) {
            area.setText("Nenhuma leitura registrada ainda.");
            return;
        }
        sensor.emitirAlerta();
        area.setText("Alerta avaliado.\nNível de risco: " + sensor.analisarRisco());
    }

    private void gerarRelatorio() {
        SensorSaude sensor = Main.monitoramentoService.ultimaLeitura();
        if (sensor == null) {
            area.setText("Nenhuma leitura registrada ainda.");
            return;
        }
        Main.monitoramentoService.gerarRelatorioMonitoramento(sensor);
        area.setText("Relatório de monitoramento gerado.\n" + sensor.toString());
    }
}
