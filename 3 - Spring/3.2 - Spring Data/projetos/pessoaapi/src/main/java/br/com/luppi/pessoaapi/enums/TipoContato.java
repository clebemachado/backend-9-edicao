package br.com.luppi.pessoaapi.enums;

import java.util.Arrays;

public enum TipoContato {
    COMERCIAL(0),
    RESIDENCIAL(1);

    private Integer tipo;

    TipoContato(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }
    public static TipoContato ofTipo(Integer tipo){
        return Arrays.stream(TipoContato.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}
