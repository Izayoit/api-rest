package com.example.controller;

import com.example.model.entity.Producto;
import com.example.service.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class ProductoController {
    @Autowired
    private IProducto ProductoService;
    @PostMapping("producto")
    public Producto create(@RequestBody Producto Producto){

        return ProductoService.save(Producto);

    }
    @PutMapping("producto")
    public Producto update(@RequestBody Producto Producto){

        return ProductoService.save(Producto);

    }
    @DeleteMapping("producto/{id}")
    public void delete(@PathVariable Integer id){
        Producto ProductoDelete = ProductoService.findById(id);
        ProductoService.delete(ProductoDelete);
    }
    @GetMapping("producto/{id}")
    public Producto showById(@PathVariable Integer id){

        return ProductoService.findById(id);
    }
    @GetMapping("producto/eraser/{id}")
    public Producto showEraserById(@PathVariable Integer id){

        return ProductoService.EraserById(id);
    }


}
