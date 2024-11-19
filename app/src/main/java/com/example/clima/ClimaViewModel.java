package com.example.clima;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.clima.modelo.Clima;

public class ClimaViewModel extends AndroidViewModel {

    private final LiveData<Integer> climaImageLiveData;
    private final LiveData<String> climaTextoLiveData;

    public ClimaViewModel(@NonNull Application application) {
        super(application);

        // Inicializar el modelo
        Clima clima = new Clima();

        // Mapear la imagen según el clima
        climaImageLiveData = Transformations.map(clima.getClimaLiveData(), climaStatus -> {
            switch (climaStatus) {
                case "SOL":
                    return R.drawable.sol;
                case "NUBES":
                    return R.drawable.nubes;
                case "VIENTO":
                    return R.drawable.viento;
                case "LLUVIA":
                    return R.drawable.lluvia;
                default:
                    return R.drawable.sol; // Imagen por defecto
            }
        });

        // Devolver el texto del clima directamente
        climaTextoLiveData = clima.getClimaLiveData();
    }

    public LiveData<Integer> obtenerClimaImg() {
        return climaImageLiveData;
    }

    public LiveData<String> obtenerClimaTexto() {
        return climaTextoLiveData;
    }
}
