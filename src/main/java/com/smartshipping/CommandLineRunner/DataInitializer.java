package com.smartshipping.CommandLineRunner;

import com.smartshipping.model.Pedido;
import com.smartshipping.repository.PedidoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(PedidoRepository repository) {
        return args -> {
            Pedido pedido = new Pedido();
            pedido.setPeso(new BigDecimal("10.0"));
            pedido.setValor(new BigDecimal("150.00"));
            pedido.setDestino("SP");
            pedido.setTipoFrete("peso");

            repository.save(pedido);
        };
    }
}
