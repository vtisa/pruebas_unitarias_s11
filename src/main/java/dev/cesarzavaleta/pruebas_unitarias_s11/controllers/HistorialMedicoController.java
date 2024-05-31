package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

// Importaciones necesarias para el funcionamiento del controlador
import dev.cesarzavaleta.pruebas_unitarias_s11.model.HistorialMedico; // Importación del modelo de datos 'HistorialMedico'
import dev.cesarzavaleta.pruebas_unitarias_s11.services.HistorialMedicoService; // Importación del servicio 'HistorialMedicoService'
import org.springframework.web.bind.annotation.GetMapping; // Importación de la anotación @GetMapping para mapear solicitudes HTTP GET
import org.springframework.web.bind.annotation.PathVariable; // Importación de la anotación @PathVariable para extraer variables de la URL
import org.springframework.web.bind.annotation.RequestMapping; // Importación de la anotación @RequestMapping para mapear solicitudes HTTP a nivel de clase
import org.springframework.web.bind.annotation.RestController; // Importación de la anotación @RestController para definir un controlador REST
import org.springframework.web.bind.annotation.PostMapping; // Importación de la anotación @PostMapping para mapear solicitudes HTTP POST
import org.springframework.web.bind.annotation.RequestBody; // Importación de la anotación @RequestBody para extraer el cuerpo de la solicitud

import java.util.List; // Importación de la clase List para manejar listas de historiales médicos

@RestController // Define que esta clase es un controlador REST
@RequestMapping("/historialMedico") // Mapea las solicitudes HTTP que comienzan con '/historialMedico' a los métodos de este controlador
public class HistorialMedicoController {

    private final HistorialMedicoService historialMedicoService;

    // Constructor que inyecta el servicio 'HistorialMedicoService' en el controlador
    public HistorialMedicoController(HistorialMedicoService historialMedicoService) {
        this.historialMedicoService = historialMedicoService;
    }

    // Mapea solicitudes HTTP GET a '/historialMedico'
    @GetMapping
    public List<HistorialMedico> getAllHistorialMedico() {
        return historialMedicoService.finAll();
    }

    // Mapea solicitudes HTTP GET a '/historialMedico/{id}' para obtener por id
    @GetMapping("/{id}")
    public HistorialMedico getHistorialMedicoById(@PathVariable Long id) {
        return historialMedicoService.finById(id);
    }

    // Mapea solicitudes HTTP POST a '/historialMedico' para crear un nuevo historial médico
    @PostMapping
    public HistorialMedico createHistorialMedico(@RequestBody HistorialMedico historialMedico) {
        return historialMedicoService.save(historialMedico); // Llama al método del servicio para guardar el nuevo historial médico
    }
}
