package com.example.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="producto")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private int ID;
    @Column(name="nombre")
    private String nombre;
    @Column(name="precio")
    private BigDecimal precio;
    @Column(name="activo")
    private boolean activo =true;
    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;
    @Column(name="stock")
    private int stock;
    @Column(name="peso")
    private BigDecimal peso;


}
