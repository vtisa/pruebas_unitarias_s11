package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;
// Importaciones necesarias para el funcionamiento del controlador
import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota; // Importación del modelo de datos 'Mascota'
import dev.cesarzavaleta.pruebas_unitarias_s11.services.MascotaService; // Importación del servicio 'MascotaService'
import org.springframework.http.ResponseEntity; // Importación de ResponseEntity para manejar respuestas HTTP
import org.springframework.web.bind.annotation.*;

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

    // Mapea solicitudes HTTP POST a '/mascotas' para crear una nueva mascota
    @PostMapping
    public Mascota createMascota(@RequestBody Mascota mascota) {
        return mascotaService.save(mascota); // Llama al método del servicio para guardar la nueva mascota
    }

    // Mapea solicitudes HTTP PUT a '/mascotas/{id}' para actualizar una mascota existente
    @PutMapping("/{id}")
    public Mascota updateMascota(@PathVariable Long id, @RequestBody Mascota mascotaDetails) {
        Mascota mascota = mascotaService.finById(id); // Llama al método del servicio para obtener la mascota por su ID
        if (mascota == null) {
            // Manejar el caso en que la mascota no sea encontrada
        }
        // Actualiza los detalles de la mascota
        mascota.setNombre(mascotaDetails.getNombre());
        mascota.setEspecie(mascotaDetails.getEspecie());
        mascota.setRaza(mascotaDetails.getRaza());
        mascota.setSexo(mascotaDetails.getSexo());
        mascota.setFechaNacimiento(mascotaDetails.getFechaNacimiento());
        mascota.setCliente(mascotaDetails.getCliente());
        return mascotaService.save(mascota); // Guarda la mascota actualizada
    }

    // Mapea solicitudes HTTP DELETE a '/mascotas/{id}' para eliminar una mascota por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMascota(@PathVariable Long id) {
        mascotaService.deleteById(id); // Llama al método del servicio para eliminar la mascota por su ID
        return ResponseEntity.noContent().build(); // Devuelve una respuesta HTTP 204 No Content
    }
}