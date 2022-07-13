package br.com.dbc.aula4.interfaces;

public class Carroca implements Veiculo {
    private String nome;
    private int quilometragem;
    private int quantidadeDeCavalos;
    private int velocidadeMaxima;

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public int getQuantidadeDeCavalos() {
        return quantidadeDeCavalos;
    }

    public void setQuantidadeDeCavalos(int quantidadeDeCavalos) {
        this.quantidadeDeCavalos = quantidadeDeCavalos;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }
}
