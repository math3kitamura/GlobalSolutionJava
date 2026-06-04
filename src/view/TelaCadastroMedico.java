package view;

import app.Main;
import model.Medico;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroMedico extends JFrame {

    public TelaCadastroMedico() {
        JTextField txtNome = new JTextField();
        JTextField txtCpf = new JTextField();
        JTextField txtTelefone = new JTextField();
        JTextField txtLogin = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        JTextField txtCRM = new JTextField();
        JTextField txtEspecialidade = new JTextField();

        JButton btnCadastrar = new JButton("Cadastrar");

        setTitle("Cadastro de Médico");
        setSize(500, 380);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 5, 5));

        add(new JLabel("Nome")); add(txtNome);
        add(new JLabel("CPF")); add(txtCpf);
        add(new JLabel("Telefone")); add(txtTelefone);
        add(new JLabel("Login")); add(txtLogin);
        add(new JLabel("Senha")); add(txtSenha);
        add(new JLabel("CRM")); add(txtCRM);
        add(new JLabel("Especialidade")); add(txtEspecialidade);
        add(new JLabel()); add(btnCadastrar);

        btnCadastrar.addActionListener(e -> {
            Medico medico = new Medico(
                    Main.usuarioService.quantidadeUsuarios() + 1,
                    txtNome.getText(),
                    txtCpf.getText(),
                    txtTelefone.getText(),
                    txtLogin.getText().isBlank() ? txtNome.getText() : txtLogin.getText(),
                    String.valueOf(txtSenha.getPassword()).isBlank() ? "123" : String.valueOf(txtSenha.getPassword()),
                    txtCRM.getText(),
                    txtEspecialidade.getText()
            );

            Main.usuarioService.cadastrarUsuario(medico);
            JOptionPane.showMessageDialog(null, "Médico cadastrado!");
            dispose();
        });

        setVisible(true);
    }
}
