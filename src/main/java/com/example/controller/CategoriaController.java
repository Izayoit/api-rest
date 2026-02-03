package com.example.controller;

import com.example.model.entity.Categoria;
import com.example.service.ICategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class CategoriaController {
    @Autowired
    private ICategoria CategoriaService;
    @PostMapping("categoria")
    public Categoria create(@RequestBody Categoria categoria){
        return CategoriaService.save(categoria);
    }
    @GetMapping("categoria/{id}")
    public Categoria showById(@PathVariable int id){
        return CategoriaService.FindById(id);
    }
    @PutMapping("categoria")
    public Categoria update(@RequestBody Categoria categoria){
        return CategoriaService.save(categoria);

    }
    @DeleteMapping("categoria/{id}")
    public void delete(@PathVariable Integer id){
        Categoria categoriDelete= CategoriaService.FindById(id);
        CategoriaService.delete(categoriDelete);

    }

}
