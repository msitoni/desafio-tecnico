package br.com.sitoni.application;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sitoni.domain.dto.PersonDTO;
import br.com.sitoni.domain.entity.Person;
import br.com.sitoni.domain.interfaces.service.PersonService;

@Service
public class PersonApplication extends BaseApplication<PersonDTO, Person>{

	@Autowired PersonService personService;
	
    @Override
    public Person mapToEntity(@Valid PersonDTO dto) throws Exception {
    	
    		
            Person e = new Person();
            e.setDateRegistration(dto.getDateRegistration());
            e.setDateUpdate(dto.getDateUpdate());
            e.setCpf(dto.getCpf());
            e.setName(dto.getName());
            e.setDateBirth(dto.getDateBirth());
            e.setEmail(dto.getEmail());
            e.setId(dto.getId());
            e.setNationality(dto.getNationality());
            e.setNaturalness(dto.getNaturalness());
            e.setSex(dto.getSex());
            return e;
    	
    }

    @Override
    public PersonDTO mapToDTO(Person e) {
        PersonDTO dto = new PersonDTO();
        dto.setCpf(e.getCpf());
        dto.setName(e.getName());
        dto.setDateBirth(e.getDateBirth());
        dto.setDateRegistration(e.getDateRegistration());
        dto.setDateUpdate(e.getDateUpdate());
        dto.setEmail(e.getEmail());
        dto.setId(e.getId());
        dto.setNationality(e.getNationality());
        dto.setNaturalness(e.getNaturalness());
        dto.setSex(e.getSex());
        return dto;
    }
    
    public String source() {
    	return personService.source();
    }
}
