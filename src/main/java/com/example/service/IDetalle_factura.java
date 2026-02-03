package com.example.service;

import com.example.model.entity.Detalle_Factura;

public interface IDetalle_factura {
    Detalle_Factura save(Detalle_Factura DF);
    Detalle_Factura findById(int id);
    void delete(Detalle_Factura DF);
}
