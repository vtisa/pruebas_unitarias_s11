package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota; // Importa el modelo de datos 'Mascota'
import dev.cesarzavaleta.pruebas_unitarias_s11.services.MascotaService; // Importa el servicio 'MascotaService'
import org.junit.jupiter.api.BeforeEach; // Importa la anotación @BeforeEach de JUnit Jupiter
import org.junit.jupiter.api.Test; // Importa la anotación @Test de JUnit Jupiter
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc; // Importa MockMvc para realizar pruebas de controladores
import org.springframework.test.web.servlet.setup.MockMvcBuilders; // Importa MockMvcBuilders para configurar el entorno de prueba
import java.util.Arrays; // Importa la clase Arrays para manejar arreglos
import java.util.List; // Importa la clase List para manejar listas

import static org.hamcrest.Matchers.hasSize; // Importa Matchers.hasSize para verificar el tamaño de una lista
import static org.mockito.Mockito.mock; // Importa Mockito.mock para crear mocks de clases
import static org.mockito.Mockito.when; // Importa Mockito.when para configurar comportamiento de mocks
import static org.hamcrest.Matchers.is; // Importa Matchers.is para comparaciones exactas
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Clase de prueba para el controlador de mascotas
class MascotaControllerTest {
    private MascotaController mascotaController; // Controlador de mascotas a probar
    private MascotaService mascotaService; // Servicio de mascotas mockeado
    private MockMvc mockMvc; // MockMvc para pruebas de controladores

    // Configuración inicial antes de cada prueba
    @BeforeEach
    void setUp() {
        mascotaService = mock(MascotaService.class); // Crear un mock del servicio de mascotas
        mascotaController = new MascotaController(mascotaService); // Crear el controlador con el servicio mockeado
        mockMvc = MockMvcBuilders.standaloneSetup(mascotaController).build(); // Configurar MockMvc
    }

    // Prueba para obtener todas las mascotas
    @Test
    void getAllMascotas() throws Exception {
        Mascota mascota1 = new Mascota();
        mascota1.setIdMascota(1L);
        mascota1.setNombre("Lucas");

        Mascota mascota2 = new Mascota();
        mascota2.setIdMascota(2L);
        mascota2.setNombre("Luna");

        List<Mascota> mascotas = Arrays.asList(mascota1, mascota2); // Lista de mascotas mockeadas

        when(mascotaService.finAll()).thenReturn(mascotas); // Configurar el mock para devolver la lista

        mockMvc.perform(get("/mascotas")) // Realizar solicitud GET
                .andExpect(status().isOk()) // Verificar que el estado de la respuesta sea OK (200)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Verificar que el contenido sea JSON
                .andExpect(jsonPath("$", hasSize(2))) // Verificar que la lista tenga dos elementos
                .andExpect(jsonPath("$[0].idMascota", is(1))) // Verificar el ID de la primera mascota
                .andExpect(jsonPath("$[0].nombre", is("Lucas"))); // Verificar el nombre de la primera mascota
    }


    // Prueba para eliminar una mascota
    @Test
    void deleteMascota() throws Exception {
        mockMvc.perform(delete("/mascotas/{id}", 1L)) // Realizar solicitud DELETE
                .andExpect(status().isNoContent()); // Verificar que el estado de la respuesta sea No Content (204)
    }

    // Prueba para actualizar una mascota
    @Test
    void updateMascota() throws Exception {
        Mascota mascota = new Mascota();
        mascota.setIdMascota(1L);
        mascota.setNombre("Lucas");

        when(mascotaService.finById(1L)).thenReturn(mascota); // Configurar el mock para devolver la mascota existente
        when(mascotaService.save(mascota)).thenReturn(mascota); // Configurar el mock para devolver la mascota guardada

        mockMvc.perform(put("/mascotas/{id}", 1L) // Realizar solicitud PUT
                        .contentType(MediaType.APPLICATION_JSON) // Especificar el tipo de contenido
                        .content("{\"nombre\": \"Lucas actualizado\"}")) // Contenido del cuerpo de la solicitud
                .andExpect(status().isOk()) // Verificar que el estado de la respuesta sea OK (200)
                .andExpect(jsonPath("$.idMascota", is(1))) // Verificar el ID de la mascota actualizada
                .andExpect(jsonPath("$.nombre", is("Lucas actualizado"))); // Verificar el nombre de la mascota actualizada
    }
}