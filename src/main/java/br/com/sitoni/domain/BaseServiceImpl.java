package br.com.sitoni.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

//import br.com.sitoni.domain.dto.integracao.AutenticacaoDTO;
import br.com.sitoni.domain.entity.BaseEntity;
import br.com.sitoni.domain.interfaces.repository.spring.BaseRepository;
import br.com.sitoni.domain.interfaces.service.BaseService;

public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    @Autowired
    BaseRepository<T> baseRepository;

//    @Autowired
//    LoginService loginService;

    @Override
    public Optional<T> buscarPorId(Long id) throws Exception {
        return baseRepository.findById(id);
    }

    @Override
    public Page<T> buscarPaginado(PageRequest pageable){
        return baseRepository.findAll(pageable);
    }


    @Override
    public T salvar(T obj) throws Exception {
        try {
            return baseRepository.save(obj);
        } catch (Exception e ) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void deletar(Long id) throws Exception{
//        loginService.validarToken(token);

        baseRepository.deleteById(id);;
    }

    @Override
    public List<T> buscarTodos() {
        return baseRepository.findAll();
    }

  
    @Override
    public T alterar(T e) throws Exception {
        return salvar(e);
    }

}
