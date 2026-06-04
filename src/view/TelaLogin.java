package view;

import app.Main;

import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JFrame {

    private JTextField txtLogin;
    private JPasswordField txtSenha;

    private JButton btnEntrar;

    public TelaLogin() {

        setTitle("Login");
        setSize(350,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,2));

        txtLogin = new JTextField();
        txtSenha = new JPasswordField();

        btnEntrar = new JButton("Entrar");

        add(new JLabel("Login"));
        add(txtLogin);

        add(new JLabel("Senha"));
        add(txtSenha);

        add(new JLabel());
        add(btnEntrar);

        btnEntrar.addActionListener(e -> {

            String login = txtLogin.getText();

            String senha =
                    String.valueOf(
                            txtSenha.getPassword()
                    );

            boolean autenticado =
                    Main.usuarioService
                            .autenticarUsuario(
                                    login,
                                    senha
                            );

            if (autenticado) {

                new TelaMenu();

                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Login inválido"
                );
            }
        });

        setVisible(true);
    }
}
