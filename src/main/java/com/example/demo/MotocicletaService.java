package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
    public class MotocicletaService {

        private final MotocicletaRepository motocicletaRepository;
        @Autowired
        public MotocicletaService(MotocicletaRepository motocicletaRepository) {
            this.motocicletaRepository = motocicletaRepository;
            initSampleData();
        }
        private void initSampleData() {
           Motocicleta moto1 = new Motocicleta("100cc", "NKD", "xts98g", "Rojo", 1000);
           Motocicleta moto2 = new Motocicleta("200cc", "Bajaj", "tsd98g", "Verde", 4000);
           Motocicleta moto3 = new Motocicleta("250cc", "Hero", "kdt60g", "Azul", 7000);
            save(moto1);
            save(moto2);
            save(moto3);


        }
        public Motocicleta save(Motocicleta motocicleta) {
            return motocicletaRepository.save(motocicleta);
        }
        public Motocicleta findById(String id) {
            return motocicletaRepository.findById(id);
        }
        public List<Motocicleta> findAll() {
            return motocicletaRepository.findAll();
        }
        public Motocicleta update(Motocicleta motocicleta) {
            return motocicletaRepository.update(motocicleta);
        }
        public void deleteById(String id) {
            motocicletaRepository.deleteById(id);
        }
        public List<Motocicleta> buscarPorFiltros(String placaMotocicleta, String cilindrajeMotocicleta) {
            return motocicletaRepository.buscarPorFiltros(placaMotocicleta, cilindrajeMotocicleta);
        }
    }

