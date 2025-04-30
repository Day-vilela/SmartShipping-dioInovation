package com.smartshipping.controller;

import com.smartshipping.dto.PedidoDTO;
import com.smartshipping.model.Pedido;
import com.smartshipping.service.FreteService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/frete")
public class FreteController {

    private final FreteService freteService;

    public FreteController(FreteService freteService) {
        this.freteService = freteService;
    }

    @PostMapping("/calcular")
    public BigDecimal calcularFrete(@RequestBody PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setPeso(dto.getPeso());
        pedido.setValor(dto.getValor());
        pedido.setDestino(dto.getDestino());
        pedido.setTipoFrete(dto.getTipoFrete());
        return freteService.calcularFrete(pedido);
    }
}
