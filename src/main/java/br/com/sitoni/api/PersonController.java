package br.com.sitoni.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sitoni.application.PersonApplication;
import br.com.sitoni.domain.dto.PersonDTO;
import br.com.sitoni.domain.entity.Person;

@RestController
@RequestMapping(value = "person")
@CrossOrigin(origins = {"*"})
public class PersonController extends BaseController<PersonDTO, Person>{

    @Autowired
    private PersonApplication personApplication;

    @GetMapping("/hello")
    public String helloWorld() {
        return "<h1>HelloWorld2<h1>";
    }

    @GetMapping("/source")
    public String source() {
    	System.out.println(personApplication.source());
		return personApplication.source();
    }
    
    /*@PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Salva um novo cliente")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created person success"),
            @ApiResponse(code = 400, message = "Error validation")
    })
    public DTO adicionar(@RequestBody @Valid DTO obj) throws Exception {
        return baseApplication.salvar(obj);
    }*/


}
