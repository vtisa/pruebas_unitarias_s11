package dev.cesarzavaleta.pruebas_unitarias_s11.services;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota; // Importa el modelo de datos 'Mascota'
import java.util.List; // Importa la clase List para manejar listas

// Interfaz que define el contrato para el servicio de 'Mascota'
public interface MascotaService {

    // Método para obtener todas las mascotas
    List<Mascota> finAll();

    // Método para obtener una mascota por su ID
    Mascota finById(Long id);

    // Método para guardar una mascota
    Mascota save(Mascota mascota);

    // Método para eliminar una mascota por su ID
    void deleteById(Long id);
}
