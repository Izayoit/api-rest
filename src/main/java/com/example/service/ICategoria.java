package com.example.service;

import com.example.model.entity.Categoria;

public interface ICategoria {
    Categoria FindById(int id);
    Categoria save(Categoria categoria);
    void delete(Categoria categoria);

}