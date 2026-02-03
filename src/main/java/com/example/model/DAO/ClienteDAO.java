package com.example.model.DAO;

import com.example.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/// curdrepositori es una interfase aca firma contrato para que cliente dao tenga sus planos

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
Cliente findByIDAndActivoTrue(Integer id);
Cliente findByIDAndActivoFalse(Integer id);

}
