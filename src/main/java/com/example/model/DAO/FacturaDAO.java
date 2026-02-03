package com.example.model.DAO;

import com.example.model.entity.Factura;
import org.springframework.data.repository.CrudRepository;

public interface FacturaDAO extends CrudRepository<Factura,Integer> {
Factura findByIdAndActivoTrue (int id);
Factura findByIdAndActivoFalse (int id);
}
