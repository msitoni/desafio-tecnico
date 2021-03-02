package br.com.sitoni.application;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import br.com.sitoni.domain.interfaces.service.BaseService;

/**
 * BaseApplication
 */
public abstract class BaseApplication<DTO, Entity > {

    public abstract Entity mapToEntity(DTO dto) throws Exception;
    public abstract DTO mapToDTO(Entity e);

    @Autowired
    BaseService<Entity> baseService;

    public Page<DTO> buscarPaginado(int page, int size) {
        Direction sDirection = null;
        String[] properties = new String[0];
        return buscarPaginado(page, size, sDirection, properties);
    }

    public Page<DTO> buscarPaginado(int page, int size, Direction sDirection, String... properties) {
        if (sDirection == null) {
            sDirection = Direction.ASC;
        }

        if (properties == null || properties.length == 0) {
            properties = new String[1];
            properties[0] = "id";
        }

        PageRequest pageRequest = PageRequest.of(
            page,
            size,
            sDirection,
            properties);
        Page<Entity> p = baseService.buscarPaginado(pageRequest);

        return p.map((entity) -> mapToDTO(entity));
    }

    public Optional<DTO> buscarPorId(Long id) throws Exception {
        Optional<Entity> e = baseService.buscarPorId(id);
        if(e != null)
            return Optional.of(this.mapToDTO(e.get()));
        return null;
    }

    public DTO salvar(DTO dto) throws Exception {
        Entity e = this.mapToEntity(dto);
        return this.mapToDTO(baseService.salvar(e));
    }

    public DTO alterar(DTO dto) throws Exception{
        Entity e = this.mapToEntity(dto);
        return this.mapToDTO(baseService.alterar(e));
    }

    public void deletar(Long id) throws Exception{
        baseService.deletar(id);
    }

    public List<DTO> buscarTodos() {
        return baseService.buscarTodos().stream().map(value->this.mapToDTO(value)).collect(Collectors.toList());
    }

    
}