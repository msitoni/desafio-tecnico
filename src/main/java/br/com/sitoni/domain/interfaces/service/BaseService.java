package br.com.sitoni.domain.interfaces.service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


public interface BaseService<T> {
    Optional<T> buscarPorId(Long id) throws Exception;
    T salvar(T obj) throws Exception;
    void deletar(Long id) throws Exception;
    List<T> buscarTodos();
    T alterar(T e) throws Exception;
	Page<T> buscarPaginado(PageRequest pageRequest);
}
