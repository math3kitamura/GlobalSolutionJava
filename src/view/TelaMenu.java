package view;

import javax.swing.*;
import java.awt.*;

public class TelaMenu extends JFrame {

    public TelaMenu() {
        setTitle("AstroLink Health");
        setSize(420, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 1, 8, 8));

        JButton btnPaciente = new JButton("Cadastrar Paciente");
        JButton btnListaPacientes = new JButton("Pacientes / Funções");
        JButton btnMedico = new JButton("Cadastrar Médico");
        JButton btnListaMedicos = new JButton("Médicos / Funções");
        JButton btnConsulta = new JButton("Agendar Consulta");
        JButton btnGerenciarConsultas = new JButton("Gerenciar Consultas");
        JButton btnMonitoramento = new JButton("Monitoramento");
        JButton btnRelatorioAlerta = new JButton("Relatórios e Alertas");
        JButton btnAdministrador = new JButton("Administrador / Sistema");

        add(btnPaciente);
        add(btnListaPacientes);
        add(btnMedico);
        add(btnListaMedicos);
        add(btnConsulta);
        add(btnGerenciarConsultas);
        add(btnMonitoramento);
        add(btnRelatorioAlerta);
        add(btnAdministrador);

        btnPaciente.addActionListener(e -> new TelaCadastroPaciente());
        btnListaPacientes.addActionListener(e -> new TelaListaPacientes());
        btnMedico.addActionListener(e -> new TelaCadastroMedico());
        btnListaMedicos.addActionListener(e -> new TelaListaMedicos());
        btnConsulta.addActionListener(e -> new TelaConsulta());
        btnGerenciarConsultas.addActionListener(e -> new TelaGerenciarConsultas());
        btnMonitoramento.addActionListener(e -> new TelaMonitoramento());
        btnRelatorioAlerta.addActionListener(e -> new TelaRelatorioAlerta());
        btnAdministrador.addActionListener(e -> new TelaAdministrador());

        setVisible(true);
    }
}
