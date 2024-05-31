package dev.cesarzavaleta.pruebas_unitarias_s11.repository;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cita; // Importación del modelo de datos 'Cita'
import org.springframework.data.repository.CrudRepository; // Importación de la interfaz CrudRepository de Spring Data

// Interfaz de repositorio para la entidad 'Cita'
// Extiende CrudRepository para proporcionar operaciones CRUD básicas
public interface CitaRepository extends CrudRepository<Cita, Long> {
}

