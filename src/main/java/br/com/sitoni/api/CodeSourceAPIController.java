package br.com.sitoni.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sitoni.domain.dto.PersonDTO;
import br.com.sitoni.domain.entity.Person;

@RestController
@RequestMapping(value = "source")
@CrossOrigin(origins = {"*"})
public class CodeSourceAPIController{
	
    @GetMapping("/")
    public String sourceCode() {
        return "<h1>HelloWorld2<h1>";
    }
	
}
