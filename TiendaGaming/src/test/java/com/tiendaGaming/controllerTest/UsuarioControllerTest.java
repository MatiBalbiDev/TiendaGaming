package com.tiendaGaming.controllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.tiendaGaming.controller.UsuarioController;
import com.tiendaGaming.model.ERol;
import com.tiendaGaming.model.Rol;
import com.tiendaGaming.model.Usuario;
import com.tiendaGaming.repository.UsuarioRepository;
import com.tiendaGaming.request.RegistroRequest;
import com.tiendaGaming.response.MessageResponse;
import com.tiendaGaming.service.RolService;

class UsuarioControllerTest {
		
	@Autowired
	private Usuario usuario;
	
	@Autowired
	private ObjectMapper mapper = new ObjectMapper();
	
	private ObjectWriter objectWriter = mapper.writer();
	
	@Mock
	private RegistroRequest usuarioRequest;
	
	@Mock
	private PasswordEncoder passwordEncoder;
	
	@Mock
	private RolService rolService;
	
	@Mock
	private UsuarioRepository usuarioRepository;
	
	@InjectMocks
	private UsuarioController usuarioController;
	
	private Set<Rol> roles = new HashSet<Rol>();
	
	private Set<String> roles2 = new HashSet<String>();
	
	@Autowired
	private MockMvc mockMvc;
	
	ResponseEntity<MessageResponse> response = new ResponseEntity<MessageResponse>(new MessageResponse("Usuario creado"), HttpStatus.CREATED);
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		roles.add(new Rol(ERol.ROLE_USER));
	}

	@Test
	void testIniciarSesion() {
		fail("Not yet implemented");
	}

	@Test
	void testRegistrarUsuario() throws Exception {
		Usuario usuario = new Usuario("ash", "ketchup", "ashket", "ashketchup@gmail.com", "1123548978", "ash123");
		usuario.setRoles(roles);
		roles2.add("user");
		usuarioRequest.setNombre(usuario.getNombre());
		usuarioRequest.setApellido(usuario.getApellido());
		usuarioRequest.setNombreUsuario(usuario.getNombreUsuario());
		usuarioRequest.setEmail(usuario.getEmail());
		usuarioRequest.setTelefono(usuario.getTelefono());
		usuarioRequest.setPassword(usuario.getPassword());
		usuarioRequest.setRoles(roles2);
		
		
		
		
		
		
		String content = objectWriter.writeValueAsString(usuario);
		
		Mockito.when(usuarioController.registrarUsuario(usuarioRequest)).thenReturn(response);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/signup");
		
		mockMvc.perform(mockRequest)
				.andExpect(status().isCreated());
	}

}
