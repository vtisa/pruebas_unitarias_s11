package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;
// Importaciones necesarias para el funcionamiento del controlador
import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota; // Importación del modelo de datos 'Mascota'
import dev.cesarzavaleta.pruebas_unitarias_s11.services.MascotaService; // Importación del servicio 'MascotaService'
import org.springframework.web.bind.annotation.GetMapping; // Importación de la anotación @GetMapping para mapear solicitudes HTTP GET
import org.springframework.web.bind.annotation.PathVariable; // Importación de la anotación @PathVariable para extraer variables de la URL
import org.springframework.web.bind.annotation.RequestMapping; // Importación de la anotación @RequestMapping para mapear solicitudes HTTP a nivel de clase
import org.springframework.web.bind.annotation.RestController; // Importación de la anotación @RestController para definir un controlador REST

import java.util.List; // Importación de la clase List para manejar listas de mascotas

@RestController // Define que esta clase es un controlador REST
@RequestMapping("/mascotas") // Mapea las solicitudes HTTP que comienzan con '/mascotas' a los métodos de este controlador
public class MascotaController {
    private final MascotaService mascotaService; // Servicio para manejar la lógica de negocio relacionada con 'Mascota'

    // Constructor que inyecta el servicio 'MascotaService' en el controlador
    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    // Mapea solicitudes HTTP GET a '/mascotas' para obtener todas las mascotas
    @GetMapping
    public List<Mascota> getAllMascota() {
        return mascotaService.finAll(); // Llama al método del servicio para obtener todas las mascotas
    }

    // Mapea solicitudes HTTP GET a '/mascotas/{id}' para obtener una mascota por su ID
    @GetMapping("/{id}")
    public Mascota getMascotaById(@PathVariable Long id) {
        return mascotaService.finById(id); // Llama al método del servicio para obtener una mascota por su ID
    }
}
