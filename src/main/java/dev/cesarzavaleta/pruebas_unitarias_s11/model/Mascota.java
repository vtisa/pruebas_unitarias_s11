package dev.cesarzavaleta.pruebas_unitarias_s11.model;

import com.fasterxml.jackson.annotation.JsonFormat; // Importa la anotación JsonFormat de Jackson para el formateo de fechas
import com.fasterxml.jackson.databind.annotation.JsonDeserialize; // Importa la anotación JsonDeserialize de Jackson para deserialización personalizada
import com.fasterxml.jackson.databind.annotation.JsonSerialize; // Importa la anotación JsonSerialize de Jackson para serialización personalizada
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer; // Importa la clase LocalDateDeserializer de Jackson para deserialización de LocalDate
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer; // Importa la clase LocalDateSerializer de Jackson para serialización de LocalDate
import jakarta.persistence.*; // Importa las anotaciones de Java Persistence API (JPA)
import lombok.AllArgsConstructor; // Importa la anotación AllArgsConstructor de Lombok para generar un constructor con todos los argumentos
import lombok.Getter; // Importa la anotación Getter de Lombok para generar automáticamente los métodos getters
import lombok.NoArgsConstructor; // Importa la anotación NoArgsConstructor de Lombok para generar un constructor sin argumentos
import lombok.Setter; // Importa la anotación Setter de Lombok para generar automáticamente los métodos setters
import java.io.Serializable; // Importa la interfaz Serializable
import java.time.LocalDate; // Importa la clase LocalDate de Java Time

@Getter // Genera automáticamente los métodos getters para todos los campos
@Setter // Genera automáticamente los métodos setters para todos los campos
@AllArgsConstructor // Genera un constructor con todos los argumentos
@NoArgsConstructor // Genera un constructor sin argumentos
@Entity // Marca esta clase como una entidad JPA
@Table(name="mascotas") // Especifica el nombre de la tabla en la base de datos

// Clase que representa a una mascota
public class Mascota implements Serializable {

    @Id // Marca este campo como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica la estrategia de generación de valores para la clave primaria
    private Long idMascota; // ID de la mascota

    @Column(nullable = false, length = 255) // Especifica restricciones de la columna en la base de datos
    private String nombre; // Nombre de la mascota

    @Column(nullable = false, length = 50) // Especifica restricciones de la columna en la base de datos
    private String especie; // Especie de la mascota

    @Column(length = 50) // Especifica restricciones de la columna en la base de datos
    private String raza; // Raza de la mascota

    @Column(length = 10) // Especifica restricciones de la columna en la base de datos
    private String sexo; // Sexo de la mascota

    @Column(name = "fecha_nacimiento") // Especifica el nombre de la columna en la base de datos
    @JsonDeserialize(using = LocalDateDeserializer.class) // Deserializa la fecha de nacimiento utilizando LocalDateDeserializer
    @JsonSerialize(using = LocalDateSerializer.class) // Serializa la fecha de nacimiento utilizando LocalDateSerializer
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Especifica el formato de fecha para la serialización
    private LocalDate fechaNacimiento; // Fecha de nacimiento de la mascota

    @ManyToOne(fetch = FetchType.LAZY) // Establece la relación de muchos a uno con la entidad Cliente
    @JoinColumn(name = "id_cliente", nullable = false) // Especifica la columna de la clave externa en la tabla de mascotas
    private Cliente cliente; // Cliente al que pertenece la mascota
}
