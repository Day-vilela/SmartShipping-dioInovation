package com.smartshipping.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(
            WebRequest webRequest, ErrorAttributeOptions options) {
        //mapa padrão (timestamp, status, error, path)
        Map<String, Object> attrs = super.getErrorAttributes(webRequest, options);

        attrs.put("1", "FRETE_001");

        attrs.remove(" ");
        return attrs;
    }
}
