package dev.cesarzavaleta.pruebas_unitarias_s11.services.impl;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.HistorialMedico;
import dev.cesarzavaleta.pruebas_unitarias_s11.repository.HistorialMedicoRepository;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.HistorialMedicoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HistorialMedicoServiceImpl implements HistorialMedicoService {

    private final HistorialMedicoRepository historialMedicoRepository;

    public HistorialMedicoServiceImpl(HistorialMedicoRepository historialMedicoRepository) {
        this.historialMedicoRepository = historialMedicoRepository;
    }


    @Override
    public List<HistorialMedico> finAll() {
        return (List<HistorialMedico>) historialMedicoRepository.findAll();
    }

    @Override
    public HistorialMedico finById(Long id) {
        Optional<HistorialMedico> historialMedico = historialMedicoRepository.findById(id);
        return historialMedico.orElse(null);
    }

    @Override
    public HistorialMedico save(HistorialMedico historialMedico) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
