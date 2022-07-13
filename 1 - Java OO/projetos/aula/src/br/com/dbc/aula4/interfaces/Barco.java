package br.com.dbc.aula4.interfaces;

public class Barco extends VeiculoComMotor {
    private int quantidadeMaximaPassageiros;
    private int velocidadeMaxima;
    private String materialCasco;

    public int getQuantidadeMaximaPassageiros() {
        return quantidadeMaximaPassageiros;
    }

    public void setQuantidadeMaximaPassageiros(int quantidadeMaximaPassageiros) {
        this.quantidadeMaximaPassageiros = quantidadeMaximaPassageiros;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public String getMaterialCasco() {
        return materialCasco;
    }

    public void setMaterialCasco(String materialCasco) {
        this.materialCasco = materialCasco;
    }
}
