package app;

import service.ConsultaService;
import service.MonitoramentoService;
import service.UsuarioService;
import view.TelaLogin;

public class Main {
    public static UsuarioService usuarioService;
    public static ConsultaService consultaService;
    public static MonitoramentoService monitoramentoService;

    public static void main(String[] args) {
        usuarioService = new UsuarioService();
        consultaService = new ConsultaService();
        monitoramentoService = new MonitoramentoService();
        new TelaLogin();
    }
}