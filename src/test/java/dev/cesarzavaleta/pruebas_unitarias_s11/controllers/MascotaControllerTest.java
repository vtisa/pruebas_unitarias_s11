package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota; // Importa el modelo de datos 'Mascota'
import dev.cesarzavaleta.pruebas_unitarias_s11.services.MascotaService; // Importa el servicio 'MascotaService'
import org.junit.jupiter.api.BeforeEach; // Importa la anotación @BeforeEach de JUnit Jupiter
import org.junit.jupiter.api.Test; // Importa la anotación @Test de JUnit Jupiter
import org.springframework.test.web.servlet.MockMvc; // Importa MockMvc para realizar pruebas de controladores
import org.springframework.test.web.servlet.result.MockMvcResultMatchers; // Importa MockMvcResultMatchers para realizar aserciones en las respuestas
import org.springframework.test.web.servlet.setup.MockMvcBuilders; // Importa MockMvcBuilders para configurar el entorno de prueba
import java.util.Arrays; // Importa la clase Arrays para manejar arreglos
import java.util.List; // Importa la clase List para manejar listas

import static org.hamcrest.Matchers.hasSize; // Importa Matchers.hasSize para verificar el tamaño de una lista
import static org.mockito.Mockito.mock; // Importa Mockito.mock para crear mocks de clases
import static org.mockito.Mockito.when; // Importa Mockito.when para configurar comportamiento de mocks
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // Importa get de MockMvcRequestBuilders para realizar solicitudes GET
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; // Importa status de MockMvcResultMatchers para verificar el estado HTTP
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; // Importa jsonPath de MockMvcResultMatchers para verificar el contenido JSON
import static org.hamcrest.Matchers.is; // Importa Matchers.is para comparaciones exactas

// Clase de prueba para el controlador de mascotas
class MascotaControllerTest {
    private MascotaController mascotaController; // Controlador que será probado
    private MascotaService mascotaService; // Servicio simulado para pruebas
    private MockMvc mockMvc; // Objeto MockMvc para realizar pruebas de controladores

    // Método de configuración a ejecutar antes de cada prueba
    @BeforeEach
    void setUp() {
        mascotaService = mock(MascotaService.class); // Crear un mock del servicio de mascotas
        mascotaController = new MascotaController(mascotaService); // Crear una instancia del controlador de mascotas con el mock del servicio
        mockMvc = MockMvcBuilders.standaloneSetup(mascotaController).build(); // Configurar MockMvc para el controlador de mascotas
    }

    // Prueba para el método getAllMascotas del controlador de mascotas
    @Test
    void getAllMascotas() throws Exception {
        // Crear mascotas de ejemplo
        Mascota mascota1 = new Mascota();
        mascota1.setIdMascota(1L);
        mascota1.setNombre("Lucas");

        Mascota mascota2 = new Mascota();
        mascota2.setIdMascota(2L);
        mascota2.setNombre("Luna");

        List<Mascota> mascotas = Arrays.asList(mascota1, mascota2); // Convertir las mascotas en una lista

        when(mascotaService.finAll()).thenReturn(mascotas); // Configurar el comportamiento del servicio simulado

        // Realizar solicitud GET a '/mascotas' y verificar la respuesta esperada
        mockMvc.perform(get("/mascotas"))
                .andExpect(status().isOk()) // Verificar que el estado de la respuesta sea OK (200)
                .andExpect(MockMvcResultMatchers.content().contentType("application/json")) // Verificar que el contenido de la respuesta sea JSON
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2))) // Verificar que la respuesta contenga dos elementos en la lista
                .andExpect(jsonPath("$[0].idMascota", is(1))) // Verificar que el primer elemento tenga ID 1
                .andExpect(jsonPath("$[0].nombre", is("Lucas"))); // Verificar que el primer elemento tenga el nombre correcto
    }
}
