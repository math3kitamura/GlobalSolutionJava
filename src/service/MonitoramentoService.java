package service;

import model.SensorSaude;

public class MonitoramentoService {

    public void monitorarPaciente(SensorSaude sensor) {

        sensor.capturarDados();

        sensor.emitirAlerta();
    }

    public void mostrarDados(SensorSaude sensor) {

        sensor.mostrarLeitura();
    }
}