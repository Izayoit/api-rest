package com.example.model.DAO;

import com.example.model.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDAO extends CrudRepository<Producto,Integer> {
    Producto findByIDAndActivoTrue(int id);
    Producto findByIDAndActivoFalse(int id);
}
