package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.HistorialMedico; // Importa el modelo de datos 'HistorialMedico'
import dev.cesarzavaleta.pruebas_unitarias_s11.services.HistorialMedicoService; // Importa el servicio 'HistorialMedicoService'
import org.junit.jupiter.api.BeforeEach; // Importa la anotación @BeforeEach de JUnit Jupiter
import org.junit.jupiter.api.Test; // Importa la anotación @Test de JUnit Jupiter
import org.springframework.test.web.servlet.MockMvc; // Importa MockMvc para realizar pruebas de controladores
import org.springframework.test.web.servlet.result.MockMvcResultMatchers; // Importa MockMvcResultMatchers para realizar aserciones en las respuestas
import org.springframework.test.web.servlet.setup.MockMvcBuilders; // Importa MockMvcBuilders para configurar el entorno de prueba

import java.util.Arrays; // Importa la clase Arrays para manejar arreglos
import java.util.List; // Importa la clase List para manejar listas

import static org.hamcrest.Matchers.hasSize; // Importa Matchers.hasSize para verificar el tamaño de una lista
import static org.hamcrest.Matchers.is; // Importa Matchers.is para comparaciones exactas
import static org.mockito.Mockito.mock; // Importa Mockito.mock para crear mocks de clases
import static org.mockito.Mockito.when; // Importa Mockito.when para configurar comportamiento de mocks
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // Importa get de MockMvcRequestBuilders para realizar solicitudes GET
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; // Importa jsonPath de MockMvcResultMatchers para verificar el contenido JSON
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; // Importa status de MockMvcResultMatchers para verificar el estado HTTP

// Clase de prueba para el controlador de historial médico
class HistorialMedicoControllerTest {

    private HistorialMedicoService historialMedicoService; // Servicio simulado para pruebas
    private HistorialMedicoController historialMedicoController; // Controlador que será probado
    private MockMvc mockMvc; // Objeto MockMvc para realizar pruebas de controladores

    // Método de configuración a ejecutar antes de cada prueba
    @BeforeEach
    void setUp() {
        historialMedicoService = mock(HistorialMedicoService.class); // Crear un mock del servicio de historial médico
        historialMedicoController = new HistorialMedicoController(historialMedicoService); // Crear una instancia del controlador de historial médico con el mock del servicio
        mockMvc = MockMvcBuilders.standaloneSetup(historialMedicoController).build(); // Configurar MockMvc para el controlador de historial médico
    }

    // Prueba para el método getAllHistorialMedico del controlador de historial médico
    @Test
    void getAllHistorialMedico() throws Exception {
        // Crear historiales médicos de ejemplo
        HistorialMedico historial1 = new HistorialMedico();
        historial1.setIdHistorial(1);
        historial1.setDiagnostico("Parásitos intestinales");

        HistorialMedico historial2 = new HistorialMedico();
        historial2.setIdHistorial(2);
        historial2.setDiagnostico("Rabia");

        List<HistorialMedico> historiales = Arrays.asList(historial1, historial2); // Convertir los historiales médicos en una lista

        when(historialMedicoService.finAll()).thenReturn(historiales); // Configurar el comportamiento del servicio simulado

        // Realizar solicitud GET a '/historialMedico' y verificar la respuesta esperada
        mockMvc.perform(get("/historialMedico"))
                .andExpect(status().isOk()) // Verificar que el estado de la respuesta sea OK (200)
                .andExpect(MockMvcResultMatchers.content().contentType("application/json")) // Verificar que el contenido de la respuesta sea JSON
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2))) // Verificar que la respuesta contenga dos elementos en la lista
                .andExpect(jsonPath("$[0].idHistorial", is(1))) // Verificar que el primer elemento tenga ID 1
                .andExpect(jsonPath("$[0].diagnostico", is("Parásitos intestinales"))); // Verificar que el primer elemento tenga el diagnóstico correcto
    }
}
