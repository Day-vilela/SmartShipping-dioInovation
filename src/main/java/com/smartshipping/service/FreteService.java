package com.smartshipping.service;

import com.smartshipping.model.Pedido;
import com.smartshipping.repository.PedidoRepository;
import com.smartshipping.service.strategy.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FreteService {

    private final PedidoRepository repository;

    public FreteService(PedidoRepository repository) {
        this.repository = repository;
    }

    public BigDecimal calcularFrete(Pedido pedido) {
        FreteStrategy strategy;

        switch (pedido.getTipoFrete().toLowerCase()) {
            case "peso":
                strategy = new FretePorPeso();
                break;
            case "distancia":
                strategy = new FretePorDistancia();
                break;
            case "valor":
                strategy = new FretePorValorPedido();
                break;
            default:
                throw new IllegalArgumentException("Tipo de frete inválido");
        }

        BigDecimal valorFrete = strategy.calcular(pedido);
        repository.save(pedido); // Persistência

        return valorFrete;
    }
}
