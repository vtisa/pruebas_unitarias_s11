package dev.cesarzavaleta.pruebas_unitarias_s11.model;

import jakarta.persistence.*; // Importa las anotaciones de Java Persistence API (JPA)
import lombok.AllArgsConstructor; // Importa la anotación AllArgsConstructor de Lombok
import lombok.Getter; // Importa la anotación Getter de Lombok
import lombok.NoArgsConstructor; // Importa la anotación NoArgsConstructor de Lombok
import lombok.Setter; // Importa la anotación Setter de Lombok

import java.io.Serializable; // Importa la interfaz Serializable

@Getter
@Setter
@AllArgsConstructor // Genera un constructor con todos los argumentos
@NoArgsConstructor // Genera un constructor sin argumentos
@Entity // Marca esta clase como una entidad JPA
@Table(name = "clientes") // Especifica el nombre de la tabla en la base de datos

// Clase que representa a un cliente
public class Cliente implements Serializable {

    @Id // Marca este campo como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica la estrategia de generación de valores para la clave primaria
    @Column(name = "id_cliente") // Especifica el nombre de la columna en la base de datos
    private Long idCliente; // ID del cliente

    @Column(nullable = false, length = 255) // Especifica restricciones de la columna en la base de datos
    private String nombre; // Nombre del cliente

    @Column(nullable = false, length = 255) // Especifica restricciones de la columna en la base de datos
    private String apellido; // Apellido del cliente

    @Column(length = 255) // Especifica restricciones de la columna en la base de datos
    private String direccion; // Dirección del cliente

    @Column(length = 20) // Especifica restricciones de la columna en la base de datos
    private String telefono; // Teléfono del cliente

    @Column(name = "correo_electronico", unique = true, length = 50) // Especifica restricciones de la columna en la base de datos
    private String correoElectronico; // Correo electrónico del cliente
}
