package com.example.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="cliente")


public class Cliente implements Serializable {
    /// serializable lo envie por bytes
    ///representacion de tu tabla en base de datos hacer el esqueleto para comparar
    ///DAO el unico qu hable con la base de datos crud

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name="Nombre")
    private String Nombre;
    @Column(name="edad")
    private  int edad;
    @Column(name="DNI")
    private int DNI;
    @Column(name="Activo")
    private boolean activo = true;
}
