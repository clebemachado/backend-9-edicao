package br.com.dbc.aula4.homework;

public class Endereco {
    int tipo; // 1- residencial / 2 - comercial;
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    public void imprimirEndereco(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "tipo=" + tipo +
                ", logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
