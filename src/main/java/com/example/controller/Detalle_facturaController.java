package com.example.controller;

import com.example.model.entity.Detalle_Factura;
import com.example.service.IDetalle_factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class Detalle_facturaController {
    @Autowired
    private IDetalle_factura DFService;
    @PostMapping("detalle_factura")
    public Detalle_Factura create(@RequestBody Detalle_Factura DF){
        return DFService.save(DF);
    }
    @PutMapping("detalle_factura")
    public Detalle_Factura update(@RequestBody Detalle_Factura DF){
        return DFService.save(DF);
    }
    @GetMapping("detalle_factura/{id}")
    public Detalle_Factura ShowById(@PathVariable int id){
        return DFService.findById(id);
    }
    @DeleteMapping("detalle_factura/{id}")
    public void delete(@PathVariable int id){
        Detalle_Factura DFdelete = DFService.findById(id);
        if(DFdelete!=null){
        DFService.delete(DFdelete);
}
    }
}
