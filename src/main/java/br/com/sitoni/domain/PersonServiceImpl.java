package br.com.sitoni.domain;

import br.com.sitoni.domain.entity.Person;
import br.com.sitoni.domain.interfaces.service.PersonService;
import br.com.sitoni.utils.ValidaDocumentUtil;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
	
	@Override
    public Person salvar(@Valid Person obj) throws Exception {
        try {
        	if (obj.getName().equals("")  && obj.getName().isBlank() ) {
                throw new Exception("Name is mandatory!");
            }

            if (obj.getCpf().equals("")  && obj.getCpf().isBlank() ) {
                throw new Exception("CPF is mandatory!");
            }

            if (!ValidaDocumentUtil.isValidCPF(obj.getCpf())) {
                throw new Exception("CPF not valid!");
            }
            
            if(obj.getId() == null){
            	obj.setDateRegistration(new Date());
            } 
            
            Person person = baseRepository.findByCpf(obj.getCpf());
            System.out.println(person);
            if(person != null) {
                   throw new Exception("CPF already registered!");
            }
          
            obj.setDateUpdate(new Date());
            
            return baseRepository.save(obj);
        } catch (Exception e ) {
            throw new Exception(e.getMessage());
        }
    }
}
