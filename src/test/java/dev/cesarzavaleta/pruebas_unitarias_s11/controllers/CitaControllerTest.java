package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cita; // Importación del modelo de datos 'Cita'
import dev.cesarzavaleta.pruebas_unitarias_s11.services.CitaService; // Importación del servicio 'CitaService'
import org.junit.jupiter.api.BeforeEach; // Importación de la anotación @BeforeEach de JUnit Jupiter
import org.junit.jupiter.api.Test; // Importación de la anotación @Test de JUnit Jupiter
import org.springframework.test.web.servlet.MockMvc; // Importación de MockMvc para realizar pruebas de controladores
import org.springframework.test.web.servlet.result.MockMvcResultMatchers; // Importación de MockMvcResultMatchers para realizar aserciones en las respuestas
import org.springframework.test.web.servlet.setup.MockMvcBuilders; // Importación de MockMvcBuilders para configurar el entorno de prueba
import java.sql.Timestamp; // Importación de la clase Timestamp para manejar fechas y horas
import java.util.Arrays; // Importación de la clase Arrays para manejar arreglos
import java.util.List; // Importación de la clase List para manejar listas
import static org.hamcrest.Matchers.hasSize; // Importación de Matchers.hasSize para verificar el tamaño de una lista
import static org.hamcrest.Matchers.is; // Importación de Matchers.is para comparaciones exactas
import static org.mockito.Mockito.mock; // Importación de Mockito.mock para crear mocks de clases
import static org.mockito.Mockito.when; // Importación de Mockito.when para configurar comportamiento de mocks
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // Importación de get de MockMvcRequestBuilders para realizar solicitudes GET
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; // Importación de jsonPath de MockMvcResultMatchers para verificar el contenido JSON
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; // Importación de status de MockMvcResultMatchers para verificar el estado HTTP

// Clase de prueba para el controlador de citas
class CitaControllerTest {

    private CitaService citaService; // Servicio simulado para pruebas
    private CitaController citaController; // Controlador que será probado
    private MockMvc mockMvc; // Objeto MockMvc para realizar pruebas de controladores

    // Método de configuración a ejecutar antes de cada prueba
    @BeforeEach
    void setUp() {
        citaService = mock(CitaService.class); // Crear un mock del servicio de citas
        citaController = new CitaController(citaService); // Crear una instancia del controlador de citas con el mock del servicio
        mockMvc = MockMvcBuilders.standaloneSetup(citaController).build(); // Configurar MockMvc para el controlador de citas
    }

    // Prueba para el método getAllCitas del controlador de citas
    @Test
    void getAllCitas() throws Exception {
        // Crear citas de ejemplo
        Cita cita1 = new Cita();
        cita1.setIdCita(1);
        cita1.setFechaHora(Timestamp.valueOf("2024-05-25 15:00:00"));
        cita1.setMotivoConsulta("Revisión Anual");
        cita1.setIdMascota(1);

        Cita cita2 = new Cita();
        cita2.setIdCita(2);
        cita2.setFechaHora(Timestamp.valueOf("2024-07-10 16:00:00"));
        cita2.setMotivoConsulta("Control Dermatológico");
        cita2.setIdMascota(2);

        List<Cita> citas = Arrays.asList(cita1, cita2); // Convertir las citas en una lista

        when(citaService.finAll()).thenReturn(citas); // Configurar el comportamiento del servicio simulado

        // Realizar solicitud GET a '/citas' y verificar la respuesta esperada
        mockMvc.perform(get("/citas"))
                .andExpect(status().isOk()) // Verificar que el estado de la respuesta sea OK (200)
                .andExpect(MockMvcResultMatchers.content().contentType("application/json")) // Verificar que el contenido de la respuesta sea JSON
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2))) // Verificar que la respuesta contenga dos elementos en la lista
                .andExpect(jsonPath("$[0].idCita", is(1))) // Verificar que el primer elemento tenga ID 1
                .andExpect(jsonPath("$[0].motivoConsulta", is("Revisión Anual"))); // Verificar que el primer elemento tenga el motivo de consulta correcto
    }
}
