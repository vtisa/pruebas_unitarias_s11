package dev.cesarzavaleta.pruebas_unitarias_s11.services;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cita; // Importación del modelo de datos 'Cita'
import java.util.List; // Importación de la clase List para manejar listas de citas

// Interfaz que define los métodos que debe implementar un servicio de citas
public interface CitaService {

    // Método para obtener todas las citas
    List<Cita> finAll();

    // Método para obtener una cita por su ID
    Cita finById(Long id);

    // Método para guardar una cita
    Cita save(Cita cita);

    // Método para eliminar una cita por su ID
    void deleteById(Long id);
}
