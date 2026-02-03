package com.example.service;

import com.example.model.entity.Factura;

public interface IFactura {
    Factura save(Factura factura);
    void delete(Factura factura);
    Factura findById(int id);
    Factura EraserByid(int id);

}
