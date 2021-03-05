package br.com.sitoni.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.sitoni.domain.interfaces.repository.spring.PersonRepository;
import br.com.sitoni.domain.interfaces.service.PersonService;

@SpringBootTest
public class PersonServiceMockTest {

	@Mock
    private PersonRepository personRepository;

    @InjectMocks // auto inject personRepository
    private PersonService personService = new PersonServiceImpl();
    
    @BeforeEach
    void setMockOutput() {
        when(personRepository.source()).thenReturn("Hello Mockito From Repository");
    }
    
    
    @DisplayName("Test Mock helloService + helloRepository")
    @Test
    void testSource() {
        assertEquals("Hello Mockito From Repository", personService.source());
    }
    
    
    
}
