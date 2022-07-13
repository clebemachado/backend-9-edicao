package br.com.dbc.aula4.interfaces;

public class Carro extends VeiculoComMotor {
    private int velocidadeMaxima;

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }
}
