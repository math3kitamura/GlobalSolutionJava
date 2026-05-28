package model;

public class Alerta {

    private String mensagem;
    private String nivelRisco;
    private boolean ativo;

    public Alerta(String mensagem, String nivelRisco) {

        this.mensagem = mensagem;
        this.nivelRisco = nivelRisco;
        this.ativo = false;
    }

    public void ativarAlerta() {

        ativo = true;

        System.out.println("ALERTA ATIVADO");
    }

    public void desativarAlerta() {

        ativo = false;

        System.out.println("Alerta desativado");
    }

    public void mostrarAlerta() {

        System.out.println("===== ALERTA =====");
        System.out.println("Mensagem: " + mensagem);
        System.out.println("Nível de risco: " + nivelRisco);
        System.out.println("Ativo: " + ativo);
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNivelRisco() {
        return nivelRisco;
    }

    public void setNivelRisco(String nivelRisco) {
        this.nivelRisco = nivelRisco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}