package br.com.dbc.aula4.interfaces.marcacao;

public final class CalculoSalarioColaborador {
    public static double calcularBonusColaborador(Funcionario funcionario){
        if (funcionario instanceof Gerente) {
            return 1.2;
        } else if (funcionario instanceof Coodernador) {
            return 1.12;
        } else if (funcionario instanceof Operador) {
            return 1.05;
        }
        return 1;
    }
}
