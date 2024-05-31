package dev.cesarzavaleta.pruebas_unitarias_s11.services.impl;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota;
import dev.cesarzavaleta.pruebas_unitarias_s11.repository.MascotaRepository;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.MascotaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service // Anotación que indica que esta clase es un servicio de Spring
public class MascotaServiceImpl implements MascotaService {

    // Repositorio de Mascota para acceder a la base de datos
    private final MascotaRepository mascotaRepository;

    // Constructor para inyectar el repositorio de Mascota
    public MascotaServiceImpl(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    // Método para obtener todas las mascotas
    @Override
    public List<Mascota> finAll() {
        return (List<Mascota>) mascotaRepository.findAll();
    }

    // Método para obtener una mascota por su ID
    @Override
    public Mascota finById(Long id) {
        Optional<Mascota> mascota = mascotaRepository.findById(id);
        // Si la mascota está presente, se retorna, de lo contrario, se retorna null
        return mascota.orElse(null);
    }

    // Método para guardar una nueva mascota o actualizar una existente
    @Override
    public Mascota save(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    // Método para eliminar una mascota por su ID
    @Override
    @Transactional // Anotación para manejar la transacción de manera automática
    public void deleteById(Long id) {
        mascotaRepository.deleteById(id);
    }
}