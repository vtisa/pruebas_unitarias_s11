package dev.cesarzavaleta.pruebas_unitarias_s11.model;

import jakarta.persistence.*; // Importación de anotaciones para mapeo de entidades JPA
import lombok.Getter; // Importación de la anotación @Getter de Lombok para generar métodos getters
import lombok.Setter; // Importación de la anotación @Setter de Lombok para generar métodos setters
import lombok.AllArgsConstructor; // Importación de la anotación @AllArgsConstructor de Lombok para generar un constructor con todos los argumentos
import lombok.NoArgsConstructor; // Importación de la anotación @NoArgsConstructor de Lombok para generar un constructor sin argumentos
import java.io.Serializable; // Importación de la interfaz Serializable para que la entidad pueda ser serializada
import java.sql.Timestamp; // Importación de la clase Timestamp para manejar fechas y horas

@Getter // Genera métodos getters para todos los campos
@Setter // Genera métodos setters para todos los campos
@AllArgsConstructor // Genera un constructor con todos los argumentos
@NoArgsConstructor // Genera un constructor sin argumentos
@Entity // Indica que esta clase es una entidad JPA
@Table(name = "citas") // Especifica el nombre de la tabla en la base de datos a la que se mapea esta entidad
public class Cita implements Serializable {

    @Id // Indica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que el valor de la clave primaria se genera automáticamente
    @Column(name = "id_cita") // Mapea este campo a la columna 'id_cita' en la tabla
    private int idCita;

    @Column(name = "fecha_hora", nullable = false) // Mapea este campo a la columna 'fecha_hora' en la tabla y establece que no puede ser nulo
    private Timestamp fechaHora;

    @Column(name = "motivo_consulta", nullable = false, length = 255) // Mapea este campo a la columna 'motivo_consulta' en la tabla, establece que no puede ser nulo y limita su longitud a 255 caracteres
    private String motivoConsulta;

    @Column(name = "id_mascota", nullable = false) // Mapea este campo a la columna 'id_mascota' en la tabla y establece que no puede ser nulo
    private int idMascota;
}
