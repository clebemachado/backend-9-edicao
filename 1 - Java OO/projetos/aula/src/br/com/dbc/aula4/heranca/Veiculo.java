package br.com.dbc.aula4.heranca;

public abstract class Veiculo {
    private int quilometragem;
    private String nome;

    public Veiculo(){

    }

    public Veiculo(String nome){
        this.nome = nome;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract int acelerar();
}
