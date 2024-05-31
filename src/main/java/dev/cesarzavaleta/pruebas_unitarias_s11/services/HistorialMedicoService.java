package dev.cesarzavaleta.pruebas_unitarias_s11.services;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.HistorialMedico; // Importa el modelo de datos 'HistorialMedico'
import java.util.List; // Importa la clase List para manejar listas

// Interfaz que define el contrato para el servicio de 'HistorialMedico'
public interface HistorialMedicoService {

    // Método para obtener todos los historiales médicos
    List<HistorialMedico> finAll();

    // Método para obtener un historial médico por su ID
    HistorialMedico finById(Long id);

    // Método para guardar un historial médico
    HistorialMedico save(HistorialMedico historialMedico);

    // Método para eliminar un historial médico por su ID
    void deleteById(Long id);
}
