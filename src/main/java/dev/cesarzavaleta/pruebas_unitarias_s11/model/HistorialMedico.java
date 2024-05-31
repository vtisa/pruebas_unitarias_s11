package dev.cesarzavaleta.pruebas_unitarias_s11.model;

import jakarta.persistence.*; // Importa las anotaciones de Java Persistence API (JPA)
import lombok.Getter; // Importa la anotación Getter de Lombok
import lombok.Setter; // Importa la anotación Setter de Lombok
import lombok.AllArgsConstructor; // Importa la anotación AllArgsConstructor de Lombok
import lombok.NoArgsConstructor; // Importa la anotación NoArgsConstructor de Lombok

import java.io.Serializable; // Importa la interfaz Serializable

@Getter
@Setter
@AllArgsConstructor // Genera un constructor con todos los argumentos
@NoArgsConstructor // Genera un constructor sin argumentos
@Entity // Marca esta clase como una entidad JPA
@Table(name = "historial_medico")


public class HistorialMedico implements Serializable {

    @Id // Marca este campo como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica la estrategia de generación de valores para la clave primaria
    @Column(name = "id_historial") // Especifica el nombre de la columna en la base de datos
    private int idHistorial; // ID del historial médico

    @Column(name = "id_cita", nullable = false) // Especifica el nombre y restricciones de la columna en la base de datos
    private int idCita; // ID de la cita asociada al historial médico

    @Column(nullable = false, length = 255) // Especifica restricciones de la columna en la base de datos
    private String diagnostico; // Diagnóstico del historial médico

    @Column(nullable = false, length = 255) // Especifica restricciones de la columna en la base de datos
    private String tratamiento; // Tratamiento del historial médico

    @Column(length = 255) // Especifica restricciones de la columna en la base de datos
    private String observaciones; // Observaciones adicionales del historial médico
}
