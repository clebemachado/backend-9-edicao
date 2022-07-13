package br.com.dbc.aula4.interfaces.marcacao;

public class Coodernador implements Funcionario {
    private int salario;

    public Coodernador(int salario) {
        this.salario = salario;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
