package br.com.sitoni.domain.interfaces.repository.spring;

import br.com.sitoni.domain.entity.BaseEntity;
import br.com.sitoni.domain.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;


@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

	Person findByCpf(String cpf);

}