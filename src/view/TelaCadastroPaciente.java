package view;

import app.Main;
import model.Paciente;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;

public class TelaCadastroPaciente extends JFrame {

    public TelaCadastroPaciente() {
        JTextField txtNome = new JTextField();

        JFormattedTextField txtCpf = criarCampoCPF();
        JFormattedTextField txtTelefone = criarCampoTelefone();

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

                if (txtNome.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Informe o nome do paciente.");
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

                int idade = Integer.parseInt(txtIdade.getText());

                if (idade <= 0) {
                    JOptionPane.showMessageDialog(null, "A idade deve ser maior que zero.");
                    return;
                }

                Paciente paciente = new Paciente(
                        Main.usuarioService.quantidadeUsuarios() + 1,
                        txtNome.getText(),
                        txtCpf.getText(),
                        txtTelefone.getText(),
                        txtLogin.getText().isBlank() ? txtNome.getText() : txtLogin.getText(),
                        String.valueOf(txtSenha.getPassword()).isBlank() ? "123" : String.valueOf(txtSenha.getPassword()),
                        idade,
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

        int soma = 0;

        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }

        int primeiroDigito = 11 - (soma % 11);

        if (primeiroDigito >= 10) {
            primeiroDigito = 0;
        }

        if (primeiroDigito != Character.getNumericValue(cpf.charAt(9))) {
            return false;
        }

        soma = 0;

        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }

        int segundoDigito = 11 - (soma % 11);

        if (segundoDigito >= 10) {
            segundoDigito = 0;
        }

        return segundoDigito == Character.getNumericValue(cpf.charAt(10));
    }
}