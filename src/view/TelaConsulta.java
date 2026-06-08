package view;

import app.Main;
import model.Consulta;
import model.Medico;
import model.Paciente;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TelaConsulta extends JFrame {

    public TelaConsulta() {

        JComboBox<Paciente> cbPaciente =
                new JComboBox<>();

        JComboBox<Medico> cbMedico =
                new JComboBox<>();

        JFormattedTextField txtData =
                criarCampoData();

        JFormattedTextField txtHorario =
                criarCampoHorario();

        for (Paciente p :
                Main.usuarioService
                        .listarPacientes()) {

            cbPaciente.addItem(p);
        }

        for (Medico m :
                Main.usuarioService
                        .listarMedicos()) {

            cbMedico.addItem(m);
        }

        JButton btnAgendar =
                new JButton("Agendar");

        setTitle("Consulta");
        setSize(400,300);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5,2));

        add(new JLabel("Paciente"));
        add(cbPaciente);

        add(new JLabel("Médico"));
        add(cbMedico);

        add(new JLabel("Data"));
        add(txtData);

        add(new JLabel("Horário"));
        add(txtHorario);

        add(new JLabel());
        add(btnAgendar);

        btnAgendar.addActionListener(e -> {

            String data = txtData.getText();
            String horario = txtHorario.getText();

            if (!validarData(data)) {
                JOptionPane.showMessageDialog(
                        null,
                        "Digite uma data válida no formato dd/MM/aaaa."
                );
                return;
            }

            if (!validarHorario(horario)) {
                JOptionPane.showMessageDialog(
                        null,
                        "Digite um horário válido no formato HH:mm."
                );
                return;
            }

            Consulta consulta =
                    new Consulta(
                            Main.consultaService
                                    .quantidadeConsultas() + 1,

                            (Paciente)
                                    cbPaciente.getSelectedItem(),

                            (Medico)
                                    cbMedico.getSelectedItem(),

                            data,

                            horario
                    );

            Main.consultaService
                    .agendarConsulta(
                            consulta
                    );

            JOptionPane.showMessageDialog(
                    null,
                    "Consulta agendada!"
            );

            new TelaMenu();
            dispose();
        });

        setVisible(true);
    }

    private JFormattedTextField criarCampoData() {
        try {
            MaskFormatter mascaraData =
                    new MaskFormatter("##/##/####");

            mascaraData.setPlaceholderCharacter('_');

            return new JFormattedTextField(mascaraData);

        } catch (ParseException e) {
            e.printStackTrace();
            return new JFormattedTextField();
        }
    }

    private JFormattedTextField criarCampoHorario() {
        try {
            MaskFormatter mascaraHorario =
                    new MaskFormatter("##:##");

            mascaraHorario.setPlaceholderCharacter('_');

            return new JFormattedTextField(mascaraHorario);

        } catch (ParseException e) {
            e.printStackTrace();
            return new JFormattedTextField();
        }
    }

    private boolean validarData(String data) {
        try {
            DateTimeFormatter formato =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate.parse(data, formato);

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    private boolean validarHorario(String horario) {
        try {
            DateTimeFormatter formato =
                    DateTimeFormatter.ofPattern("HH:mm");

            LocalTime.parse(horario, formato);

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}