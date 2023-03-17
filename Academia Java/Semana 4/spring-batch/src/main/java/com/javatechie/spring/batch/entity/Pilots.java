package com.javatechie.spring.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PILOTS_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pilots {

    @Id
    @Column(name = "PILOTS_ID")
    private int id;
    @Column(name = "NOMBRE")
    private String Nombre;
    @Column(name = "APELLIDO")
    private String Apellido;
    @Column(name = "CORREO")
    private String Correo;
    @Column(name = "GENERO")
    private String Genero;
    @Column(name = "CONTACTO")
    private String Contacto;
    @Column(name = "PAIS")
    private String Pais;
    @Column(name = "FECHA_NACIMIENTO")
    private String Fecha;
    
}
