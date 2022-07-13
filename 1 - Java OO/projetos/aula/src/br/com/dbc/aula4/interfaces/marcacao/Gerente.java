package br.com.dbc.aula4.interfaces.marcacao;

public class Gerente implements Funcionario {
    private int salario;

    public Gerente(int salario) {
        this.salario = salario;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
