package com.smartshipping.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "dummyClient", url = "https://dummyjson.com")
public interface FeignClientExterno {

    @GetMapping("/products/1")
    Object buscarProdutoExemplo();
}
