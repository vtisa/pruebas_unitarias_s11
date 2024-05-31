package dev.cesarzavaleta.pruebas_unitarias_s11.services.impl;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cita; // Importación del modelo de datos 'Cita'
import dev.cesarzavaleta.pruebas_unitarias_s11.repository.CitaRepository; // Importación del repositorio 'CitaRepository'
import dev.cesarzavaleta.pruebas_unitarias_s11.services.CitaService; // Importación del servicio 'CitaService'
import org.springframework.stereotype.Service; // Importación de la anotación @Service

import java.util.List; // Importación de la clase List para manejar listas de citas
import java.util.Optional; // Importación de la clase Optional para manejar valores opcionales

@Service // Anotación que indica que esta clase es un servicio de Spring
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository; // Repositorio para manejar operaciones CRUD de 'Cita'

    // Constructor que inyecta el repositorio 'CitaRepository' en el servicio
    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public List<Cita> finAll() {
        // Devuelve una lista de todas las citas
        return (List<Cita>) citaRepository.findAll();
    }

    @Override
    public Cita finById(Long id) {
        // Busca una cita por su ID y devuelve la cita si se encuentra, o null si no
        Optional<Cita> cita = citaRepository.findById(id);
        return cita.orElse(null);
    }

    @Override
    public Cita save(Cita cita) {
        // Guarda una nueva cita (implementación pendiente)
        return null;
    }

    @Override
    public void deleteById(Long id) {
        // Elimina una cita por su ID (implementación pendiente)
    }
}
