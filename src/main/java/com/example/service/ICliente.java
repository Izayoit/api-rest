package com.example.service;


import com.example.model.entity.Cliente;
/// intrucciones para ser usadas como deberia ser.
public interface ICliente {

Cliente save(Cliente cliente);

Cliente findById(int id);

void delete(Cliente cliente);

Cliente EraserById(int id);

}