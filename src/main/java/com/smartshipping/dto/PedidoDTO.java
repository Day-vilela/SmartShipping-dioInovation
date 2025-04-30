package com.smartshipping.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class PedidoDTO {
    private BigDecimal peso;
    private BigDecimal valor;
    private String destino;
    private String tipoFrete;
}
