package br.com.dbc.aula5;

public class Carro {
    private String modelo;
    private Integer quilometragem;

    public Carro(String modelo, int quilometragem) {
        this.modelo = modelo;
        this.quilometragem = quilometragem;
    }

    public Carro(String modelo){
        this.modelo = modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setQuilometragem(Integer quilometragem){
        this.quilometragem = quilometragem;
    }

    public Integer getQuilometragem(){
        return quilometragem;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "modelo='" + modelo + '\'' +
                ", quilometragem=" + quilometragem +
                '}';
    }
}
