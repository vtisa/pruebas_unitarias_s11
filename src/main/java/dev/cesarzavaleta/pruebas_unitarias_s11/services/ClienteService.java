package dev.cesarzavaleta.pruebas_unitarias_s11.services;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cliente; // Importa el modelo de datos 'Cliente'
import java.util.List; // Importa la clase List para manejar listas

// Interfaz que define el contrato para el servicio de 'Cliente'
public interface ClienteService {

    // Método para obtener todos los clientes
    List<Cliente> finAll();

    // Método para obtener un cliente por su ID
    Cliente finById(Long id);

    // Método para guardar un cliente
    Cliente save(Cliente cliente);

    // Método para eliminar un cliente por su ID
    void deleteById(Long id);
}
