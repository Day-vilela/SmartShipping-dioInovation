package com.smartshipping.service.strategy;

import com.smartshipping.model.Pedido;
import java.math.BigDecimal;

public class FretePorDistancia implements FreteStrategy {
    public BigDecimal calcular(Pedido pedido) {
        switch (pedido.getDestino().toUpperCase()) {
            case "SP": return new BigDecimal("20.00");
            case "RJ": return new BigDecimal("30.00");
            default: return new BigDecimal("50.00");
        }
    }
}
