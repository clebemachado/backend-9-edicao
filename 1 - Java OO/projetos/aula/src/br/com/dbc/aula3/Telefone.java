package br.com.dbc.aula3;

public class Telefone {
    String numero;
    String ddd;
    int tipo; // 1 - residencial, 2 - comercial

    public String toString(){
        return "("+ddd+") "+numero;
    }
}
