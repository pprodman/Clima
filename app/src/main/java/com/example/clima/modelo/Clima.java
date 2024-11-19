package com.example.clima.modelo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Clima {

    private final MutableLiveData<String> climaLiveData = new MutableLiveData<>();

    // Constructor
    public Clima() {
        iniciarEmisionClima();
    }

    // Método para obtener el LiveData del clima
    public LiveData<String> getClimaLiveData() {
        return climaLiveData;
    }

    // Método para iniciar la emisión de estados del clima
    private void iniciarEmisionClima() {
        new Thread(() -> {
            String[] weatherStates = {"SOL", "NUBES", "VIENTO", "LLUVIA"};
            int index = 0;

            while (true) {
                try {
                    Thread.sleep(1000); // Emitir cada segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                climaLiveData.postValue(weatherStates[index]);
                index = (index + 1) % weatherStates.length; // Rotar entre los estados
            }
        }).start();
    }
}
