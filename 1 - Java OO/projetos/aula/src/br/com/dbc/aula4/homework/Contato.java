package br.com.dbc.aula4.homework;

public class Contato {
    String descricao;
    String telefone;
    int tipo; // 1- residencial / 2 - comercial;

    public void imprimirContato(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "descricao='" + descricao + '\'' +
                ", telefone='" + telefone + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
