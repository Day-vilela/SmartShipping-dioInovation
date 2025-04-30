package com.smartshipping.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal peso;
    private BigDecimal valor;
    private String destino;
    private String tipoFrete;
}


