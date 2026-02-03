package com.example.service;

import com.example.model.entity.Producto;

public interface IProducto {
    Producto save(Producto producto);
    Producto findById(int id);
    void delete(Producto producto);
    Producto EraserById(int id);
}
