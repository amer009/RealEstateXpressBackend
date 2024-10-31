 package com.RealstateXpress.realstatexpress.model;

 import jakarta.persistence.*;
 import lombok.AllArgsConstructor;
 import lombok.Builder;
 import lombok.Data;
 import lombok.NoArgsConstructor;

 import java.util.Date;


 @Entity
 @Data
 @Builder
 @NoArgsConstructor
 @AllArgsConstructor
 public class Usuario {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String nombre;
  @Column(unique = true, nullable = false)
    private String email;
    private Long telefono;
    private String clave;
    private Date fecha;

  @ManyToOne
  @JoinColumn(name = "id_rol")
  private Rol rol;


 }
