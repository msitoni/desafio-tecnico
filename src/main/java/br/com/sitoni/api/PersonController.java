package br.com.sitoni.api;

import br.com.sitoni.application.PersonApplication;
import br.com.sitoni.domain.dto.PersonDTO;
import br.com.sitoni.domain.entity.Person;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
