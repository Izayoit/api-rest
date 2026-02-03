package com.example.service.impl;

import com.example.model.DAO.ProductoDAO;
import com.example.model.entity.Producto;
import com.example.service.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoImpl implements IProducto {
    @Autowired
    private ProductoDAO productoDAO;
    @Transactional
    @Override
    public Producto save(Producto producto) {

        return productoDAO.save(producto);
    }
    @Transactional(readOnly = true)
    @Override
    public Producto findById(int id) {
        return productoDAO.findByIDAndActivoTrue(id);
    }
    @Transactional
    @Override
    public void delete(Producto producto) {
      producto.setActivo(false);
      productoDAO.save(producto);
    }
    @Transactional(readOnly = true)
    @Override
    public Producto EraserById(int id) {
        return productoDAO.findByIDAndActivoFalse(id);
    }
}
