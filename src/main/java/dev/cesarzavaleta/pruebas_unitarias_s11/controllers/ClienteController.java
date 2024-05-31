package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;
// Importaciones necesarias para el funcionamiento del controlador
import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cliente; // Importación del modelo de datos 'Cliente'
import dev.cesarzavaleta.pruebas_unitarias_s11.services.ClienteService; // Importación del servicio 'ClienteService'
import org.springframework.web.bind.annotation.GetMapping; // Importación de la anotación @GetMapping para mapear solicitudes HTTP GET
import org.springframework.web.bind.annotation.PathVariable; // Importación de la anotación @PathVariable para extraer variables de la URL
import org.springframework.web.bind.annotation.RequestMapping; // Importación de la anotación @RequestMapping para mapear solicitudes HTTP a nivel de clase
import org.springframework.web.bind.annotation.RestController; // Importación de la anotación @RestController para definir un controlador REST

import java.util.List; // Importación de la clase List para manejar listas de clientes

@RestController // Define que esta clase es un controlador REST
@RequestMapping("/clientes") // Mapea las solicitudes HTTP que comienzan con '/clientes' a los métodos de este controlador
public class ClienteController {

    private final ClienteService clienteService; // Servicio para manejar la lógica de negocio relacionada con 'Cliente'

    // Constructor que inyecta el servicio 'ClienteService' en el controlador
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Mapea solicitudes HTTP GET a '/clientes' para obtener todos los clientes
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.finAll(); // Llama al método del servicio para obtener todos los clientes
    }

    // Mapea solicitudes HTTP GET a '/clientes/{id}' para obtener un cliente por su ID
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteService.finById(id); // Llama al método del servicio para obtener un cliente por su ID
    }
}
