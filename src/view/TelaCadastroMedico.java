package view;

import app.Main;
import model.Medico;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;

public class TelaCadastroMedico extends JFrame {

    public TelaCadastroMedico() {
        JTextField txtNome = new JTextField();

        JFormattedTextField txtCpf = criarCampoCPF();
        JFormattedTextField txtTelefone = criarCampoTelefone();

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

            if (txtNome.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Informe o nome do médico.");
                return;
            }

            if (!validarCPF(txtCpf.getText())) {
                JOptionPane.showMessageDialog(null, "CPF inválido.");
                return;
            }

            if (!validarTelefone(txtTelefone.getText())) {
                JOptionPane.showMessageDialog(null, "Telefone inválido. Use o formato (00) 00000-0000.");
                return;
            }

            if (txtCRM.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Informe o CRM do médico.");
                return;
            }

            if (txtEspecialidade.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Informe a especialidade do médico.");
                return;
            }

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

    private JFormattedTextField criarCampoCPF() {
        try {
            MaskFormatter mascaraCPF = new MaskFormatter("###.###.###-##");
            mascaraCPF.setPlaceholderCharacter('_');

            return new JFormattedTextField(mascaraCPF);

        } catch (Exception e) {
            e.printStackTrace();
            return new JFormattedTextField();
        }
    }

    private JFormattedTextField criarCampoTelefone() {
        try {
            MaskFormatter mascaraTelefone = new MaskFormatter("(##) #####-####");
            mascaraTelefone.setPlaceholderCharacter('_');

            return new JFormattedTextField(mascaraTelefone);

        } catch (Exception e) {
            e.printStackTrace();
            return new JFormattedTextField();
        }
    }

    private boolean validarTelefone(String telefone) {
        String apenasNumeros = telefone.replaceAll("[^0-9]", "");

        return apenasNumeros.length() == 11;
    }

    private boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.equals("00000000000") ||
                cpf.equals("11111111111") ||
                cpf.equals("22222222222") ||
                cpf.equals("33333333333") ||
                cpf.equals("44444444444") ||
                cpf.equals("55555555555") ||
                cpf.equals("66666666666") ||
                cpf.equals("77777777777") ||
                cpf.equals("88888888888") ||
                cpf.equals("99999999999")) {
            return false;
        }
        return true;
    }
}