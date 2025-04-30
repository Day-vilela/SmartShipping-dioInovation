package com.smartshipping.service.strategy;

import com.smartshipping.model.Pedido;
import java.math.BigDecimal;

public class FretePorValorPedido implements FreteStrategy {
    public BigDecimal calcular(Pedido pedido) {
        return pedido.getValor().compareTo(new BigDecimal("200.00")) > 0 ?
                BigDecimal.ZERO : new BigDecimal("25.00");
    }
}
