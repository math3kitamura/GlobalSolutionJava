package service;

import model.SensorSaude;

import java.util.ArrayList;

public class MonitoramentoService {

    private ArrayList<SensorSaude> leituras = new ArrayList();

    public void monitorarPaciente(SensorSaude sensor) {
        sensor.capturarDados();
        sensor.emitirAlerta();
        this.leituras.add(sensor);
    }

    public void mostrarDados(SensorSaude sensor) {
        sensor.mostrarLeitura();
    }

    public void gerarRelatorioMonitoramento(SensorSaude sensor) {
        if (sensor != null) {
            sensor.gerarRelatorio();
        }

    }

    public ArrayList<SensorSaude> listarLeituras() {
        return this.leituras;
    }

    public SensorSaude ultimaLeitura() {
        return this.leituras.isEmpty() ? null : (SensorSaude)this.leituras.get(this.leituras.size() - 1);
    }
}