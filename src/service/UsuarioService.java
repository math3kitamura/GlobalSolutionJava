package service;

import model.Paciente;
import model.Medico;
import model.Administrador;

import java.util.ArrayList;

public class UsuarioService {

    private ArrayList<Object> usuarios =
            new ArrayList<>();

    public void cadastrarUsuario(Object usuario) {

        usuarios.add(usuario);

        System.out.println("Usuário cadastrado");
    }

    public void listarUsuarios() {

        for (Object usuario : usuarios) {

            System.out.println(usuario);
        }
    }

    public boolean autenticarUsuario(String login,
                                     String senha) {

        System.out.println("Validando login...");

        return true;
    }
}