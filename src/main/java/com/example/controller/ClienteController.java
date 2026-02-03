package com.example.controller;

import com.example.model.entity.Cliente;
import com.example.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController /// asignarle titulo controller para no ser una simple java class.
@RequestMapping("/api/v1")
public class ClienteController {
    @Autowired
    private ICliente ClienteService;
    @PostMapping("cliente")
    public Cliente create(@RequestBody Cliente cliente){
        return ClienteService.save(cliente);

    }
    @PutMapping("cliente")
    public Cliente update(@RequestBody Cliente cliente){

        return ClienteService.save(cliente);

    }
    @DeleteMapping("cliente/{id}")
    public void delete(@PathVariable Integer id){
    Cliente clienteDelete = ClienteService.findById(id);
    ClienteService.delete(clienteDelete);
    }
    @GetMapping("cliente/{id}")
    public Cliente showById(@PathVariable Integer id){

        return ClienteService.findById(id);
    }
    @GetMapping("cliente/eraser/{id}")
    public Cliente showEraserById(@PathVariable Integer id){

        return ClienteService.EraserById(id);
    }
}
