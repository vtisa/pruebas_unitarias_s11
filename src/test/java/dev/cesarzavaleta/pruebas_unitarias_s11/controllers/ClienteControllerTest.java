package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cliente; // Importa el modelo de datos 'Cliente'
import dev.cesarzavaleta.pruebas_unitarias_s11.services.ClienteService; // Importa el servicio 'ClienteService'
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

// Clase de prueba para el controlador de clientes
class ClienteControllerTest {

    private ClienteService clienteService; // Servicio simulado para pruebas
    private ClienteController clienteController; // Controlador que será probado
    private MockMvc mockMvc; // Objeto MockMvc para realizar pruebas de controladores

    // Método de configuración a ejecutar antes de cada prueba
    @BeforeEach
    void setUp() {
        clienteService = mock(ClienteService.class); // Crear un mock del servicio de clientes
        clienteController = new ClienteController(clienteService); // Crear una instancia del controlador de clientes con el mock del servicio
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build(); // Configurar MockMvc para el controlador de clientes
    }

    // Prueba para el método getAllClientes del controlador de clientes
    @Test
    void getAllClientes() throws Exception {
        // Crear clientes de ejemplo
        Cliente cliente1 = new Cliente();
        cliente1.setIdCliente(1L);
        cliente1.setNombre("Juan");

        Cliente cliente2 = new Cliente();
        cliente2.setIdCliente(2L);
        cliente2.setNombre("María");

        List<Cliente> clientes = Arrays.asList(cliente1, cliente2); // Convertir los clientes en una lista

        when(clienteService.finAll()).thenReturn(clientes); // Configurar el comportamiento del servicio simulado

        // Realizar solicitud GET a '/clientes' y verificar la respuesta esperada
        mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk()) // Verificar que el estado de la respuesta sea OK (200)
                .andExpect(MockMvcResultMatchers.content().contentType("application/json")) // Verificar que el contenido de la respuesta sea JSON
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2))) // Verificar que la respuesta contenga dos elementos en la lista
                .andExpect(jsonPath("$[0].idCliente", is(1))) // Verificar que el primer elemento tenga ID 1
                .andExpect(jsonPath("$[0].nombre", is("Juan"))); // Verificar que el primer elemento tenga el nombre correcto
    }
}
