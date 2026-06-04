package view;

import app.Main;
import model.Consulta;
import model.Medico;
import model.Paciente;

import javax.swing.*;
import java.awt.*;

public class TelaConsulta extends JFrame {

    public TelaConsulta() {

        JComboBox<Paciente> cbPaciente =
                new JComboBox<>();

        JComboBox<Medico> cbMedico =
                new JComboBox<>();

        JTextField txtData =
                new JTextField();

        JTextField txtHorario =
                new JTextField();

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

            Consulta consulta =
                    new Consulta(
                            Main.consultaService
                                    .quantidadeConsultas() + 1,

                            (Paciente)
                                    cbPaciente.getSelectedItem(),

                            (Medico)
                                    cbMedico.getSelectedItem(),

                            txtData.getText(),

                            txtHorario.getText()
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
}
