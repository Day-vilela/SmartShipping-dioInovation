package com.smartshipping.service.strategy;

import com.smartshipping.model.Pedido;
import java.math.BigDecimal;

public class FretePorPeso implements FreteStrategy {
    public BigDecimal calcular(Pedido pedido) {
        return pedido.getPeso().multiply(new BigDecimal("2.0"));
    }
}
