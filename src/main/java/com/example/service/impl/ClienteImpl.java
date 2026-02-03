package com.example.service.impl;

import com.example.model.DAO.ClienteDAO;
import com.example.model.entity.Cliente;
import com.example.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
/// firmando contrado plano con la casa
public class ClienteImpl implements ICliente {

    @Autowired
private ClienteDAO clienteDAO;
    @Transactional
    @Override
    public Cliente save(Cliente cliente) {
        return clienteDAO.save(cliente);
    }
    @Transactional(readOnly = true)
    @Override
    public Cliente findById(int id) {
     return  clienteDAO.findByIDAndActivoTrue(id);
    }
    @Transactional(readOnly = true)
    @Override
    public Cliente EraserById(int id) {
        return  clienteDAO.findByIDAndActivoFalse(id);
    }


    @Transactional
    @Override
    public void delete(Cliente cliente) {
        cliente.setActivo(false);
        clienteDAO.save(cliente);
    }
}
