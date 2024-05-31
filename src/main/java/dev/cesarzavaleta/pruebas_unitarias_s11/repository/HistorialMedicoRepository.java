package dev.cesarzavaleta.pruebas_unitarias_s11.repository;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.HistorialMedico; // Importa el modelo de datos 'HistorialMedico'
import org.springframework.data.repository.CrudRepository; // Importa la interfaz CrudRepository de Spring Data
import org.springframework.stereotype.Repository; // Importa la anotación Repository de Spring

// Anotación que marca esta interfaz como un componente de Spring para la gestión de repositorios
@Repository
// Interfaz que extiende CrudRepository para proporcionar operaciones CRUD para la entidad 'HistorialMedico'
public interface HistorialMedicoRepository extends CrudRepository<HistorialMedico, Long> {
    // Esta interfaz hereda métodos como save(), findById(), findAll(), deleteById(), entre otros
    // para la entidad 'HistorialMedico' con ID de tipo Long
}
