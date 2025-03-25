package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public class MotocicletaRepository {
    private final List<Motocicleta> baseDeDatos = new ArrayList<>();

    public Motocicleta save(Motocicleta motocicleta) {
        baseDeDatos.add(motocicleta);
        return motocicleta;
    }

    public Motocicleta findById(String id) {
        for (Motocicleta motocicleta : baseDeDatos) {
            if (motocicleta.getId().equals(id)) {
                return motocicleta;
            }
        }
        return null;
    }

    public List<Motocicleta> findAll() {
        return new ArrayList<>(baseDeDatos);
    }

    public void deleteById(String id) {
        for (int i = 0; i < baseDeDatos.size(); i++) {
            if (baseDeDatos.get(i).getId().equals(id)) {
                baseDeDatos.remove(i);
                return;
            }
        }
    }

    public Motocicleta update(Motocicleta motocicleta) {
        for (int i = 0; i < baseDeDatos.size(); i++) {
            if (baseDeDatos.get(i).getId().equals(motocicleta.getId())) {
                baseDeDatos.set(i, motocicleta);
                return motocicleta;
            }
        }
        return null;
    }

    public List<Motocicleta> buscarPorFiltros(String placaMotocicleta, String cilindrajeMotocicleta) {
        List<Motocicleta> resultado = new ArrayList<>();
        for (Motocicleta motocicleta : baseDeDatos) {
            boolean coincidePlaca = (placaMotocicleta == null ||
                    motocicleta.getPlacaMotocicleta().contains(placaMotocicleta));
            boolean coincideCilindraje = (cilindrajeMotocicleta == null ||
                    motocicleta.getCilindrajeMotocicleta().contains(cilindrajeMotocicleta));
            if (coincidePlaca && coincideCilindraje) {
                resultado.add(motocicleta);
            }
        }
        return resultado;
    }


}