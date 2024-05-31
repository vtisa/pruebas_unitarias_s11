package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

// Importaciones necesarias para el funcionamiento del controlador
import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cita; // Importación del modelo de datos 'Cita'
import dev.cesarzavaleta.pruebas_unitarias_s11.services.CitaService; // Importación del servicio 'CitaService'
import org.springframework.web.bind.annotation.GetMapping; // Importación de la anotación @GetMapping para mapear solicitudes HTTP GET
import org.springframework.web.bind.annotation.PathVariable; // Importación de la anotación @PathVariable para extraer variables de la URL
import org.springframework.web.bind.annotation.RequestMapping; // Importación de la anotación @RequestMapping para mapear solicitudes HTTP a nivel de clase
import org.springframework.web.bind.annotation.RestController; // Importación de la anotación @RestController para definir un controlador REST
import org.springframework.web.bind.annotation.PostMapping; // Importación de la anotación @PostMapping para mapear solicitudes HTTP POST
import org.springframework.web.bind.annotation.RequestBody; // Importación de la anotación @RequestBody para extraer el cuerpo de la solicitud

import java.util.List; // Importación de la clase List para manejar listas de citas

@RestController // Anotación que indica que esta clase es un controlador REST
@RequestMapping("/citas") // Mapea las solicitudes HTTP que comienzan con '/citas' a los métodos de este controlador
public class CitaController {

    private final CitaService citaService; // Servicio para manejar la lógica de negocio

    // Constructor que inyecta el servicio 'CitaService' en el controlador
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    // Mapea solicitudes HTTP GET a '/citas' para obtener todas las citas
    @GetMapping
    public List<Cita> getAllCitas() {
        return citaService.finAll(); // Llama al método del servicio para obtener todas las citas
    }

    // Mapea solicitudes HTTP GET a '/citas/{id}' para obtener una cita por su ID
    @GetMapping("/{id}")
    public Cita getCitaById(@PathVariable long id) {
        return citaService.finById(id); // Llama al método del servicio para obtener una cita por su ID
    }

    // Mapea solicitudes HTTP POST a '/citas' para crear una nueva cita
    @PostMapping
    public Cita createCita(@RequestBody Cita cita) {
        return citaService.save(cita); // Llama al método del servicio para guardar la nueva cita
    }
}
