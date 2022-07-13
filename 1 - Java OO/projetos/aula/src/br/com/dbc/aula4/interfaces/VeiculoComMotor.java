package br.com.dbc.aula4.interfaces;

public abstract class VeiculoComMotor implements Veiculo, Motor {
    private String modeloMotor;
    private int potencia;
    private int quilometragem;
    private String nome;

    @Override
    public String getModeloMotor() {
        return modeloMotor;
    }

    public void setModeloMotor(String modeloMotor) {
        this.modeloMotor = modeloMotor;
    }

    @Override
    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
