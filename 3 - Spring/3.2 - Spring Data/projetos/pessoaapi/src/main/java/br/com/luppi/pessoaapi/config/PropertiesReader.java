package br.com.luppi.pessoaapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesReader {
    @Value("${ambiente}")
    private String ambiente;

    public String getAmbiente() {
        return ambiente;
    }
}
