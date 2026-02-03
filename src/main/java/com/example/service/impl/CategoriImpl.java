package com.example.service.impl;

import com.example.model.DAO.CategoriaDAO;

import com.example.model.entity.Categoria;
import com.example.service.ICategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriImpl implements ICategoria {
    @Autowired
    private CategoriaDAO categoriaDAO;
    @Transactional(readOnly = true)
    @Override
    public Categoria FindById(int id) {
        return categoriaDAO.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public Categoria save(Categoria categoria) {
        return categoriaDAO.save(categoria);
    }
    @Transactional
    @Override
    public void delete(Categoria categoria) {
        categoriaDAO.delete(categoria);
    }

}
