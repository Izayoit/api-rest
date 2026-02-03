package com.example.controller;

import com.example.model.entity.Factura;
import com.example.service.IFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class FacturaController {
    @Autowired
    private IFactura FacturaService;
    @PostMapping("factura")
    public Factura create(@RequestBody Factura factura){
        return FacturaService.save(factura);
    }
    @GetMapping("factura/{id}")
    public Factura ShowById(@PathVariable Integer id){
        return FacturaService.findById(id);
    }
    @PutMapping("factura")
    public Factura update(@RequestBody Factura factura){
        return FacturaService.save(factura);
    }
    @DeleteMapping("factura/{id}")
    public void delete(int id){
        Factura FacturaDelete = FacturaService.findById(id);
        FacturaService.delete(FacturaDelete);
    }
    @GetMapping("factura/Eraser/{id}")
    public Factura EraserById(@PathVariable Integer id){
        return FacturaService.EraserByid(id);
    }
}
