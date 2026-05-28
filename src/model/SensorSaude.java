package model;

import interfaces.Monitoravel;

public class SensorSaude implements Monitoravel {

    private double temperatura;
    private double pressao;
    private int batimentos;
    private double oxigenacao;

    public SensorSaude(double temperatura,
                       double pressao,
                       int batimentos,
                       double oxigenacao) {

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
        System.out.println("Temperatura: " + temperatura);
        System.out.println("Pressão: " + pressao);
        System.out.println("Batimentos: " + batimentos);
        System.out.println("Oxigenação: " + oxigenacao);
    }

    @Override
    public void emitirAlerta() {

        if (temperatura > 39) {

            System.out.println("ALERTA: Temperatura elevada");
        }

        if (oxigenacao < 90) {

            System.out.println("ALERTA: Oxigenação baixa");
        }
    }

    @Override
    public void gerarRelatorio() {

        System.out.println("Relatório de monitoramento gerado");
    }


    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getPressao() {
        return pressao;
    }

    public void setPressao(double pressao) {
        this.pressao = pressao;
    }

    public int getBatimentos() {
        return batimentos;
    }

    public void setBatimentos(int batimentos) {
        this.batimentos = batimentos;
    }

    public double getOxigenacao() {
        return oxigenacao;
    }

    public void setOxigenacao(double oxigenacao) {
        this.oxigenacao = oxigenacao;
    }
}