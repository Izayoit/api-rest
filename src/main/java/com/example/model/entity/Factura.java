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

public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="total_pagar")
    private BigDecimal total_pagar;
    @Column(name="activo")
    private boolean activo;
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente id_cliente;
}
