package view;

import app.Main;
import model.Paciente;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroPaciente extends JFrame {

    public TelaCadastroPaciente() {
        JTextField txtNome = new JTextField();
        JTextField txtCpf = new JTextField();
        JTextField txtTelefone = new JTextField();
        JTextField txtLogin = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        JTextField txtIdade = new JTextField();
        JTextField txtSintomas = new JTextField();
        JTextArea txtHistorico = new JTextArea(3, 20);

        JButton btnCadastrar = new JButton("Cadastrar");

        setTitle("Cadastro de Paciente");
        setSize(500, 460);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 2, 5, 5));

        add(new JLabel("Nome")); add(txtNome);
        add(new JLabel("CPF")); add(txtCpf);
        add(new JLabel("Telefone")); add(txtTelefone);
        add(new JLabel("Login")); add(txtLogin);
        add(new JLabel("Senha")); add(txtSenha);
        add(new JLabel("Idade")); add(txtIdade);
        add(new JLabel("Sintomas")); add(txtSintomas);
        add(new JLabel("Histórico médico")); add(new JScrollPane(txtHistorico));
        add(new JLabel()); add(btnCadastrar);

        btnCadastrar.addActionListener(e -> {
            try {
                Paciente paciente = new Paciente(
                        Main.usuarioService.quantidadeUsuarios() + 1,
                        txtNome.getText(),
                        txtCpf.getText(),
                        txtTelefone.getText(),
                        txtLogin.getText().isBlank() ? txtNome.getText() : txtLogin.getText(),
                        String.valueOf(txtSenha.getPassword()).isBlank() ? "123" : String.valueOf(txtSenha.getPassword()),
                        Integer.parseInt(txtIdade.getText()),
                        txtSintomas.getText(),
                        txtHistorico.getText()
                );

                Main.usuarioService.cadastrarUsuario(paciente);
                JOptionPane.showMessageDialog(null, "Paciente cadastrado!");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Informe uma idade válida.");
            }
        });

        setVisible(true);
    }
}
