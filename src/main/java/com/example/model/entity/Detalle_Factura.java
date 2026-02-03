package com.example.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Detalle_Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @ManyToOne
    @JoinColumn(name="id_factura")
    private Factura factura;
    @ManyToOne
    @JoinColumn(name="id_producto")
    private Producto producto;
    @Column(name="cantidad")
    private int cantidad;
    @Column(name="precio_uni")
    private BigDecimal precio_uni;
    @Column(name="subtotal")
    private BigDecimal subtotal;

}
