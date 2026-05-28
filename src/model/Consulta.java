package model;

public class Consulta {

    private int idConsulta;
    private Paciente paciente;
    private Medico medico;
    private String data;
    private String horario;
    private String status;
    private String diagnostico;

    public Consulta(int idConsulta, Paciente paciente, Medico medico, String data, String horario) {

        this.idConsulta = idConsulta;
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
        this.horario = horario;
        this.status = "AGENDADA";
    }

    public void iniciarConsulta() {

        status = "EM ANDAMENTO";

        System.out.println("Consulta iniciada");
    }

    public void finalizarConsulta() {

        status = "FINALIZADA";

        System.out.println("Consulta finalizada");
    }

    public void cancelarConsulta() {

        status = "CANCELADA";

        System.out.println("Consulta cancelada");
    }

    public void exibirResumo() {

        System.out.println("===== CONSULTA =====");
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Médico: " + medico.getNome());
        System.out.println("Data: " + data);
        System.out.println("Horário: " + horario);
        System.out.println("Status: " + status);
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}