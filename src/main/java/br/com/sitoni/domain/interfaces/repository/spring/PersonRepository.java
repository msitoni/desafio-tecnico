package br.com.sitoni.domain.interfaces.repository.spring;


import br.com.sitoni.domain.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends BaseRepository<Person>{
}
