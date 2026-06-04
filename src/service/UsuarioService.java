package service;

import abstracts.Usuario;
import model.Administrador;
import model.Medico;
import model.Paciente;

import java.util.ArrayList;

public class UsuarioService {
    private ArrayList<Usuario> usuarios = new ArrayList();

    public UsuarioService() {
        this.usuarios.add(new Administrador(1, "Administrador", "00000000000", "11999999999", "admin", "123"));
    }

    public void cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public boolean autenticarUsuario(String login, String senha) {
        for(Usuario usuario : this.usuarios) {
            if (usuario.autenticar(login, senha)) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Usuario> listarUsuarios() {
        return this.usuarios;
    }

    public ArrayList<Paciente> listarPacientes() {
        ArrayList<Paciente> pacientes = new ArrayList();

        for(Usuario usuario : this.usuarios) {
            if (usuario instanceof Paciente) {
                pacientes.add((Paciente)usuario);
            }
        }

        return pacientes;
    }

    public ArrayList<Medico> listarMedicos() {
        ArrayList<Medico> medicos = new ArrayList();

        for(Usuario usuario : this.usuarios) {
            if (usuario instanceof Medico) {
                medicos.add((Medico)usuario);
            }
        }

        return medicos;
    }

    public ArrayList<Administrador> listarAdministradores() {
        ArrayList<Administrador> administradores = new ArrayList();

        for(Usuario usuario : this.usuarios) {
            if (usuario instanceof Administrador) {
                administradores.add((Administrador)usuario);
            }
        }

        return administradores;
    }

    public int quantidadeUsuarios() {
        return this.usuarios.size();
    }

    public Usuario buscarUsuarioPorId(int id) {
        for(Usuario usuario : this.usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }

        return null;
    }
}