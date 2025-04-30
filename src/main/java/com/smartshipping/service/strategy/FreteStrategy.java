package com.smartshipping.service.strategy;

import com.smartshipping.model.Pedido;
import java.math.BigDecimal;

public interface FreteStrategy {
    BigDecimal calcular(Pedido pedido);
}
