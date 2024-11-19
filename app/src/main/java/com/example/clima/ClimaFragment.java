package com.example.clima;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.clima.databinding.FragmentClimaBinding;

public class ClimaFragment extends Fragment {

    private FragmentClimaBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentClimaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Instanciar el ViewModel
        ClimaViewModel climaViewModel = new ViewModelProvider(this).get(ClimaViewModel.class);

        // Observación del texto del clima
        climaViewModel.obtenerClimaTexto().observe(getViewLifecycleOwner(), climaTexto -> {
            binding.climaTexto.setText(climaTexto); // Actualizar el texto
        });

        // Observación de la imagen del clima
        climaViewModel.obtenerClimaImg().observe(getViewLifecycleOwner(), climaImg -> {
            binding.climaImagen.setImageResource(climaImg); // Actualizar la imagen
        });
    }
}
