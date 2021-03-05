package br.com.sitoni.api;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("teste")
@WebMvcTest
@AutoConfigureMockMvc
public class PersonControllerTest {

	static String PERSON_API = "/person";
	
	@Autowired
	MockMvc mvc;
	
	@Test
	@DisplayName("Should create Person with sucess")
	public void createPersonTest() throws Exception {
		
		String json = new ObjectMapper().writeValueAsString(null);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(PERSON_API)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json);
		
		mvc
		.perform(request)
		.andExpect(status().isCreated())
		.andExpect( jsonPath("id").isNotEmpty() )
		.andExpect( jsonPath("name").value("Márcio A. Sitoni") )
		.andExpect( jsonPath("sex").value("M") )
		.andExpect( jsonPath("email").value("msitoni@hotmail.com") );
		
	}
	
	@Test
	@DisplayName("You should throw a validation error when there is not enough data to create the book")
	public void createInvalidPersonTest() {
		
	}

    
}
