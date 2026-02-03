package com.example.service.impl;

import com.example.model.DAO.FacturaDAO;
import com.example.model.entity.Factura;
import com.example.service.IFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FacturaImpl implements IFactura {
    @Autowired
    private FacturaDAO facturaDAO;
    @Transactional
    @Override
    public Factura save(Factura factura) {
        return facturaDAO.save(factura);
    }
    @Transactional
    @Override
    public void delete(Factura factura) {
        factura.setActivo(false);
        facturaDAO.save(factura);
    }
    @Transactional(readOnly = true)
    @Override
    public Factura findById(int id) {
        return facturaDAO.findByIdAndActivoTrue(id);
    }
    @Transactional(readOnly = true)
    @Override
    public Factura EraserByid(int id) {
        return facturaDAO.findByIdAndActivoFalse(id);
    }
}
