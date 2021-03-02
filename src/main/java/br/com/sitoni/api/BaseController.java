package br.com.sitoni.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.sitoni.application.BaseApplication;
import br.com.sitoni.domain.dto.BaseDTO;
import br.com.sitoni.domain.entity.BaseEntity;


/**
 * BaseController
 */
public class BaseController<DTO extends BaseDTO, Entity extends BaseEntity> {

    @Autowired
    BaseApplication<DTO, Entity> baseApplication;

    @GetMapping
    public List<DTO> listAll() {
        return baseApplication.buscarTodos();
    }

    @GetMapping("/{id}")
    public Optional<DTO> searchById(@PathVariable("id") Long id) throws Exception {
        return baseApplication.buscarPorId(id);
    }

   /* @PostMapping("")
    public DTO add(@RequestBody DTO obj) throws Exception {
        return baseApplication.salvar(obj);
    }*/
    
    @PostMapping
	public ResponseEntity<Object> add(@RequestBody DTO obj/* , @RequestHeader("Authorization") UUID token */) {
    	//public ResponseEntity<Object> add(@RequestBody DTO obj) {
    	try {
            return response(baseApplication.salvar(obj));
        } catch (Exception e) {
            return response(e);
        }
    }


    @PutMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public DTO update(@RequestBody @Valid DTO obj) throws Exception {
        return baseApplication.alterar(obj);
    }

    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestParam(value = "id") Long id) throws Exception{
        try{
            baseApplication.deletar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }



    protected ResponseEntity<Object> response(Object obj) {
        if (obj == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else if(obj instanceof Exception) {
            ((Exception) obj).printStackTrace();
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }



}