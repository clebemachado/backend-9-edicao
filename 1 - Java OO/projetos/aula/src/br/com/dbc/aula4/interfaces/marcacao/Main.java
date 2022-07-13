package br.com.dbc.aula4.interfaces.marcacao;

public class Main {
    public static void main(String[] args) {
        Coodernador coodernador = new Coodernador(10000);
        double bonusColaborador = CalculoSalarioColaborador.calcularBonusColaborador(coodernador);
        System.out.printf("R$%.2f", coodernador.getSalario() * bonusColaborador);
    }
}
