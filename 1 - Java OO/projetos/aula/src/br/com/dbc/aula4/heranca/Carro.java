package br.com.dbc.aula4.heranca;

public class Carro extends Veiculo {
    private String modeloMotor;
    private Integer potencia;
    private Integer velocidadeMaxima;

    public Carro(){

    }

    public Carro(String nome){
        super(nome);
    }

    public int acelerar(){
        return ++velocidadeMaxima;
    }

    public String getModeloMotor() {
        return modeloMotor;
    }

    public void setModeloMotor(String modeloMotor) {
        this.modeloMotor = modeloMotor;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public Integer getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(Integer velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }
}
