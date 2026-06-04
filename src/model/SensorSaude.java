package model;

import interfaces.Monitoravel;

public class SensorSaude implements Monitoravel {
    private double temperatura;
    private double pressao;
    private int batimentos;
    private double oxigenacao;

    public SensorSaude(double temperatura, double pressao, int batimentos, double oxigenacao) {
        this.temperatura = temperatura;
        this.pressao = pressao;
        this.batimentos = batimentos;
        this.oxigenacao = oxigenacao;
    }

    public void capturarDados() {
        System.out.println("Capturando dados do paciente...");
    }

    public void mostrarLeitura() {
        System.out.println("===== SENSOR =====");
        System.out.println("Temperatura: " + this.temperatura);
        System.out.println("Pressão: " + this.pressao);
        System.out.println("Batimentos: " + this.batimentos);
        System.out.println("Oxigenação: " + this.oxigenacao);
    }

    public String analisarRisco() {
        if (!(this.temperatura > (double)39.0F) && !(this.oxigenacao < (double)90.0F) && this.batimentos <= 120) {
            return !(this.temperatura >= 37.8) && !(this.oxigenacao < (double)94.0F) && this.batimentos <= 100 ? "BAIXO" : "MODERADO";
        } else {
            return "ALTO";
        }
    }

    public void emitirAlerta() {
        if (this.temperatura > (double)39.0F) {
            System.out.println("ALERTA: Temperatura elevada");
        }

        if (this.oxigenacao < (double)90.0F) {
            System.out.println("ALERTA: Oxigenação baixa");
        }

        if (this.batimentos > 120) {
            System.out.println("ALERTA: Batimentos elevados");
        }

    }

    public void gerarRelatorio() {
        System.out.println("Relatório de monitoramento gerado");
    }

    public String toString() {
        double var10000 = this.temperatura;
        return "Temp: " + var10000 + "ºC | PA: " + this.pressao + " | FC: " + this.batimentos + " bpm | SpO2: " + this.oxigenacao + "% | Risco: " + this.analisarRisco();
    }

    public double getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getPressao() {
        return this.pressao;
    }

    public void setPressao(double pressao) {
        this.pressao = pressao;
    }

    public int getBatimentos() {
        return this.batimentos;
    }

    public void setBatimentos(int batimentos) {
        this.batimentos = batimentos;
    }

    public double getOxigenacao() {
        return this.oxigenacao;
    }

    public void setOxigenacao(double oxigenacao) {
        this.oxigenacao = oxigenacao;
    }
}