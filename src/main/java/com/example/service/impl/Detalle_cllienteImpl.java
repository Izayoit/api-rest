package com.example.service.impl;

import com.example.model.DAO.Detalle_facturaDAO;
import com.example.model.entity.Detalle_Factura;
import com.example.model.entity.Factura;
import com.example.model.entity.Producto;
import com.example.service.IDetalle_factura;
import com.example.service.IFactura;
import com.example.service.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class Detalle_cllienteImpl implements IDetalle_factura {


    @Autowired
    private Detalle_facturaDAO DFDAO;
    @Autowired
    private IFactura FacturaService;
    @Autowired
    private IProducto ProductoService;
    @Transactional
    @Override
    public Detalle_Factura save(Detalle_Factura DF) {
        if(DF.getId()!=0){
           Detalle_Factura DFanterior= DFDAO.findById(DF.getId()).orElse(null);
           if(DFanterior!=null){
               Producto productoA = DFanterior.getProducto();
               int cantidad =DFanterior.getCantidad()+productoA.getStock();
               productoA.setStock(cantidad);
               ProductoService.save(productoA);

              Factura FacturaA = DFanterior.getFactura();
              FacturaA.setTotal_pagar(FacturaA.getTotal_pagar().subtract(DFanterior.getSubtotal()));
              FacturaService.save(FacturaA);


           }
        }
        Producto producto = ProductoService.findById(DF.getProducto().getID());

        BigDecimal precio = producto.getPrecio();
        BigDecimal subtotal = precio.multiply(BigDecimal.valueOf(DF.getCantidad()));
        DF.setSubtotal(subtotal);
        DF.setPrecio_uni(precio);

        int cantidadpedido = DF.getCantidad();
        int cantidadtotal = producto.getStock();

        if(cantidadpedido>cantidadtotal){
            throw new RuntimeException("hubo un problema!\n" +"tu cantidad: "+DF.getCantidad()+"\nCantidad del producto: "+producto.getStock()+ "vuelve a eleguir la cantidad");
        }

        int cantidadReal = cantidadtotal-cantidadpedido;
        producto.setStock(cantidadReal);
        ProductoService.save(producto);
        BigDecimal TotalAnterior;


        Factura factura = FacturaService.findById(DF.getFactura().getId());
        if(factura.getTotal_pagar()!=null){

            TotalAnterior=factura.getTotal_pagar();
        }else{
            TotalAnterior=BigDecimal.ZERO;
        }
        BigDecimal totalAcumulativo= TotalAnterior.add(subtotal);

        factura.setTotal_pagar(totalAcumulativo);
        FacturaService.save(factura);


        DF.setFactura(factura);
        DF.setProducto(producto);
        return DFDAO.save(DF);


    }

    @Transactional(readOnly = true)
    @Override
    public Detalle_Factura findById(int id) {
        return DFDAO.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(Detalle_Factura DF) {
        if(DF.getId()!=0){

            Detalle_Factura DetalleAD = DFDAO.findById(DF.getId()).orElse(null);

            if(DetalleAD!=null) {
                Producto productoAD = DetalleAD.getProducto();

                productoAD.setStock(DF.getCantidad() + productoAD.getStock());
                ProductoService.save(productoAD);

                Factura facturaAD = DetalleAD.getFactura();
                if(facturaAD!=null) {

                    facturaAD.setTotal_pagar(facturaAD.getTotal_pagar().subtract(DetalleAD.getSubtotal()));
                    FacturaService.save(facturaAD);
                }
               DFDAO.delete(DetalleAD);
            }

        }

    }
}
